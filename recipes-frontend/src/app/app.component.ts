import {Component} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterOutlet} from '@angular/router';
import {RecipeComponent} from "./recipe/recipe.component";
import {HttpClientModule} from "@angular/common/http";
import {RecipesService} from "./recipes.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RecipeComponent, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  recipe: string = '';
  title = 'Recipes App';
  constructor(private RecipeService: RecipesService) {}
  fetchRecipe(): void{
    this.RecipeService.getRecipes().subscribe((data: any) => {
      this.recipe = data.recipe;
    });
  }
}
