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
        DateTime startDate = new DateTime(2018, 9, 6, 0, 0);
        DateTime endDate = new DateTime(2022, 5, 6,0,0);
        Student student = new Student("John", "01-01-2001", 20, 001);
        Course course = new Course("CSIT", startDate, endDate);
        Module module = new Module("Software Engineering", "CT417");

        course.addModule(module);
        module.addStudent(student);
        student.setCourse(course);

        Assert.assertEquals(1, course.getModules().size());
        Assert.assertEquals(1, module.getStudents().size());
        Assert.assertEquals(1, course.getStudents().size());

        Assert.assertEquals("John", course.getStudents().get(0).getName());
        Assert.assertEquals("CT417", student.getModules().get(0).getiD());
    }
}
