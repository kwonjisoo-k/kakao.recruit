package kakao.recruit.jisoo.mq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("java2blog.queue");
	}
}
