package kakao.recruit.jisoo.mq.svc;

import kakao.recruit.jisoo.mq.dto.User;

public interface AuthenticationService {
	User authentication(String token);
}
