package com.tfg.hsonline.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Entity(name = "sicknesses")
public class Sickness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;

    //relation Sickness <-> Patient: many-to-many
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "patient_has_sicknesses",
    joinColumns = @JoinColumn(name = "sicknessId", insertable = false, updatable = false),
    inverseJoinColumns = @JoinColumn(name = "patientId", insertable = false, updatable = false))
    private List<Patient> patients;

    //relation Sickness <-> Simptom: many-to-many
    @JsonIgnore
    @ManyToMany(mappedBy = "sicknesses")
    private List<Symptom> symptoms;

    //relation Sickness -> Treatment: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "sickness", cascade = CascadeType.ALL)
    private List<Treatment> treatments;

}
