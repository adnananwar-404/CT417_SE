import java.util.ArrayList;
import java.util.List;

public class Module {

    private String moduleName;
    private String iD;
    private List<Student> students = new ArrayList<Student>();
    private List<Course> courses = new ArrayList<Course>();

    public Module(String moduleName, String iD) {
        this.moduleName = moduleName;
        this.iD = iD;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
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
        //Associate Student With Module
        List<Student> students = getStudents();
        students.add(student);
        setStudents(students);

        //Associate Module With Student
        List<Module> modules = student.getModules();
        modules.add(this);
        student.setModules(modules);
    }
}
