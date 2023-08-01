package com.tfg.hsonline.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    @NotNull
    private String reason;
    @Nullable
    private Double height;
    @Nullable
    private Double weight;
    @NotNull
    private Double temperature;
    @Nullable
    private Double bloodPressure;
    @Nullable
    private Double heartRate;
    private String simptom;
    private String status;
    private String service;
    private String notes;
    private String orderedTests;
    private String diagnostics;
    private LocalDate appointmentDate;
    private LocalDate diagnosticDate;
    private Integer personalId;

    //relation consultation -> patient: many-to-one
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patientId", insertable = false, updatable = false)
    private Patient patient;

    //relation consultation -> personal: many-to-one
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "personalId", insertable = false, updatable = false)
    private Personal personal;

}
