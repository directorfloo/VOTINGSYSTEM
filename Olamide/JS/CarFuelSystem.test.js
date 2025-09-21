const {power, toggleButton} = require('.../CarFuelSystem');

describe('Car Fuel System', () => {
    
    test('Car should start when turned on', () => {
        expect(power()).toBe(true);
    });

    test('Car should not work when turn off', () => {
       expect(power()).toBe(false); 
    });
    test('test that i can start on the car', () => {
        expect(power()).toBe(true);
        toggleButton();
        expect(power()).toBe(false); 
        toggleButton();
    });
    test('test if you can on and off the Car', () => {
        toggleButton();
        toggleButton();
    });
});
test("Car fuel level starts at 5", () => {
    expect(car.carCurrentFuel()).toBe(5);
  });

  test("currentStateOne should throw error if car is ON", () => {
    car.toggleButton(); // turn ON
    expect(() => car.currentStateOne()).toThrow("Car is on");
  });

  test("currentStateTwo should throw error if car is OFF", () => {
    expect(() => car.currentStateTwo()).toThrow("Car is not on");
  });

  test("fuelUsed should throw error if car is OFF", () => {
    expect(() => car.fuelUsed(100, 10)).toThrow("Car is not on");
  });

  test("fuelUsed should calculate distance when car is ON", () => {
    car.toggleButton(); // turn ON
    const driven = car.fuelUsed(100, 10); // 100km / 10km per liter
    expect(driven).toBe(10);
  });

  test("fuelGuage returns fuel after driving", () => {
    car.toggleButton(); // turn ON
    car.fuelUsed(50, 10); // uses 5 liters
    expect(car.fuelGuage()).toBe(0); // started with 5, used 5
  });

  test("runningLevel toggles running state", () => {
    expect(car.runningLevel()).toBeUndefined(); // sets true
    expect(car.runningLevel()).toBeUndefined(); // sets false
  });

