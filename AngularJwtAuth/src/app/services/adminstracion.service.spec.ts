import { TestBed, inject } from '@angular/core/testing';

import { AdminstracionService } from './adminstracion.service';

describe('AdminstracionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminstracionService]
    });
  });

  it('should be created', inject([AdminstracionService], (service: AdminstracionService) => {
    expect(service).toBeTruthy();
  }));
});
