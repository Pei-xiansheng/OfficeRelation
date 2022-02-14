package com.zap.office.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: ZhuApeng
 * @Title: MyMeta
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/10/14 11:44
 */

//利用添加和修改操作自动调用类中的方法实现自动填充
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //添加调用
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
    //修改调用
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}

