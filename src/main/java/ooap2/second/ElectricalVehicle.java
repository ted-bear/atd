package ooap2.second;

// Класс-наследник, который расширяет исходный класс новым методом charge
public class ElectricalVehicle extends Vehicle {

    protected Integer chargeLevel;
    protected Integer batteryCapacity;

    public ElectricalVehicle(String number, Integer maxSpeed, Integer chargeLevel, Integer batteryCapacity) {
        super(number, maxSpeed);
        this.chargeLevel = chargeLevel;
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() throws InterruptedException {
        for (int i = chargeLevel; i <= 100; i++) {
            chargeLevel++;
            Thread.sleep(1000);
            System.out.println("Engine charge: " + chargeLevel);
        }
    }

    @Override
    public void describe() {
        System.out.printf("Number: %s%nMax Speed: %d km/h%nCharge level: %d%nBattery capacity: %d",
            number, maxSpeed, chargeLevel, batteryCapacity);
    }
}
