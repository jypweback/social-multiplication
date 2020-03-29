package microservices.book.repository;

import microservices.book.domain.Multiplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by qkrwpdud1@gmail.com on 2020/03/30
 * Github : http://github.com/jypweback
 * Description :
 */

public interface MultiplicationRepository extends JpaRepository<Multiplication, Long> {
}
