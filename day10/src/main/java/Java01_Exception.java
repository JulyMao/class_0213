import java.util.List;

public class Java01_Exception {
    public static void main(String[] args) {



        List list = null;

        for ( Object obj : list ) {
            System.out.println(obj);
        }
    }
    public static void test( int age ) {
        System.out.println( "年龄 = " + age );
    }
}
class UserJava {
    public static Integer age;
    public static Integer id;
}
