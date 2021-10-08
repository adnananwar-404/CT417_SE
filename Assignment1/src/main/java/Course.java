import org.joda.time.*;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private DateTime startDate, endDate;
    private List<Student> students = new ArrayList<Student>();
    private List<Module> modules = new ArrayList<Module>();

    public Course(String courseName, DateTime startDate, DateTime endDate) {
        this.courseName = courseName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public void addModule(Module module) {
        //Associated Module with Course
        List<Module> modules = getModules();
        modules.add(module);
        setModules(modules);

        //Associated Course with Module
        List<Course> courses = module.getCourses();
        courses.add(this);
        module.setCourses(courses);
    }

    public void addStudent(Student student) {
        //Associate Student with Course
        List<Student> students = getStudents();
        students.add(student);
        setStudents(students);

        //Associate Course With Student
        List<Course> courses = student.getCourses();
        courses.add(this);
        student.setCourses(courses);

    }
}
