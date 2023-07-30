package com.tfg.hsonline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String medicine;
    @NotNull
    private String quantity;
    @NotNull
    private String dose;
    @NotNull
    private String frequency;
    private Integer treatmentId;

    //relation Prescription -> Treatment: many-to-one
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "treatmentId", insertable = false, updatable = false)
    private Treatment treatment;

}
