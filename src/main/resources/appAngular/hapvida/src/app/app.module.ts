import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AnimalComponent } from './animal/animal.component';
import { TutorComponent } from './tutor/tutor.component';
import { VeterinarioComponent } from './veterinario/veterinario.component';
import { AnimalCrudComponent } from './animal-crud/animal-crud.component';
import { TutorCrudComponent } from './tutor-crud/tutor-crud.component';
import { VeterinarioCrudComponent } from './veterinario-crud/veterinario-crud.component';

@NgModule({
  declarations: [
    AppComponent,
    AnimalComponent,
    TutorComponent,
    VeterinarioComponent,
    AnimalCrudComponent,
    TutorCrudComponent,
    VeterinarioCrudComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
