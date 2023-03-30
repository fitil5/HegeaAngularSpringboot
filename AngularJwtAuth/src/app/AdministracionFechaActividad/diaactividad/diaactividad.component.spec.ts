import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiaactividadComponent } from './diaactividad.component';

describe('DiaactividadComponent', () => {
  let component: DiaactividadComponent;
  let fixture: ComponentFixture<DiaactividadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiaactividadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiaactividadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
