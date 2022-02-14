package com.zap.office.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zap.office.commonutils.JwtUtils;
import com.zap.office.commonutils.MyException;
import com.zap.office.entity.Employee;
import com.zap.office.entity.User;
import com.zap.office.entity.vo.EmpUserVo;
import com.zap.office.mapper.EmployeeMapper;
import com.zap.office.mapper.UserCenterMapper;
import com.zap.office.service.UserCenterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author: ZhuApeng
 * @Title: UserLoginServiceImpl
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/11/29 19:58
 */
@Service
public class UserCenterServiceImpl extends ServiceImpl<UserCenterMapper,User> implements UserCenterService {
    @Autowired
    UserCenterMapper userCenterMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public String userLogin(User user) {
        User userInfo = userCenterMapper.userLogin(user);
        if(!user.getUserName().equals(userInfo.getUserName())){
            throw new MyException(20002,"用户名不存在！");
        }
        if(!user.getPassWord().equals(userInfo.getPassWord())){
            throw new MyException(20002,"用户密码错误！");
        }
        String jwtToken = JwtUtils.getJwtToken(userInfo.getId(), userInfo.getUserName());
        return jwtToken;
    }

    @Override
    public boolean userRegister(EmpUserVo empUserVo) {
        String userName = empUserVo.getUserName();
        String passWord = empUserVo.getPassWord();
        String empPhone = empUserVo.getEmpPhone();
        String checkWord = empUserVo.getCheckWord();
        if(StringUtils.isEmpty(checkWord)){
            throw new MyException(20003,"验证码已过期！请重新发送");
        }
        if(StringUtils.isEmpty(userName)&&StringUtils.isEmpty(passWord)&&StringUtils.isEmpty(empPhone)){
            throw new MyException(20001,"请将信息填写完整！");
        }
        EmpUserVo empUserInfo = userCenterMapper.getEmpUserVo(empUserVo);
//        System.out.println(empUserInfo);
        if(!StringUtils.isEmpty(empUserInfo)){
            throw new MyException(20001,"信息已被占中！");
        }

        String checkNum = (String) redisTemplate.opsForValue().get("checkNum");
        if(!checkNum.equals(checkWord)){
            throw new MyException(20003,"验证码不正确，请重新输入！");
        }
        User user = new User();
        BeanUtils.copyProperties(empUserVo,user);
        try {
            int userFlag = userCenterMapper.insert(user);
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("user_name",userName);
            User getUser = userCenterMapper.selectOne(wrapper);
            Employee employee = new Employee();
            employee.setUserId(getUser.getId());
            BeanUtils.copyProperties(empUserVo,employee);
            int empFlag = employeeMapper.insert(employee);
            if(userFlag!=-1&&empFlag!=-1){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(20001,"插入数据不成功！");
        }
    }

    @Override
    public boolean getCheckNum(String empPhone,String code) {
        if(StringUtils.isEmpty(empPhone)){
            throw new MyException(20002,"未获取到用户的邮箱号！");
        }
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setSubject("朱阿鹏特此通知");//设置邮件的主题
            mailMessage.setText("尊敬的用户:你好，快来接旨！\n 您的注册验证码为:" + code+"\n"+"么么哒！(有效期为5分钟)");//设置邮件的内容
            mailMessage.setFrom("1641984918@qq.com");
            mailMessage.setTo(empPhone);
            mailSender.send(mailMessage);
            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
    }
}
