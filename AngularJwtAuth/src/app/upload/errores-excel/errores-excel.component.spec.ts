import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ErroresExcelComponent } from './errores-excel.component';

describe('ErroresExcelComponent', () => {
  let component: ErroresExcelComponent;
  let fixture: ComponentFixture<ErroresExcelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ErroresExcelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ErroresExcelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
