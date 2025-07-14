package second.first;

// Наемный  сотрудник - программист.
// Умеет что то печатать на клавиатура с умным видом
// Работает на одном проекте, который выражен отношением has-a
public class Programmer extends Employee {

    private Project currentProject;
    private final String programmingLanguage;

    public Programmer(String name, int age, double salary, String programmingLanguage) {
        super(name, age, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void doWork() {
        System.out.println("Typing something on the keyboard...");
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public Project getCurrentProject() {
        return currentProject;
    }
}
