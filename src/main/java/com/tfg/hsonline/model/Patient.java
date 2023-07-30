package com.tfg.hsonline.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private String gender;
    private String document;
    @NotNull
    private String direction;
    private String phone;
    private String user;
    private String password;

    //relation Patient -> Hospitalization: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Hospitalization> hospitalizations;

    //relation Patient -> Consultation: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    //relation Patient -> Report: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Report> reports;

    //relation Patient -> Appointment: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    // //relation Patient -> PatientTreatment: one-to-many
    // @JsonIgnore
    // @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    // private List<PatientTreatment> patientTreatments;

    //relation Patient <-> Treatment: many-to-many
    @JsonIgnore
    @ManyToMany(mappedBy = "patients")
    private List<Treatment> treatments;

    //relation Patient <-> Sickness: many-to-many
    @JsonIgnore
    @ManyToMany(mappedBy = "patients")
    private List<Sickness> sicknesses;

}
