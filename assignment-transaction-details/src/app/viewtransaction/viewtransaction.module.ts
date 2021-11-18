import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ViewtransactionRoutingModule } from './viewtransaction-routing.module';
import { LayoutComponent } from './layout.component';
import { ListComponent } from './list.component';
import { FormsModule } from '@angular/forms';
import { NgbdSortableHeader} from './list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatSortModule} from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        ViewtransactionRoutingModule,
        NgbModule,
        FormsModule,
        MatRadioModule,
        MatSelectModule,
        MatInputModule,
        MatCardModule,
        MatButtonModule,
        MatSortModule,
        MatTableModule,
        MatPaginatorModule
    ],
    declarations: [
        LayoutComponent,
        ListComponent,
        NgbdSortableHeader
    ],
    exports:[ListComponent],
    bootstrap:[ListComponent]

})
export class ViewtransactionModule { }
