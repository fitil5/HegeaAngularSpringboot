import { TestBed, inject } from '@angular/core/testing';

import { RegistradosService } from './registrados.service';

describe('RegistradosService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegistradosService]
    });
  });

  it('should be created', inject([RegistradosService], (service: RegistradosService) => {
    expect(service).toBeTruthy();
  }));
});
