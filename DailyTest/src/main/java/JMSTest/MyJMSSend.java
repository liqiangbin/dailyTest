package JMSTest;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class MyJMSSend {

	public static void main(String[] args) throws JMSException {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");  
        Connection connection = factory.createConnection();  
        connection.start();  
         
        //消息发送到这个Queue  
        Queue queue = new ActiveMQQueue("testQueue");  
        //消息回复到这个Queue  
//        Queue replyQueue = new ActiveMQQueue("replyQueue");  
         
        final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
        //创建一个消息，并设置它的JMSReplyTo为replyQueue。  
        Message message = session.createTextMessage("Bin发送消息");  
//        message.setJMSReplyTo(replyQueue);  
         
        MessageProducer producer = session.createProducer(queue);  
        producer.send(message);  
      
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
