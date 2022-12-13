import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrarFechaActividadComponent } from './borrar-fecha-actividad.component';

describe('BorrarFechaActividadComponent', () => {
  let component: BorrarFechaActividadComponent;
  let fixture: ComponentFixture<BorrarFechaActividadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BorrarFechaActividadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrarFechaActividadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
