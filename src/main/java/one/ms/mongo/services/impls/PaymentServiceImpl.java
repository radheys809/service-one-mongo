package one.ms.mongo.services.impls;

import lombok.AllArgsConstructor;
import one.ms.mongo.documents.Payment;
import one.ms.mongo.exception.PaymentNotFoundException;
import one.ms.mongo.repositories.PaymentRepository;
import one.ms.mongo.services.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Object doPayment(Payment payment) {
        if (payment.getPaymentId().isBlank() || payment.getPaymentId().isEmpty())
            payment.setPaymentId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    @Override
    public Object getPayment(String paymentId) throws PaymentNotFoundException {
        return paymentRepository.findById(paymentId).orElseThrow(()-> new PaymentNotFoundException("Payment Information Not found for the given Id: "+paymentId));
    }

    @Override
    public Object getAllPayment() {
        final var
        records=paymentRepository.findAll();
        if (records.isEmpty()) throw new PaymentNotFoundException("Payment(s) info is/are not available.");
        return records;
    }
}
