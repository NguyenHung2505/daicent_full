package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductReflection implements DAOInterface<Product>{
    public static ProductReflection getInstance(){
        return new ProductReflection();
    }

    @Override
    public int insert(Product product) {
        int result = 0;
        try {
            Connection connection = JDBCProduct.getConnection();
            Class<?> listClass = product.getClass();
            Field[] fields = listClass.getDeclaredFields();
            int idPoduct = 0;
            String name = "";
            String price = "";
            String quantity = "";
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (field.getName().equals("id")) {
                        idPoduct = (int) field.get(product);
                    }
                    if (field.getName().equals("username")) {
                        name = (String) field.get(product);
                    }
                    if (field.getName().equals("password")) {
                        price = (String) field.get(product);
                    }
                    if (field.getName().equals("quantity")) {
                        quantity = (String) field.get(product);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            Class productClass= Product.class;
            Annotation annotation = productClass.getAnnotation(ProductAnnotation.class);
            ProductAnnotation productAnnotation = null;
            if (annotation instanceof ProductAnnotation) {
                productAnnotation = (ProductAnnotation) annotation;
            }

            String sql = "INSERT INTO manage_product.product (IDProduct, ProductName, ProductPrice , ProductQuantity) "+
                    " VALUES ('"+idPoduct+"' , '"+name+"' , '"+ price+"' , '"+quantity+"')";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeUpdate();
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

//        JDBCUtil.printInfo(connection);
            JDBCProduct.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();


        }
        return result;

        }

    @Override
    public int update(Product product) {
        int result = 0;
        try {
            Connection connection = JDBCProduct.getConnection();
            Class<?> listClass = product.getClass();
            Field [] fields = listClass.getDeclaredFields();
            int idProduct = 0;
            String name = "";
            String price = "";
            String quantity = "";
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (field.getName().equals("id")) {
                        idProduct = (int) field.get(product);
                    }
                    if (field.getName().equals("name")) {
                        name = (String) field.get(product);
                    }
                    if (field.getName().equals("price")) {
                        price = (String) field.get(product);
                    }
                    if (field.getName().equals("quantity")){
                        quantity = (String) field.get(product);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            Class productClass= Product.class;
            Annotation annotation = productClass.getAnnotation(ProductAnnotation.class);
            ProductAnnotation productAnnotation = null;
            if (annotation instanceof ProductAnnotation) {
                productAnnotation = (ProductAnnotation) annotation;
            }

            String sql = "UPDATE manage_product.product SET name = '"+name+"', price = '"+price+"' , quantity = '"+quantity+"' WHERE IDProduct = '"+idProduct+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeUpdate();
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

//            JDBCUtil.printInfo(connection);
            JDBCProduct.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Product product) {
        int result = 0;
        try {
            Connection connection = JDBCProduct.getConnection();
            Class<?> listClass = product.getClass();
            Field [] fields = listClass.getDeclaredFields();
            int idProduct = 0;
            String name= "";
            String price = "";
            String quantity = "";
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (field.getName().equals("id")) {
                        idProduct = (int) field.get(product);
                    }
                    if (field.getName().equals("name")) {
                        name = (String) field.get(product);
                    }
                    if (field.getName().equals("price")) {
                        price = (String) field.get(product);
                    }
                    if (field.getName().equals("quantity")){
                        quantity = (String) field.get("quantity");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            Class productClass= Product.class;
            Annotation annotation = productClass.getAnnotation(ProductAnnotation.class);
           ProductAnnotation userAnnotation = null;
            if (annotation instanceof ProductAnnotation) {
                userAnnotation = (ProductAnnotation) annotation;
            }

            String sql = "DELETE FROM manage_product.product WHERE IDProduct = '"+idProduct+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeUpdate();
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    };


