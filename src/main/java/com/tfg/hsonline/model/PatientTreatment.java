package com.tfg.hsonline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "patient_has_treatments")
public class PatientTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Integer treatmentId;

    /* //relation PatientTreatment -> Patient: many-to-one
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patientId", insertable = false, updatable = false)
    private Patient patient;

    //relation PatientTreatment -> Treatment: many-to-one
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "treatmentId", insertable = false, updatable = false)
    private Treatment treatment; */

}
