package com.mesay.movie.rental.customer.domain.entitiy;

import com.mesay.movie.rental.Auditable;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String phone;
    private String address;
    private String email;
}
