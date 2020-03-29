package microservices.book.repository;

import microservices.book.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description :
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAlias(final String alias);
}
