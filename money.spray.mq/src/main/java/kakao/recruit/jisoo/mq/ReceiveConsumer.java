package kakao.recruit.jisoo.mq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ReceiveConsumer implements ExceptionListener {
    public String run(String pRoomId) {
        try {

            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            connection.setExceptionListener(this);

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue(pRoomId);

            // Create a MessageConsumer from the Session to the Topic or Queue
            MessageConsumer consumer = session.createConsumer(destination);

            // Wait for a message
            Message message = consumer.receive(1000);
            String text = "";
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                text = textMessage.getText();
                System.out.println("Received: " + text);
            } else {
                System.out.println("Received: " + message);
            }

            consumer.close();
            session.close();
            connection.close();
            
            return text;
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
		return null;
    }


	
	 public synchronized void onException(JMSException ex) {
	  System.out.println("JMS Exception occured.  Shutting down client."); 
	 }
	 
}