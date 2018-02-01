package com.trestman.api.petshop.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

//    +---------------------------+---------------+------+-----+---------+----------------+
//    | Field                     | Type          | Null | Key | Default | Extra          |
//    +---------------------------+---------------+------+-----+---------+----------------+
//    | itemid                    | int(11)       | NO   | PRI | NULL    | auto_increment |
//    | productid                 | varchar(10)   | NO   | MUL | NULL    |                |
//    | name                      | varchar(30)   | NO   |     | NULL    |                |
//    | description               | varchar(500)  | NO   |     | NULL    |                |
//    | imageurl                  | varchar(55)   | YES  |     | NULL    |                |
//    | imagethumburl             | varchar(55)   | YES  |     | NULL    |                |
//    | price                     | decimal(14,2) | NO   |     | NULL    |                |
//    | address_addressid         | int(11)       | NO   | MUL | NULL    |                |
//    | contactinfo_contactinfoid | int(11)       | NO   | MUL | NULL    |                |
//    | totalscore                | int(11)       | NO   |     | NULL    |                |
//    | numberofvotes             | int(11)       | NO   |     | NULL    |                |
//    | disabled                  | int(11)       | NO   |     | NULL    |                |
//    +---------------------------+---------------+------+-----+---------+----------------+

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@Getter
@Setter
@Entity(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemid;

    private String name;

    private String description;

    private String imageurl;

    private String imagethumburl;

    private BigDecimal price;

    private Integer totalscore;

    private Integer numberofvotes;

    private Integer disabled;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productid")
    private ProductEntity productEntity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="contactinfo_contactinfoid")
    private SellerEntity sellerEntity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_addressid")
    private AddressEntity addressEntity;
}
