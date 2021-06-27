import {Component, OnInit} from '@angular/core';
import {CatalogueService} from './catalogue.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  // @ts-ignore
  public categories;
  data : any;
  constructor(private catservice: CatalogueService) {}
  title = 'ecomm-front';
  ngOnInit():void {
    this.getCategories();
  }

  private getCategories() {
    // @ts-ignore
    this.catservice.getResource("/Categories").subscribe(data =>{this.categories=data;})

  }
}
