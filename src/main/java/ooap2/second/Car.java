package ooap2.second;

// Класс-наследник, который специализирует класс-родитель
// путем добавления специфичных атрибутов и переопределением методов
public class Car extends Vehicle {

    protected Integer doorNumber;
    protected Integer seatNumber;

    public Car(String number, Integer maxSpeed, Integer doorNumber, Integer seatNumber) {
        super(number, maxSpeed);
        this.doorNumber = doorNumber;
        this.seatNumber = seatNumber;
    }

    @Override
    public void describe() {
        System.out.printf("Number: %s%nMax Speed: %d km/h%nDoor number: %d%nSeat number: %d",
            number, maxSpeed, doorNumber, seatNumber);
    }
}
