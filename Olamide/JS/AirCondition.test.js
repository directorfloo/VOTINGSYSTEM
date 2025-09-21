const {power, toggleButton, currentTemperature, increaseButton} = require ('../src/AirCondition') 

describe ("Test for my new Hisense air condition", () => { 
test( "should power off", () => {
    expect (power()).toBe(false); // the air condition is off

});


test ("test that i can on my air condition", () => { 
    expect (power()).toBe(false); // the air condition is off toggleButton;
    toggleButton(); // i press the button to on the air condition
    expect (power()).toBe(true); // the air condition is ontoggleButton();
    toggleButton();    // // i press the button to off the air condition
})

test ("test to check if we can on and off the air condition", () => {
toggleButton(); // i press the button to on the air condition
toggleButton(); // i press the button to off the air condition 
expect (power ()).toBe(false); // // the air condition is off
});
})

describe("Test for temperature increment", () => {
 test ("test to check my default temperature", () => {
toggleButton();
expect (currentTemperature()).toBe(24); 
toggleButton();
 })
 
test ("test if my ac can increase the temperature", () => {
toggleButton();
expect(currentTemperature()).toBe(24);
increaseButton();
expect(currentTemperature()).toBe(23);
toggleButton();

})

test("test that i cannot increase ac temperature  without power on ", () => {
    expect(()=> {
        throw new Error("Ac is not on");
    }).toThrow(increaseButton());
})

test ("test that once the ac and it's in the highest it cannot increase again", () => {
    for(let count = 1; count < 9; count++){
        increaseButton();
    }
           expect(()=> {
        throw new Error("Ac is not on");
    }).toThrow(increaseButton());
});
});

