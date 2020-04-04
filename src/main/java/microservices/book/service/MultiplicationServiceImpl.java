package microservices.book.service;

import lombok.RequiredArgsConstructor;
import microservices.book.domain.Multiplication;
import microservices.book.domain.MultiplicationResultAttempt;
import microservices.book.domain.MultiplicationSolvedEvent;
import microservices.book.domain.User;
import microservices.book.event.EventDispatcher;
import microservices.book.repository.MultiplicationResultAttemptRepository;
import microservices.book.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private final RandomGeneratorService randomGeneratorService;
    private final MultiplicationResultAttemptRepository attemptRepository;
    private final UserRepository userRepository;
    private final EventDispatcher eventDispatcher;

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {

        // 사용자 존재유무 확인
        Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());

        Assert.isTrue(!resultAttempt.isCorrect(), "채점한 상태로 보낼 수 없습니다!!");

        // 답안 채점
        boolean isCorrect = resultAttempt.getResultAttempt() ==
                (resultAttempt.getMultiplication().getFactorA() *
                        resultAttempt.getMultiplication().getFactorB());

        MultiplicationResultAttempt checkedAtempt = new MultiplicationResultAttempt(
                user.orElse(resultAttempt.getUser()),
                resultAttempt.getMultiplication(),
                resultAttempt.getResultAttempt(),
                isCorrect
        );

        attemptRepository.save(checkedAtempt);

        // 이벤트로 결과를 전송
        eventDispatcher.send(new MultiplicationSolvedEvent(
                checkedAtempt.getId(),
                checkedAtempt.getUser().getId(),
                checkedAtempt.isCorrect())
        );

        return isCorrect;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }

    @Override
    public MultiplicationResultAttempt getResultById(final Long resultId) {
        return attemptRepository.findById(resultId).orElseThrow(() -> new IllegalArgumentException("not found entity id : " + resultId));
    }
}
