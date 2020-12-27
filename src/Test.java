import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import ReadExcel.ReadExcel;
public class Test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("请输入用户名");
//        String username = in.next();
//        System.out.println("请输入密码");
//        String password = in.next();
        ReadExcel readExcel = new ReadExcel();
        File file = new File("C:\\Users\\lenovo\\IdeaProjects\\ConsoleShop\\src\\user.xlsx");
        User[] users = readExcel.readExcel(file);
        System.out.println(Arrays.toString(users));
    }
}
