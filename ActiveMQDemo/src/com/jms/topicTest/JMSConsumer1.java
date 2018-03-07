package com.jms.topicTest;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
/**
 * @Author Loujitao
 * @Date 2018/2/5
 * @Time  9:30
 * @Description: topic方式，先启动consumer，后启动生产者
 */
public class JMSConsumer1 {

    private static final String USERNAME = "admin";//默认连接用户名
    private static final String PASSWORD = "admin";//默认连接密码
    private static final String BROKEURL = "tcp://172.17.70.49:61616";//默认连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接

        Session session;//会话 接受或者发送消息的线程
        Destination destination;//消息的目的地

        MessageConsumer messageConsumer;//消息的消费者

        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSConsumer1.USERNAME, JMSConsumer1.PASSWORD, JMSConsumer1.BROKEURL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建一个连接HelloWorld的消息队列
            destination = session.createTopic("device");
            //创建消息消费者
            messageConsumer = session.createConsumer(destination);
            while (true){
            Message msg=messageConsumer.receive();
            if(msg instanceof TextMessage){
                TextMessage textMessage = (TextMessage) msg;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if(msg instanceof ObjectMessage){
                ObjectMessage objectMessage= (ObjectMessage) msg;
                System.out.println(objectMessage);
            }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
