package maven;


import java.util.List;

public class MavenRun {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.findAll();
        for (Product pd: productList) {
            System.out.println(pd);
        }
    }
}
