package second.first;

import java.util.ArrayList;
import java.util.List;

// Наемный  сотрудник - архитектор.
// Умеет рисовать круги и треугольники
// Может работать сразу на нескольких проектах
// Связь has-a
public class Architecture extends Employee {

    private final List<Project> projects;

    public Architecture(String name, int age, double salary) {
        super(name, age, salary);
        projects = new ArrayList<>();
    }

    @Override
    public void doWork() {
        System.out.println("Drawing circles and triangles");
    }

    public List<Project> getProjects() {
        return List.copyOf(projects);
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
