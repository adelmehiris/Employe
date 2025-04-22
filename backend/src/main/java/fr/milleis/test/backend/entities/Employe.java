package fr.milleis.test.backend.entities;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    private Long id;
    private String nom;
    private String prenom;
    private Categorie categorie;
    private LocalDate dateEmbauche;
    private BigDecimal soldeConges;
    private BigDecimal soldeRTT;
}