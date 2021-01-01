import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import ReadExcel.ReadExcelToUser;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = in.next();
        System.out.println("请输入密码");
        String password = in.next();
        ReadExcelToUser readExcel = new ReadExcelToUser();
        InputStream file = Class.forName("Test").getResourceAsStream("/user.xlsx");
        User[] users = readExcel.readExcel(file);
//        System.out.println(Arrays.toString(users));
        while (true){
            for (User user : users){
                if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                    System.out.println("Success");
                    /*
                    显示商品信息
                     */

                    break;
                }else{
                    System.out.println("False");
                }
            }
            break;
        }
    }
}
