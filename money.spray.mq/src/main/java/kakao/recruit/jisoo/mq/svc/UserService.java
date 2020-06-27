package kakao.recruit.jisoo.mq.svc;

import kakao.recruit.jisoo.mq.dto.User;

public interface UserService {
    // 인증 & 개인정보 조회
    User authentication(String token);
   
}