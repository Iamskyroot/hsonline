package com.tfg.hsonline.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "symptoms")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String description;

    //relation Symptom <-> Sickness: many-to-many
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "sickness_has_simptoms",
    joinColumns = @JoinColumn(name = "symptomId", insertable = false, updatable = false),
    inverseJoinColumns = @JoinColumn(name = "sicknessId", insertable = false, updatable = false))
    private List<Sickness> sicknesses;

}
