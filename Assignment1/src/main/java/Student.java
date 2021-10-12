import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name, dob, username;
    private int age, iD;
    private List<Module> modules = new ArrayList<Module>();
    private Course course;

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

    public Course getCourses() {
        return course;
    }

    public String getUsername() {
        return username;
    }

    public void addModule(Module module) {
        //Associate Module With Student
        List<Module> modules = getModules();
        modules.add(module);
        setModules(modules);

        //Associate Student With Module
        List<Student> students = module.getStudents();
        students.add(this);
        module.setStudents(students);

    }

    public void setCourse(Course course) {
        //Associate Course With Student
        this.course = course;

        //Associate Student With Course
        List<Student> students = course.getStudents();
        students.add(this);
        course.setStudents(students);
    }
}
