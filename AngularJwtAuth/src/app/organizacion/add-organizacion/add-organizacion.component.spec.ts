import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrganizacionComponent } from './add-organizacion.component';

describe('AddOrganizacionComponent', () => {
  let component: AddOrganizacionComponent;
  let fixture: ComponentFixture<AddOrganizacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddOrganizacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrganizacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
