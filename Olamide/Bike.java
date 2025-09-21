public class Bike {
    private boolean isOn;
    private int speed;

    public AutomaticBike() {
        this.isOn = false;
        this.speed = 0;
    }

    // Power controls
    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
        speed = 0; 
    }

    public boolean isOn() {
        return isOn;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        if (speed >= 0 && speed <= 20) return 1;
        else if (speed >= 21 && speed <= 30) return 2;
        else if (speed >= 31 && speed <= 40) return 3;
        else return 4;
    }

    // Accelerate based on gear
    public void accelerate() {
        if (!isOn) return;
        int gear = getGear();
        speed += gear; 
    }

    // Decelerate based on gear
    public void decelerate() {
        if (!isOn) return;
        int gear = getGear();
        speed -= gear; 
        if (speed < 0) speed = 0; 
    }
}
