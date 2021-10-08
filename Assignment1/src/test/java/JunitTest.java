import org.junit.Assert;
import org.junit.Test;

public class JunitTest {

    public static void main(String[] args){
        JunitTest test = new JunitTest();
        test.simpleStudentTest();
    }

    @Test
    public void simpleStudentTest(){
        Student student = new Student("John", "10-12-2000", 21, 001);
        String username = student.getUsername();
        Assert.assertEquals("John21", username);
    }
}
