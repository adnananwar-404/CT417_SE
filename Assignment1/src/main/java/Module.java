import java.util.ArrayList;
import java.util.List;

public class Module {

    private String moduleName;
    private int iD;
    private List<Student> students = new ArrayList<Student>();
    private List<Course> courses = new ArrayList<Course>();

    public Module(String moduleName, int iD) {
        this.moduleName = moduleName;
        this.iD = iD;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        //Update Courses Associated With Module
        List<Course> courses = getCourses();
        courses.add(course);
        setCourses(courses);

        //Update Modules Associated With Course
        List<Module> modules = course.getModules();
        modules.add(this);
        course.setModules(modules);
    }

    public void addStudent(Student student) {
        //Associate Student with Module
        List<Student> students = getStudents();
        students.add(student);
        setStudents(students);

        //Update Module with Student
        List<Module> modules = student.getModules();
        modules.add(this);
        student.setModules(modules);
    }
}
