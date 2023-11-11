import {Component} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterOutlet} from '@angular/router';
import {RecipeComponent} from "./recipe/recipe.component";
import {HttpClientModule} from "@angular/common/http";
import {RecipesService} from "./recipes.service";
import {FormsModule} from "@angular/forms"


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RecipeComponent, HttpClientModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  recipes: any;
  title = 'Recipes App';
  recipe_title = '';

  constructor(private RecipeService: RecipesService) {
  }

  ngOnInit(): void {
    this.RecipeService.getRecipes().subscribe((data: any) => {
      this.recipes = data;
    });
  }

  onInput(): void {
    if (this.recipe_title.trim() != '') {
      this.RecipeService.getOneRecipeContainsTitle(this.recipe_title).subscribe((data: any) => {
        this.recipes = data
      });
    } else {
      this.RecipeService.getRecipes().subscribe((data: any) => {
        this.recipes = data;
      });
    }
  }
}
