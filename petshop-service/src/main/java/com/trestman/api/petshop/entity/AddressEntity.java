package com.trestman.api.petshop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

//    +-----------+----------------+------+-----+---------+----------------+
//    | Field     | Type           | Null | Key | Default | Extra          |
//    +-----------+----------------+------+-----+---------+----------------+
//    | addressid | int(11)        | NO   | PRI | NULL    | auto_increment |
//    | street1   | varchar(55)    | NO   |     | NULL    |                |
//    | street2   | varchar(55)    | YES  |     | NULL    |                |
//    | city      | varchar(55)    | NO   |     | NULL    |                |
//    | state     | varchar(25)    | NO   |     | NULL    |                |
//    | zip       | varchar(5)     | NO   |     | NULL    |                |
//    | latitude  | decimal(14,10) | NO   |     | NULL    |                |
//    | longitude | decimal(14,10) | NO   |     | NULL    |                |
//    +-----------+----------------+------+-----+---------+----------------+

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@Getter
@Setter
@Entity(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressid;

    private String street1;

    private String street2;

    private String city;

    private String state;

    private String zip;

    private BigDecimal latitude;

    private BigDecimal longitude;
}
