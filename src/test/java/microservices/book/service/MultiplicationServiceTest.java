package microservices.book.service;

import microservices.book.domain.Multiplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {

    @MockBean
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private MultiplicationService multiplicationService;

//    @Test
//    public void createRandomMultiplicationTest(){
//
//        // given
//        given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);
//
//        // when
//        Multiplication multiplication = multiplicationService.createRandomMultiplication();
//
//
//        // assert
//        assertThat(multiplication.getFactorA()).isEqualTo(50);
//        assertThat(multiplication.getFactorB()).isEqualTo(30);
//        assertThat(multiplication.getResult()).isEqualTo(1500);
//
//
//    }

}