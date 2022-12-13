import { TestBed, inject } from '@angular/core/testing';

import { DiaactividadService } from './diaactividad.service';

describe('DiaactividadService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DiaactividadService]
    });
  });

  it('should be created', inject([DiaactividadService], (service: DiaactividadService) => {
    expect(service).toBeTruthy();
  }));
});
