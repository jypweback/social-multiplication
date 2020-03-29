package microservices.book.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * {@link User}가 {@link Multiplication}을 계산한 답안을 정의하는 클래스
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class MultiplicationResultAttempt {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private final User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MULTIPLICATION_ID")
    private final Multiplication multiplication;

    private final int resultAttempt;
    private final boolean correct;

    // JSON (역) 직렬화를 위한 빈 생성자
    protected MultiplicationResultAttempt(){
        this.user = null;
        this.multiplication = null;
        this.resultAttempt = -1;
        this.correct = false;
    }

}
