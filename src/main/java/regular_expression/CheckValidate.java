package regular_expression;

import java.util.Scanner;

public class CheckValidate {
    public static void main(String[] args) {
        boolean sdt;
        Scanner sc = new Scanner(System.in);
        do {
            String phonePattern = "\\d{3}-\\d{2}-\\d{7}";
            System.out.print("nhập số điện thoại theo--> (xxx-xx-x7 lần): ");
            String input = sc.next();
            sdt = input.matches(phonePattern);
            if (!sdt) System.out.println("Invalid data!");
        } while (!sdt);
        System.out.println("Valid data");


//        System.out.println("------------------------------------");

//          boolean gmail ;
//        Scanner scanner = new Scanner(System.in);
//        do{
//            String emailPattern = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{5,}\\.[\\w]{5,})$";
//            System.out.println("1: bắt đầu phải có ít nhất 2 chữ trước @ và có ít nhất 1 chữ sau @" + "\n" +
//                    "2: bắt buộc phải có @ và ." + "\n" +
//                    "3: không được viết số đầu tiên" + "\n" +
//                    "4: không đc viết chữ có dấu hay ký tự đặc biệt trừ - và _");
//            System.out.println("mời nhập  gmail theo ---> (xxx@xxx) : ");
//            String input = scanner.next();
//            gmail = input.matches(emailPattern);
//            if(!gmail) System.out.println("Invalid data");
//        }while (!gmail);
//        System.out.println("Valid data");

//        System.out.println("---------------------------------------------");

//        boolean password ;
//        Scanner scanner = new Scanner(System.in);
//        do{
//            String emailPattern = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
//            System.out.println("1:Có tối thiểu 8 ký tự" + "\n" +
//                    "2: Có ít nhất một kí tự viết thường (a-z)" + "\n" +
//                    "3: Có ít nhất một kí tự viết hoa (A-Z)" + "\n" +
//                    "4: Có ít nhất một chữ số (0-9)" + "\n" +
//                    "5: Có ít nhất một ký tự đặc biệt (!@#$%^&)");
//            System.out.println("mời nhập  password ---> : ");
//            String input = scanner.next();
//            password = input.matches(emailPattern);
//            if(!password) System.out.println("Invalid data");
//        }while (!password);
//        System.out.println("Valid data");


    }
}