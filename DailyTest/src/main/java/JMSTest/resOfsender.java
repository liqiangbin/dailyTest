package JMSTest;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import net.sf.json.JSONObject;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class resOfsender {
	 public static void main(String[] args) {  
	        // ConnectionFactory ：连接工厂，JMS 用它创建连接  
	        ConnectionFactory connectionFactory;  
	        // Connection ：JMS 客户端到JMS Provider 的连接  
	        Connection connection = null;  
	        // Session： 一个发送或接收消息的线程  
	        Session session;  
	        // Destination ：消息的目的地;消息发送给谁.  
	        //接收回复消息用
	        Destination resOfSend; 
	        
	        MessageProducer producer; 
	        // 消费者，消息接收者  
	        MessageConsumer consumer;  
	     // 消费者，消息接收者  
	        connectionFactory = new ActiveMQConnectionFactory(  
	                ActiveMQConnection.DEFAULT_USER,  
	                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");  
	        try {  
	            // 构造从工厂得到连接对象  
	            connection = connectionFactory.createConnection();  
	            // 启动  
	            connection.start();  
	            // 获取操作连接  
	            session = connection.createSession(Boolean.FALSE,  
	                    Session.AUTO_ACKNOWLEDGE);  
	            // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置  
	            resOfSend=session.createQueue("receiver");
	            consumer = session.createConsumer(resOfSend); 
	            // 设置不持久化，此处学习，实际根据项目决定  
	           
	          while (true) {  
	                // 设置接收者接收消息的时间，为了便于测试，这里谁定为100s  
	                TextMessage message = (TextMessage) consumer.receive();  //100000
	                if (null != message) {  
	                    System.out.println("收到消息" + message.getText()); 
	                } else {  
	                    break;  
	                }  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            try {  
	                if (null != connection)  
	                    connection.close();  
	            } catch (Throwable ignore) {  
	            }  
	        }  
	    } 
}
