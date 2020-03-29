package microservices.book.domain;

import com.sun.org.apache.xpath.internal.operations.Mult;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * {@link User}가 {@link Multiplication}을 계산한 답안을 정의하는 클래스
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class MultiplicationResultAttempt {

    private final User user;
    private final Multiplication multiplication;
    private final int resultAttempt;

    // JSON (역) 직렬화를 위한 빈 생성자
    MultiplicationResultAttempt(){
        this.user = null;
        this.multiplication = null;
        this.resultAttempt = -1;
    }

}
