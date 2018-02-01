package com.trestman.api.petshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Locale;

//    +-------------+--------------+------+-----+---------+-------+
//    | Field       | Type         | Null | Key | Default | Extra |
//    +-------------+--------------+------+-----+---------+-------+
//    | productid   | varchar(10)  | NO   | PRI | NULL    |       |
//    | categoryid  | varchar(10)  | NO   | MUL | NULL    |       |
//    | name        | varchar(25)  | NO   |     | NULL    |       |
//    | description | varchar(255) | NO   |     | NULL    |       |
//    | imageurl    | varchar(55)  | YES  |     | NULL    |       |
//    +-------------+--------------+------+-----+---------+-------+

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@Entity(name = "product")
public class ProductEntity {

    @Id
    private String productid;

    private String name;

    private String description;

    private String imageurl;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoryid")
    private CategoryEntity categoryEntity;
}
