const {addition , subtraction} = require('../src/Calculator');

test ('test to add 2 + 1',()=> {
     let result  = addition(2,1);
     expect(result).toBe(3);
});


test('test to subtract 10 - 5',() => {
    let result=subtraction(6,3)
    expect(result).toBe(3);

})