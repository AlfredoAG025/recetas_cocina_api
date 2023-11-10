import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RecipesService {
  url = 'http://localhost:8000/kitchen-recipes/api/v1/recipes';
  constructor(private http: HttpClient) {}
  getRecipes(): Observable<any> {
    return this.http.get(this.url, { headers: { Accept: 'application/json' } });
  }
}
