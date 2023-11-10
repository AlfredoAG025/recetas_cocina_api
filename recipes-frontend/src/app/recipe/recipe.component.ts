import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-recipe',
  standalone: true,
  imports: [CommonModule],
  template: `
    <p>
      recipe works!
    </p>
  `,
  styleUrl: './recipe.component.css'
})
export class RecipeComponent {

}
