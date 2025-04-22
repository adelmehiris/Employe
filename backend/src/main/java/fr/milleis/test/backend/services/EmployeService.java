package fr.milleis.test.backend.services;

import fr.milleis.test.backend.entities.Categorie;
import fr.milleis.test.backend.entities.CongeRequest;
import fr.milleis.test.backend.entities.Employe;
import fr.milleis.test.backend.exceptions.CongeException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class EmployeService {
    private final List<Employe> employes = Arrays.asList(
            new Employe(12345678L, "Dupont", "Jean", Categorie.NON_CADRE, LocalDate.of(2022, 9, 1), new BigDecimal("25.0"), null),
            new Employe(98765432L, "Martin", "Sophie", Categorie.CADRE, LocalDate.of(2021, 3, 15), new BigDecimal("25.0"), new BigDecimal("12.0"))
    );

    public List<Employe> getAllEmployes() {
        return employes;
    }

    public Optional<Employe> getEmployeById(Long id) {
        return employes.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public String demanderConge(CongeRequest request) {
        Employe employe = getEmployeById(request.getEmployeId())
                .orElseThrow(() -> new CongeException("ER000001", "Employé inexistant"));

        if (request.getDateDebut().isAfter(request.getDateFin())) {
            throw new CongeException("ER000002", "Les dates sont invalides");
        }

        switch (request.getTypeConge()) {
            case CONGE_PAYE:
                if (employe.getSoldeConges().compareTo(BigDecimal.valueOf(1)) < 0) {
                    throw new CongeException("ER000003", "Solde de congés insuffisant");
                }
                break;
            case RTT:
                if (employe.getCategorie() == Categorie.NON_CADRE) {
                    throw new CongeException("ER000004", "Les non-cadres ne peuvent pas poser de RTT");
                }
                if (employe.getSoldeRTT() == null || employe.getSoldeRTT().compareTo(BigDecimal.valueOf(1)) < 0) {
                    throw new CongeException("ER000005", "Solde de RTT insuffisant");
                }
                break;
            case SANS_SOLDE:
                break;
        }

        return "Demande de congé enregistrée (mock)";
    }
}
