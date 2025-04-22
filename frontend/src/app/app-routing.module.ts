import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EmployeListComponent} from "./Components/employe-list/employe-list.component";
import {EmployeDetailComponent} from "./Components/employe-detail/employe-detail.component";
import {CongeFormComponent} from "./Components/conge-form/conge-form.component";


const routes: Routes = [

  { path: '', component: EmployeListComponent },
  { path: 'employe/:id', component: EmployeDetailComponent },
  { path: 'employe/:id/conge', component: CongeFormComponent },
  { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
