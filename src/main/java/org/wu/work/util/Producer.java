package org.wu.work.util;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("wzw");
        factory.setPassword("123456");
        //设置 RabbitMQ 地址
        factory.setHost("localhost");
        
        //设置RabbitMQ VirtualHost 如果不设置，则使用默认的VirtualHost："/"
//        factory.setVirtualHost("test");
        //建立到代理服务器到连接
        Connection conn = factory.newConnection();
        //获得信道
        Channel channel = conn.createChannel();
        //声明交换器
        String exchangeName = "myExchange1";
        channel.exchangeDeclare(exchangeName, "direct", true);

        String routingKey = "foo.abcde";
        //发布消息
        byte[] messageBodyBytes = "hello world322342353!".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

        channel.close();
        conn.close();
    }
}
