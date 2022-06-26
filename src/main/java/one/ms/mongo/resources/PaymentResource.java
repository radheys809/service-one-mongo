package one.ms.mongo.resources;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import one.ms.mongo.documents.Payment;
import one.ms.mongo.services.PaymentService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
@Slf4j
public class PaymentResource {
    private final PaymentService paymentService;

    @GetMapping({"/", ""})
    public ResponseEntity<Object> pulseCheck() {
        return ResponseEntity.ok(Map.of("pulseStatus", "breathing", "timeStamp", LocalDateTime.now()));
    }

    @PostMapping("/doPay")
    public ResponseEntity<Object> makePayment(@RequestBody Optional<Payment> payment) {
        try {
            if (payment.isPresent())
                return ResponseEntity.ok(paymentService.doPayment(payment.get()));
            else throw new RuntimeException("Request can't be empty");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception while cprocessing a payment");
            throw e;
        }

    }

    @GetMapping("/order/{paymentId}/get")
    public ResponseEntity<Object> getPayment(@PathVariable String paymentId) {
        return ResponseEntity.ok(paymentService.getPayment(paymentId));
    }

    @GetMapping("/orders/get")
    public ResponseEntity<Object> getPayment() {
        return ResponseEntity.ok(paymentService.getAllPayment());
    }
}
