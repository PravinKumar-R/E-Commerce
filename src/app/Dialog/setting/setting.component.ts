import { Component, inject, model } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-setting',
  templateUrl: './setting.component.html',
  styleUrl: './setting.component.css'
})
export class SettingComponent {

  readonly dialogRef = inject(MatDialogRef<SettingComponent>);
  readonly checked = model(false);
  readonly indeterminate = model(false);

  changePerference!: string;
  changePerferences: string[] = ['Dark Violet', 'Rose', 'Yellow'];
}
