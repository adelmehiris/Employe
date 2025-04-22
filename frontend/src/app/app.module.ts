import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import {EmployeListComponent} from "./Components/employe-list/employe-list.component";
import {EmployeDetailComponent} from "./Components/employe-detail/employe-detail.component";
import {CongeFormComponent} from "./Components/conge-form/conge-form.component";

@NgModule({
  declarations: [
    AppComponent,
    EmployeListComponent,
    EmployeDetailComponent,
    CongeFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
