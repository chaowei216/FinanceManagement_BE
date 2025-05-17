package com.weiz.accountservice.command.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer extends AbstractEntity<String> {

    @Id
    @Column(name = "customer_id")
    String id;

    @Column(
            name = "full_name",
            nullable = false,
            length = 50
    )
    String fullName;

    @Column(
            name = "email",
            unique = true,
            length = 100,
            nullable = false
    )
    String email;

    @Column(
            name = "mobile_number",
            nullable = false,
            unique = true,
            length = 10
    )
    String mobileNumber;
}
