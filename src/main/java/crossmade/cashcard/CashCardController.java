package crossmade.cashcard;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

    private final CashCardRepository _cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository) {
        _cashCardRepository = cashCardRepository;
    }

    @GetMapping("/{requestedId}")
    public ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {

        Optional<CashCard> cashCardOptional = _cashCardRepository.findById(requestedId);

        if (!cashCardOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(cashCardOptional.get());
        }
    }
}
