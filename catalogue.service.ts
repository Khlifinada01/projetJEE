import { Injectable } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CatalogueService {
  public host: string = "http://localhost:8080"

  constructor(private http: HttpClientModule) {
  }

  // @ts-ignore
  public getResource(url) {
    // @ts-ignore
    return this.http.get(this.host +url);
  }
}
