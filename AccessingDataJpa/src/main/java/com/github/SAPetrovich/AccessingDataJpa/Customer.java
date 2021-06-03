package com.github.SAPetrovich.AccessingDataJpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "first_name")  // именно такое имя поля генерится по умолчанию!
    private String firstName;

    //@Column(name = "last_name")  // именно такое имя поля генерится по умолчанию!
    private String lastName;

}
