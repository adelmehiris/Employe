import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {EmployeService} from "../../services/employe.service";

@Component({
  selector: 'app-employe-detail',
  templateUrl: './employe-detail.component.html',
  styleUrl: './employe-detail.component.scss'
})
export class EmployeDetailComponent implements OnInit{

  employe: any;

  constructor(private route: ActivatedRoute, private employeService: EmployeService) {}

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.employeService.getById(id).subscribe(data => this.employe = data);
  }

}
