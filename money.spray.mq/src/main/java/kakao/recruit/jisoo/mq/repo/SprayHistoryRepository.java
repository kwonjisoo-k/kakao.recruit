package kakao.recruit.jisoo.mq.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kakao.recruit.jisoo.mq.dto.SprayHistory;

public interface SprayHistoryRepository extends CrudRepository<SprayHistory, Integer> {

    @Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE spray_history set r_user = :r_user, r_succ='Y' where id = :id",nativeQuery = true)
	void update(@Param("id") int id,@Param("r_user") String r_user);
    
    
    @Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="select * from spray_history where s_user = :s_user",nativeQuery = true)
	List<SprayHistory> select(@Param("s_user") String s_user);
}
