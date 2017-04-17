package JMSTest;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class MyJMSReceiver {
	 public static void main(String[] args) throws Exception {  
	        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");  
	     
	        Connection connection = factory.createConnection();  
	        connection.start();  
	         
	        Queue queue = new ActiveMQQueue("testQueue");  
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
	         
	        MessageConsumer comsumer = session.createConsumer(queue);  
	        comsumer.setMessageListener(new MessageListener(){  
	            public void onMessage(Message m) {  
	                try {  
	                    System.out.println("接收到消息： "+ ((TextMessage)m).getText());  
	                } catch (JMSException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        });  
	    }  

}
