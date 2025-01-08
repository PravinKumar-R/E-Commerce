import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegiterSuccessComponent } from './regiter-success.component';

describe('RegiterSuccessComponent', () => {
  let component: RegiterSuccessComponent;
  let fixture: ComponentFixture<RegiterSuccessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RegiterSuccessComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegiterSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
