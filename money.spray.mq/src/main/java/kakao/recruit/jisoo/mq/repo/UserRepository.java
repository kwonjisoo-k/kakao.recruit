package kakao.recruit.jisoo.mq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kakao.recruit.jisoo.mq.dto.User;

public interface UserRepository {
    User findByUsernameAndPassword(String username, String password);
}
