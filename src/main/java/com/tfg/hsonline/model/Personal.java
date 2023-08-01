package com.tfg.hsonline.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String gender;
    @NotNull
    private String country;
    @NotNull
    private String document;
    @NotNull
    private String specialty;
    @NotNull
    private String direction;
    @NotNull
    private String phone;
    @Nullable
    private String email;
    @NotNull
    private String user;
    @NotNull
    private String password;

    //relation Personal -> Consultation: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "personal")
    private List<Consultation> consultations;

    //relation Personal -> Consultation: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "personal")
    private List<Appointment> appointments;

}
