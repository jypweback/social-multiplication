package microservices.book.repository;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description :
 */

import microservices.book.domain.MultiplicationResultAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 답안을 저장하고 조회하기 위한 인터페이스
 */
@Repository
public interface MultiplicationResultAttemptRepository extends JpaRepository<MultiplicationResultAttempt, Long> {

    /**
     *  닉네임에 해당하는 사용자의 최근답안 5개
     * @param userAlias
     * @return
     */
    List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);
}
