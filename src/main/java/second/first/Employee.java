package second.first;

// Определение общего класса сотрудника
// Который обладает общими полями: имя, возраст, зарплата
// Также каждый сотрудник умеет болтать с коллегами
// И должен уметь как то работать, но пока непонятно как
public abstract class Employee {

    protected String name;
    protected int age;
    protected double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public abstract void doWork();

    public void talkToColleagues(String phrase) {
        System.out.println(phrase);
    }
}
