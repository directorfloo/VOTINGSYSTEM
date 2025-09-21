let swithPower = false;
let temperature = 24;

function power() {
    return swithPower;
}

function toggleButton() {
if(swithPower === false){
swithPower = true;
elsel
swithPower = false;
}
}
function currentTemperature() {
return temperature;
}
function increaseButton() {
if(swithPower === false) Error("Ac is not on");
if(temperature < 16) Error("Ac cannot be higher than this");
temperature--;
}
module.exports - {power, toggleButton, currentTemperature, increaseButton};