package com.example.dampouring.util;

import com.example.dampouring.common.Constant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {
    /**
     * 建立与RabbitMQ的连接
     *
     * @return
     * @throws Exception
     */

    private final static String QUEUE_NAME = "ydy.direct.tc";
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost(Constant.mqIp);
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("/szgc-ydy");//设置虚拟机，一个mq服务可以设置多个虚拟机，每个虚拟机就相当于一个独立的mq
        factory.setUsername("szgc-ydy-tc");
        factory.setPassword("szgc-ydy-tc");
        factory.setConnectionTimeout(500);
        // 通过工厂获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
    public  static void Send(String str) {
        try {
            // 1、获取到连接
            Connection connection = getConnection();
            // 2、从连接中创建通道，使用通道才能完成消息相关的操作
            Channel channel = connection.createChannel();
            // 3、声明（创建）队列
            //参数：String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
            /**
             * 参数明细
             * 1、queue 队列名称
             * 2、durable 是否持久化，如果持久化，mq重启后队列还在
             * 3、exclusive 是否独占连接，队列只允许在该连接中访问，如果connection连接关闭队列则自动删除,如果将此参数设置true可用于临时队列的创建
             * 4、autoDelete 自动删除，队列不再使用时是否自动删除此队列，如果将此参数和exclusive参数设置为true就可以实现临时队列（队列不用了就自动删除）
             * 5、arguments 参数，可以设置一个队列的扩展参数，比如：可设置存活时间
             */
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            // 向指定的队列中发送消息
            //参数：String exchange, String routingKey, BasicProperties props, byte[] body
            /**
             * 参数明细：
             * 1、exchange，交换机，如果不指定将使用mq的默认交换机（设置为""）
             * 2、routingKey，路由key，交换机根据路由key来将消息转发到指定的队列，如果使用默认交换机，routingKey设置为队列的名称
             * 3、props，消息的属性
             * 4、body，消息内容
             */
            channel.basicPublish("ydy.direct", QUEUE_NAME, null, str.getBytes());
            Constant.print(" [RMQ] Sent '" + str + "'");
            //关闭通道和连接(资源关闭最好用try-catch-finally语句处理)
            channel.close();
            connection.close();
        } catch (Exception ignored) {
            ;
        }
    }
}

