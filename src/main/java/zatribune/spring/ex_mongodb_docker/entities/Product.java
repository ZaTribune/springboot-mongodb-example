package zatribune.spring.ex_mongodb_docker.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
/**
 * Created by ZaTribune on 22/jan/2021.
 */
@Getter
@Setter
@NoArgsConstructor
@Document
public class Product {
    @Id
    private ObjectId id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    @DBRef
    private User user;

}
