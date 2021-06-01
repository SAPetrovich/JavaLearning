package AccessingDataJpa;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
//@Getter
//@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}