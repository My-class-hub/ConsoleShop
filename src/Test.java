import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import ReadExcel.ReadExcelToProduct;
import ReadExcel.ReadExcelToUser;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = in.next();
        System.out.println("请输入密码");
        String password = in.next();
        ReadExcelToUser readUserExcel = new ReadExcelToUser();
        InputStream userFile = Class.forName("Test").getResourceAsStream("/user.xlsx");
        System.out.println(userFile);
        InputStream productFile = Class.forName("Test").getResourceAsStream("/product.xlsx");
        System.out.println(productFile);
        User[] users = readUserExcel.readExcel(userFile);
//        System.out.println(Arrays.toString(users));
        while (true){
            for (User user : users){
                if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                    System.out.println("Success");
                    /*
                    显示商品信息
                     */
                    ReadExcelToProduct readProductExcel = new ReadExcelToProduct();
                    Product[] products = readProductExcel.readExcel(productFile);
                    for (Product product : products) {
                        System.out.print(product.getId()+"\t"+product.getName()+"\t"
                                +product.getPrice()+"\t"+product.getDesc()+"\n");
                    }
                    break;
                }else{
                    System.out.println("False");
                }
            }
            break;
        }
    }
}
