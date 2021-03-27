package guru.springframework.sfgrestbrewery.domain;

import guru.springframework.sfgrestbrewery.web.model.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by jt on 2019-05-25.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
public class Beer {

//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//    @Type(type="org.hibernate.type.UUIDCharType")
//    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)

    @Id
    private Integer id;

  //  @Version
    private Long version;

    private String beerName;
    private BeerStyleEnum beerStyle;
    private String upc;

    private Integer quantityOnHand;
    private BigDecimal price;

//    @CreationTimestamp
//    @Column(updatable = false)
    private LocalDateTime createdDate;

//    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;
}
