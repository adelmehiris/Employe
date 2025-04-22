package fr.milleis.test.backend.web;

import fr.milleis.test.backend.entities.CongeRequest;
import fr.milleis.test.backend.entities.Employe;
import fr.milleis.test.backend.services.EmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.getEmployeById(id)
                .orElseThrow(() -> new RuntimeException("Employé introuvable"));
    }

    @PostMapping("/conges")
    public String demanderConge(@RequestBody CongeRequest request) {
        return employeService.demanderConge(request);
    }
}
