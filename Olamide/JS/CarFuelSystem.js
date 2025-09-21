let CarSwitch = false;
let minimum = 5;
let carDriven = 0;
let levelFuel = 0;
let startRunning = false;

function power() {
    return CarSwitch;
}

function toggleButton() {
    if (CarSwitch === false) {
        CarSwitch = true;
    } else {
        CarSwitch = false;
    }
}

function carCurrentFuel() {
    return minimum;
}

function currentStateOne() {
    if (CarSwitch === true) throw new Error('Car is on');
    if (minimum > 50) throw new Error('Car is carrying fuel more than its capacity, please reduce the fuel');
    minimum--;
}

function currentStateTwo() {
    if (CarSwitch === false) throw new Error('Car is not on');
    if (minimum <= 0) throw new Error('The fuel inside the car is low, please refill the fuel');
    minimum++;
}

function fuelUsed(distance, fuelEffeciency) {
    if (CarSwitch === false) throw new Error('Car is not on');
    carDriven = distance / fuelEffeciency;
    return carDriven;
}

function fuelGuage() {
    if (CarSwitch === true) {
        levelFuel = minimum - carDriven;
        return levelFuel;
    }
}

function runningLevel() {
    if (startRunning === false) {
        startRunning = true;
    } else {
        startRunning = false;
    }
}

module.exports = {
    power,
    toggleButton,
    carCurrentFuel,
    currentStateOne,
    currentStateTwo,
    fuelUsed,
    fuelGuage,
    runningLevel
};
