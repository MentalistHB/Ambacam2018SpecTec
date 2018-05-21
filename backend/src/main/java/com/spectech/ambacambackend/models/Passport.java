package com.spectech.ambacambackend.models;

import com.spectech.ambacambackend.models.listeners.PassportEntityListener;
import com.spectech.ambacambackend.utils.Auditable;
import lombok.Data;

import javax.persistence.*;

@Entity
@EntityListeners(PassportEntityListener.class)
@Data
public class Passport extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String reference;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String nationality;

    private String profession;

    private String deliveryDate;

    private String expiryDate;

}
