import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { TransactionRoutingModule } from './transaction-routing.module';
import { LayoutComponent } from './layout.component';
import { RegisterComponent } from './register.component';
import { DisplayComponent } from './display.component';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        TransactionRoutingModule,
        MatRadioModule,
        MatSelectModule,
        MatInputModule,
        MatCardModule,
        MatButtonModule
    ],
    declarations: [
        LayoutComponent,

        RegisterComponent,
        DisplayComponent
    ]
})
export class TransactionModule { }
