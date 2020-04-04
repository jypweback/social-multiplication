package microservices.book.service;

import microservices.book.domain.Multiplication;
import microservices.book.domain.MultiplicationResultAttempt;

import java.util.List;

public interface MultiplicationService {

    /**
     * 두개의 무작위 인수를 담은 Multiplication 객체를 생성한다.
     * 무작위로 생성되는 숫자의 범위는 11~99
     *
     * @return 무작위 인수를 담은 객체 {@link Multiplication}
     */
    Multiplication createRandomMultiplication();

    /**
     * @result 곱셈 결과가 맞으면 true, 아니면 false
     */
    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

    List<MultiplicationResultAttempt> getStatsForUser(String userAlias);

    MultiplicationResultAttempt getResultById(final Long resultId);
}