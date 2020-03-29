package microservices.book.controller;

import lombok.RequiredArgsConstructor;
import microservices.book.domain.Multiplication;
import microservices.book.service.MultiplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

    private final MultiplicationService multiplicationService;

    @GetMapping("/random")
    Multiplication getRandomMultiplication(){
        return multiplicationService.createRandomMultiplication();
    }

    
}
