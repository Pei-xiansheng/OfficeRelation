package com.zap.office.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zap.office.entity.User;
import com.zap.office.mapper.UserCenterMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhuApeng
 * @Title: ViewInterceptor
 * @ProjectName: OfficeRelation
 * @Description: 人数浏览量
 * @date: 2021/11/1 12:01
 */
@Component
public class ViewInterceptor implements HandlerInterceptor {
    public static final String APP_SECRET = "zhuapengshizuishuaideren";

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserCenterMapper userCenterMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        ValueOperations opsForValue = redisTemplate.opsForValue();
//        opsForValue.increment(uri);
        String token = request.getHeader("token");
        Jws<Claims> cliams = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claim = cliams.getBody();
        String userName = (String) claim.get("userName");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",userName);
        User user = userCenterMapper.selectOne(wrapper);
        if(!StringUtils.isEmpty(user)){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
