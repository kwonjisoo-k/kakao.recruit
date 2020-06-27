package kakao.recruit.jisoo.mq;

import kakao.recruit.jisoo.mq.dto.User;
import kakao.recruit.jisoo.mq.svc.JwtServiceImpl;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User tmp = new User("user1","user1");
		User tmp2 = new User("user2","user2");
		User tmp3 = new User("user3","user3");
		JwtServiceImpl jwtService = new JwtServiceImpl();
		String tToken = jwtService.create("1000",tmp,"user1");
		String tToken2 = jwtService.create("1001",tmp2,"user2");
		String tToken3 = jwtService.create("1002",tmp3,"user3");
		System.out.println(tToken);
		System.out.println(tToken2);
		System.out.println(tToken3);
	}

}
