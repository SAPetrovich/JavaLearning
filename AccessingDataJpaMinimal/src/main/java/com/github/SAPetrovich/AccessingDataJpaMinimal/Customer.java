package com.github.SAPetrovich.AccessingDataJpaMinimal;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
}