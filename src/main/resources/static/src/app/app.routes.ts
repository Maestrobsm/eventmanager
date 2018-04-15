import {Routes} from "@angular/router";
import {InfoComponent} from "./info/info.component";

export const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'landing',
    pathMatch: 'full'
  },
  {
    path: 'info',
    component: InfoComponent
  }
];
