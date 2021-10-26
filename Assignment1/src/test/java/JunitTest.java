import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    public static void main(String[] args){
        JunitTest test = new JunitTest();
        test.studentGetUsernameTest();
        test.testGettersAndSetters();
        test.testProgram();
    }

    @Test
    public void studentGetUsernameTest(){
        Student student = new Student("John", "10-08-2000", 21, 001);
        String username = student.getUsername();
        Assert.assertEquals("John21", username);
    }

    @Test
    public void testGettersAndSetters()
    {
        DateTime startDate = new DateTime(2018, 9, 6, 0, 0);
        DateTime endDate = new DateTime(2022, 5, 6,0,0);
        Student student = new Student("John", "01-01-2001", 20, 001);
        Course course = new Course("CSIT", startDate, endDate);
        Module module = new Module("Software Engineering", "CT417");

        //Test Student
        Assert.assertEquals("John", student.getName());
        Assert.assertEquals("01-01-2001", student.getDob());
        Assert.assertEquals(20, student.getAge());
        Assert.assertEquals(001, student.getiD());

        //Test Course
        Assert.assertEquals("CSIT", course.getCourseName());
        Assert.assertEquals(startDate, course.getStartDate());
        Assert.assertEquals(endDate, course.getEndDate());

        //Test Module
        Assert.assertEquals("Software Engineering", module.getModuleName());
        Assert.assertEquals("CT417", module.getiD());
    }

    @Test
    public void testProgram()
    {
        //create datetime
        DateTime startDate = new DateTime(2018, 9, 6, 0, 0);
        DateTime endDate = new DateTime(2022, 5, 6,0,0);

        //create students
        Student student1 = new Student("John", "01-01-2001", 20, 001);
        Student student2 = new Student("Anne", "12-08-1999", 22, 002);
        Student student3 = new Student("David", "05-03-2000", 21, 003);

        //create course
        Course course1 = new Course("CSIT", startDate, endDate);

        //create modules
        Module module1 = new Module("Software Engineering", "CT417");
        Module module2 = new Module("Systems Modelling", "CT561");
        Module module3 = new Module("Machine Learning", "CT4101");

        //add modules to course
        course1.addModule(module1);
        course1.addModule(module2);
        course1.addModule(module3);

        //add students to module 1
        module1.addStudent(student1);
        module1.addStudent(student2);

        //add students to module 2
        module2.addStudent(student2);
        module2.addStudent(student3);

        //add students to module 3
        module3.addStudent(student1);
        module3.addStudent(student3);

        //set course for student
        student1.setCourse(course1);
        student2.setCourse(course1);
        student3.setCourse(course1);

        //Test course
        Assert.assertEquals(3, course1.getModules().size());
        Assert.assertEquals(3, course1.getStudents().size());

        //Test module
        Assert.assertEquals(2, module1.getStudents().size());
        Assert.assertEquals(2, module2.getStudents().size());
        Assert.assertEquals(2, module3.getStudents().size());

        //Test students
        Assert.assertEquals(2, student1.getModules().size());
        Assert.assertEquals(2, student2.getModules().size());
        Assert.assertEquals(2, student3.getModules().size());

        //Test course has correct students
        Assert.assertEquals("John20", course1.getStudents().get(0).getUsername());
        Assert.assertEquals("Anne22", course1.getStudents().get(1).getUsername());
        Assert.assertEquals("David21", course1.getStudents().get(2).getUsername());

        //Test students have correct Modules
        Assert.assertEquals("CT417", student1.getModules().get(0).getiD());
        Assert.assertEquals("CT4101", student1.getModules().get(1).getiD());
        Assert.assertEquals("CT417", student2.getModules().get(0).getiD());
        Assert.assertEquals("CT561", student2.getModules().get(1).getiD());
        Assert.assertEquals("CT561", student3.getModules().get(0).getiD());
        Assert.assertEquals("CT4101", student3.getModules().get(1).getiD());
    }
}
