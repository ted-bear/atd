package ooap2.second;

// Класс-родитель, который задает базовые атрибуты и методы
public class Vehicle {

    protected String number;
    protected Integer maxSpeed;

    public Vehicle(String number, Integer maxSpeed) {
        this.number = number;
        this.maxSpeed = maxSpeed;
    }

    public void describe() {
        System.out.printf("Number: %s%nMax Speed: %d km/h", number, maxSpeed);
    }

    public static void main(String[] args) throws InterruptedException {
        var vehicle = new Vehicle("а123аа", 45);
        vehicle.describe();
        System.out.println();

        var car = new Car("в456вв", 60, 4, 5);
        car.describe();

        System.out.println();
        var electricalVehicle = new ElectricalVehicle("в456вв", 100, 80, 4000);
        electricalVehicle.describe();
        electricalVehicle.charge();
    }
}
