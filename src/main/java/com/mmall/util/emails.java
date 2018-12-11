package com.mmall.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class emails {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Properties prop = new Properties();
        prop.put("mail.host", "smtp.163.com");
        prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");
        try {
            // 使用java发送邮件5步骤
            // 1.创建sesssion
            Session session = Session.getInstance(prop);
            // 开启session的调试模式，可以查看当前邮件发送状态
            session.setDebug(true);


            Transport ts;
            // 2.通过session获取Transport对象（发送邮件的核心API）
            ts = session.getTransport();
            // 3.通过邮件用户名密码链接
            ts.connect("meishibushi@163.com", "2163128hjm");
            // 4.创建邮件
            Message msg = createSimpleMail(session);
            // 5.发送电子邮件
            ts.sendMessage(msg, msg.getAllRecipients());


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    public static MimeMessage createSimpleMail(Session session)
            throws AddressException, MessagingException {
        // 创建邮件对象
        MimeMessage mm = new MimeMessage(session);
        // 设置发件人
        mm.setFrom(new InternetAddress("meishibushi@163.com"));
        // 设置收件人
        mm.setRecipient(Message.RecipientType.TO, new InternetAddress(
                "meishibushi@163.com"));
        // 设置抄送人
        //mm.setRecipient(Message.RecipientType.CC, new InternetAddress(
        //      "用户名@163.com"));

        //设置邮件标题
        mm.setSubject("这是邮件题目");

        //设置邮件内容
        mm.setContent("这是邮件内容啊！！！", "text/html;charset=utf-8");


        return mm;
    }
}