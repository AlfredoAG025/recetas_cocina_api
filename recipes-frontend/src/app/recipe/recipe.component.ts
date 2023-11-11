import {Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-recipe',
  standalone: true,
  imports: [CommonModule],
  template: `
      <div class="card w-96 bg-base-100 shadow-xl h-full">
          <figure><img [src]="recipe.imageUrl" [alt]="recipe.title"/></figure>
          <div class="card-body">
              <h2 class="card-title"><i class="fa-solid fa-bowl-food"></i>{{recipe.title}}</h2>
              <p><i class="fa-regular fa-clock"></i> Preparation time: <span
                      class="underline text-primary font-bold">{{recipe.preparationTime}} min</span></p>
              <div class="border rounded p-4 shadow">
                <h3 class="text-xl underline font-bold">Ingredients:</h3>
                  <ul class="p-4">
                      <li class="list-disc" *ngFor="let i of recipe.ingredients">
                          {{i}}
                      </li>
                  </ul>
              </div>
              <div class="card-actions justify-end">
                  <a target="_blank" [href]="recipe.videoUrl" class="btn btn-primary"><i class="fa-solid fa-play"></i>
                      Watch a video!</a>
              </div>
          </div>
      </div>
  `,
  styleUrl: './recipe.component.css'
})
export class RecipeComponent {
  @Input() recipe: any
}
