package JMSTest;
import javax.jms.Connection;  
import javax.jms.DeliveryMode;  
import javax.jms.MessageProducer;  
import javax.jms.Queue;  
import javax.jms.Session;  
import org.apache.activemq.ActiveMQConnectionFactory;  
import org.apache.activemq.command.ActiveMQQueue;  
public class DeliveryModeSendTest {  
    public static void main(String[] args) throws Exception {  
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");  
     
        Connection connection = factory.createConnection();  
        connection.start();  
         
        Queue queue = new ActiveMQQueue("Bin");  
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);  
                 
        MessageProducer producer = session.createProducer(queue);  
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);  
        producer.send(session.createTextMessage("A persistent Message"));  
         
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);  
        producer.send(session.createTextMessage("A non persistent Message"));  
         
        System.out.println("Send messages sucessfully!");  
    }  
}  