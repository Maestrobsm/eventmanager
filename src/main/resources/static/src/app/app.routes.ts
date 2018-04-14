import {Routes} from "@angular/router";
import {ContentComponent} from "./content/content.component";

export const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'landing',
    pathMatch: 'full'
  },
  {
    path: 'landing',
    component: ContentComponent
  },
];
