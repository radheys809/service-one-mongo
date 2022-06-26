package one.ms.mongo.repositories;

import one.ms.mongo.documents.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends MongoRepository<Payment,String> {

}
