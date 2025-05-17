package com.weiz.accountservice.command.data;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account extends AbstractEntity<String> {

    @Id
    @Column(name = "account_number")
    String accountNumber;

    @Column(name = "account_type")
    String accountType;

    @Override
    public String getId() {
        return accountNumber;
    }
}
