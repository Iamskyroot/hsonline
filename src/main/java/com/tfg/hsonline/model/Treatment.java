package com.tfg.hsonline.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "treatments")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private int sicknessId;
    @NotNull
    private String name;
    @NotNull
    private String category;
    @NotNull
    private Integer personalId;

    /* //relation Treatment -> PatientTreatment: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "treatment")
    private List<PatientTreatment> patientTreatments; */

    //relation Treatment -> Patient: many-to-many
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "patient_has_treatments",
    joinColumns = @JoinColumn(name = "treatmentId", insertable = false, updatable = false),
    inverseJoinColumns = @JoinColumn(name = "patientId", insertable = false, updatable = false))
    private List<Patient> patients;

    //relation Treatment -> Prescription: one-to-many
    @JsonIgnore
    @OneToMany(mappedBy = "treatment", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;

    //relation Treatment -> Sickness: many-to-one
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sicknessId", insertable = false, updatable = false)
    private Sickness sickness;

}
