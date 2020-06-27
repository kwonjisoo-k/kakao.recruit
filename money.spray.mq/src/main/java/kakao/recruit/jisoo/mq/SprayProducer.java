package kakao.recruit.jisoo.mq;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

	/*
	 * public static void main(String[] args) throws Exception { thread(new
	 * HelloWorldProducer(), false); thread(new HelloWorldProducer(), false);
	 * thread(new HelloWorldConsumer(), false); Thread.sleep(1000); thread(new
	 * HelloWorldConsumer(), false); thread(new HelloWorldProducer(), false);
	 * thread(new HelloWorldConsumer(), false); thread(new HelloWorldProducer(),
	 * false); Thread.sleep(1000); thread(new HelloWorldConsumer(), false);
	 * thread(new HelloWorldProducer(), false); thread(new HelloWorldConsumer(),
	 * false); thread(new HelloWorldConsumer(), false); thread(new
	 * HelloWorldProducer(), false); thread(new HelloWorldProducer(), false);
	 * Thread.sleep(1000); thread(new HelloWorldProducer(), false); thread(new
	 * HelloWorldConsumer(), false); thread(new HelloWorldConsumer(), false);
	 * thread(new HelloWorldProducer(), false); thread(new HelloWorldConsumer(),
	 * false); thread(new HelloWorldProducer(), false); thread(new
	 * HelloWorldConsumer(), false); thread(new HelloWorldProducer(), false);
	 * thread(new HelloWorldConsumer(), false); thread(new HelloWorldConsumer(),
	 * false); thread(new HelloWorldProducer(), false); }
	 * 
	 * public static void thread(Runnable runnable, boolean daemon) { Thread
	 * brokerThread = new Thread(runnable); brokerThread.setDaemon(daemon);
	 * brokerThread.start(); }
	 */

    public class SprayProducer{
    	private static final int TEN_MINUTES = 10 * 60 * 1000;
        public boolean run(String pRoomId,String pToken) {
            try {
                // Create a ConnectionFactory
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

                // Create a Connection
                Connection connection = connectionFactory.createConnection();
                connection.start();

                // Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                // Create the destination (Topic or Queue)
                Destination destination = session.createQueue(pRoomId);

                // Create a MessageProducer from the Session to the Topic or Queue
                MessageProducer producer = session.createProducer(destination);
                producer.setTimeToLive(TEN_MINUTES);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

                // Create a messages
                String text = pToken;
                TextMessage message = session.createTextMessage(text);

                // Tell the producer to send the message
                System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
                producer.send(message);

               
                // Clean up
                session.close();
                connection.close();
                return true;
            }
            catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
                return false;
                
                
            }
        }
    }

   

