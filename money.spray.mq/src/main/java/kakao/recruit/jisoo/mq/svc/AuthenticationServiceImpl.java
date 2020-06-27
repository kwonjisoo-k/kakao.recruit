package kakao.recruit.jisoo.mq.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import kakao.recruit.jisoo.mq.dto.User;
import kakao.recruit.jisoo.mq.repo.UserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
    public AuthenticationServiceImpl() {
        
    }

    @Override
    public User authentication(String token) {
        try {
            // authorization으로부터 type과 credential을 분리
			/*
			 * String[] split = token.split(" "); String type = split[0]; String credential
			 * = split[1];
			 * 
			 * if ("Basic".equalsIgnoreCase(type)) { // credential을 디코딩하여 username과
			 * password를 분리 String decoded = new
			 * String(Base64Utils.decodeFromString(credential)); String[]
			 * usernameAndPassword = decoded.split(":");
			 * 
			 * User user = userRepository.findByUsernameAndPassword(usernameAndPassword[0],
			 * usernameAndPassword[1]); if (user == null) throw new
			 * Error("Invalid credentials"); else return user;
			 * 
			 * } else { throw new Error("Unsupported type: " + type);
			 * 
			 * }
			 */
        	User user = new User("a","b");
        	System.out.println(token);
        	return user;
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
            throw new Error("Invalid credentials");
        }
    }

}