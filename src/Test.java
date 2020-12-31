import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ReadExcel.ReadExcel;
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = in.next();
        System.out.println("请输入密码");
        String password = in.next();
        ReadExcel readExcel = new ReadExcel();
        FileInputStream file = new FileInputStream("src/user.xlsx");
        User[] users = readExcel.readExcel(file);
//        System.out.println(Arrays.toString(users));
        while (true){
            for (User user : users){
                if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                    System.out.println("Success");
                    break;
                }else{
                    System.out.println("False");
                }
            }
            break;
        }
    }
}
