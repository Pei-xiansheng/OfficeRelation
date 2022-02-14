package com.zap.office.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author: ZhuApeng
 * @Title: MyMailSender
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/12/3 21:16
 */

@Configuration
public class MyMailSender {
    @Bean
    public JavaMailSenderImpl getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("1641984918@qq.com");
        mailSender.setPassword("mwdjqdkcbzxkgbeg");
        return mailSender;
    }
}
