import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {EmployeService} from "../../services/employe.service";

@Component({
  selector: 'app-conge-form',
  templateUrl: './conge-form.component.html',
  styleUrl: './conge-form.component.scss'
})
export class CongeFormComponent implements OnInit{
  congeForm!: FormGroup;
  errorMessage = '';
  successMessage = '';
  loading = false;

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private employeService: EmployeService) {}

  ngOnInit(): void {
    const employeId = this.route.snapshot.params['id'];
    this.congeForm = this.fb.group({
      employeId: [employeId],
      dateDebut: ['', Validators.required],
      dateFin: ['', Validators.required],
      typeConge: ['', Validators.required]
    });
  }

  submit(): void {
    this.loading = true;
    this.errorMessage = '';
    this.successMessage = '';
    this.employeService.postConge(this.congeForm.value).subscribe({
      next: () => {
        this.successMessage = 'Demande envoyée avec succès';
        this.loading = false;
      },
      error: err => {
        this.errorMessage = err.error?.message || 'Erreur inconnue';
        this.loading = false;
      }
    });
  }
}
