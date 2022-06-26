package one.ms.mongo.services;

import one.ms.mongo.documents.Payment;
import one.ms.mongo.exception.PaymentNotFoundException;

public interface PaymentService {

    Object doPayment(Payment payment);
    Object getPayment(String paymentId) throws PaymentNotFoundException;
    Object getAllPayment()throws PaymentNotFoundException;
}
