import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

import ReadExcel.ReadExcelToProduct;
import ReadExcel.ReadExcelToUser;

public class Test {
    static Scanner in = new Scanner(System.in);
    static InputStream productFile;
    static InputStream userFile;

    static {
        try {
            userFile = Class.forName("Test").getResourceAsStream("/user.xlsx");
            productFile = Class.forName("Test").getResourceAsStream("/product.xlsx");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        System.out.println("请输入用户名");
        String username = in.next();
        System.out.println("请输入密码");
        String password = in.next();
        ReadExcelToUser readUserExcel = new ReadExcelToUser();
        System.out.println(userFile);
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
                    viewShop(products);
                    /*
                    创建购物车
                     */
                    int count = 0;
                    Product[] productCart = new Product[3];
                    /*
                    购物或者查看
                     */
                    while (true){
                        if (productCart[productCart.length-1] != null){
                            break;
                        }
                        System.out.println("查看购物车请按《1》");
                        System.out.println("继续购物请按《2》");
                        int changeId = in.nextInt();
                        switch (changeId){
                            case 1 : viewShop(productCart);break;
                            case 2 : addShopToCart(count,productCart);count++;break;
                        }
                    }
                    break;
                }else{
                    System.out.println("False");
                }
            }
            break;
        }
    }

    private static void addShopToCart(int count,Product[] productCart) throws ClassNotFoundException {
        System.out.println("请输入商品ID，把该商品加入购物车：");
        String id = in.next();
        ReadExcelToProduct readExcelToProduct = new ReadExcelToProduct();
        System.out.println(productFile);
        productFile = null;
        productFile = Class.forName("Test").getResourceAsStream("/product.xlsx");//inputStream尽量实现复用
        Product product = readExcelToProduct.productById(id, productFile);
        productCart[count] = product;
    }
    private static void viewShop(Product[] products){
        if (products == null){
            System.out.println("商品列表为空");
        }else{
            for (Product product : products){
                if (product != null){
                    System.out.print(product.getId()+"\t"+product.getName()+"\t"
                            +product.getPrice()+"\t"+product.getDesc()+"\n");
                }else{
                    break;
                }
            }
        }
    }
}
