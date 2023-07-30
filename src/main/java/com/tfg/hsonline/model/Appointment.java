package com.tfg.hsonline.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long patientId;
    @NotNull
    private String reason;
    @NotNull
    private String service;
    @Null
    private String notes;
    @Null
    private String status;
    @NotNull
    private LocalDate requestDate;
    @Null
    private LocalDate startDate;
    @Null
    private LocalDate endDate;
    @NotNull
    private Integer personalId;

    //relation Appointment -> Patient: many-to-one
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patientId", insertable = false, updatable = false)
    private Patient patient;
    
    //relation Appointment -> Personal: many-to-one
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "personalId", insertable = false, updatable = false)
    private Personal personal;

}
