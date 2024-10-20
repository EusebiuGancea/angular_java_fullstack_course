import { Component, OnInit } from '@angular/core';
import { SalesPerson } from './sales-person';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list-bootstrap.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  // create an array of objects
  salesPersonList: SalesPerson[] = [
    new SalesPerson("Cristi", "Mihai", "cristi.mihai@gmail.com", 40000),
    new SalesPerson("Ionut", "Cristea", "cristi.mihai@gmail.com", 90000),
    new SalesPerson("Marius", "Mihalcea", "cristi.mihai@gmail.com", 50000),
    new SalesPerson("Ionescu", "Cristian", "cristi.mihai@gmail.com", 80000),
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
