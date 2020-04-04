package microservices.book.controller;

import lombok.RequiredArgsConstructor;
import microservices.book.domain.MultiplicationResultAttempt;
import microservices.book.service.MultiplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;

    @PostMapping
    ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {

        boolean correct = multiplicationService.checkAttempt(multiplicationResultAttempt);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(
                multiplicationResultAttempt.getUser(),
                multiplicationResultAttempt.getMultiplication(),
                multiplicationResultAttempt.getResultAttempt(),
                correct);

        return ResponseEntity.ok(attempt);
    }

    @GetMapping
    ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
    }

    @GetMapping("/{resultId}")
    ResponseEntity<MultiplicationResultAttempt> getResultById(final @PathVariable("resultId") Long resultId){
        return ResponseEntity.ok(multiplicationService.getResultById(resultId));
    }

//    @RequiredArgsConstructor
//    @NoArgsConstructor(force = true)
//    @Getter
//    static final class ResultResponse{
//        private final boolean correct;
//    }

}
