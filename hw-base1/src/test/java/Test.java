import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    @org.junit.Test
    public void test() throws ParseException {

        System.out.println("hello word");

        //2023/5/26
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse("2023/5/26");

    }

}
