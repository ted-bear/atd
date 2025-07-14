package second.first;

import java.util.ArrayList;

public class CompanyApp {

    public static void main(String[] args) {
        var employees = new ArrayList<Employee>();
        var govProject = new Project("Run", "Do not touch this");
        var jsProgrammer = new Programmer("Anton", 25, 1300, "javascript");
        var javaProgrammer = new Programmer("Kirill", 30, 1600, "java");
        var architecture = new Architecture("Vasya", 45, 3000);

        jsProgrammer.setCurrentProject(govProject);
        javaProgrammer.setCurrentProject(govProject);

        employees.add(javaProgrammer);
        employees.add(jsProgrammer);
        employees.add(architecture);

        // Пример использования полиморфизма с помощью общего интерфейса
        employees.forEach(Employee::doWork);
    }
}
