import {Component, OnInit} from '@angular/core';
import {EmployeService} from "../../services/employe.service";

@Component({
  selector: 'app-employe-list',
  templateUrl: './employe-list.component.html',
  styleUrl: './employe-list.component.scss'
})
export class EmployeListComponent implements OnInit{
  cadres: any[] = [];
  nonCadres: any[] = [];
  loading = true;

  constructor(private employeService: EmployeService) {}

  ngOnInit(): void {
    this.employeService.getAll().subscribe(data => {
      this.cadres = data.filter((e: any) => e.categorie === 'CADRE');
      this.nonCadres = data.filter((e: any) => e.categorie === 'NON_CADRE');
      this.loading = false;
    });
  }
}
