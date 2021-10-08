import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name, dob, username;
    private int age, iD;
    private List<Module> modules = new ArrayList<Module>();
    private List<Course> courses = new ArrayList<Course>();

    public Student(String name, String dob, int age, int iD) {
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.iD = iD;
        this.username = name + String.valueOf(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getUsername() {
        return username;
    }

    public void addModule(Module module) {
        //Associate Module With Student
        List<Module> modules = getModules();
        modules.add(module);
        setModules(modules);

        //Associate Student with Module
        List<Student> students = module.getStudents();
        students.add(this);
        module.setStudents(students);
    }
}
