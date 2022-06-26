package one.ms.mongo.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    @Id
    private String paymentId;
    private  Double amount;
    private  PaymentMode mode;
}
