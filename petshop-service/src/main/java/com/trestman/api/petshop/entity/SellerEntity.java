package com.trestman.api.petshop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//    +---------------+-------------+------+-----+---------+----------------+
//    | Field         | Type        | Null | Key | Default | Extra          |
//    +---------------+-------------+------+-----+---------+----------------+
//    | contactinfoid | int(11)     | NO   | PRI | NULL    | auto_increment |
//    | lastname      | varchar(24) | NO   |     | NULL    |                |
//    | firstname     | varchar(24) | NO   |     | NULL    |                |
//    | email         | varchar(24) | NO   |     | NULL    |                |
//    +---------------+-------------+------+-----+---------+----------------+

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@Entity(name = "seller")
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contactinfoid;

    private String lastname;

    private String firstname;

    private String email;
}
