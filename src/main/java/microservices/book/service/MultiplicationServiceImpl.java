package microservices.book.service;

import lombok.RequiredArgsConstructor;
import microservices.book.domain.Multiplication;
import microservices.book.domain.MultiplicationResultAttempt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MultiplicationServiceImpl implements MultiplicationService {

    private final RandomGeneratorService randomGeneratorService;

    @Override
    public Multiplication createRandomMultiplication() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Override
    public boolean checkAttempt(MultiplicationResultAttempt resultAttempt) {
        return resultAttempt.getResultAttempt() == (resultAttempt.getMultiplication().getFactorA() * resultAttempt.getMultiplication().getFactorB());
    }
}
