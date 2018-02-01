package com.trestman.api.petshop.entity;


//    +-------------+--------------+------+-----+---------+-------+
//    | Field       | Type         | Null | Key | Default | Extra |
//    +-------------+--------------+------+-----+---------+-------+
//    | categoryid  | varchar(10)  | NO   | PRI | NULL    |       |
//    | name        | varchar(25)  | NO   |     | NULL    |       |
//    | description | varchar(255) | NO   |     | NULL    |       |
//    | imageurl    | varchar(55)  | YES  |     | NULL    |       |
//    +-------------+--------------+------+-----+---------+-------+

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(callSuper=false)
@Entity(name = "category")
public class CategoryEntity {

    @Id
    private String categoryid;

    private String name;

    private String description;

    private String imageurl;
}
