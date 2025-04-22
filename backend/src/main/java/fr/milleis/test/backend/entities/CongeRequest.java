package fr.milleis.test.backend.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CongeRequest {
    private Long employeId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private TypeConge typeConge;
}
