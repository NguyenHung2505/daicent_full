package reflection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO implements DAOInterface <Product>{
    @Override
    public int insert(Product product) {
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCProduct.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            String sql = "INSERT INTO manage_product.product (IDProduct, ProductName, ProductPrice , ProductQuantity) "+
                    " VALUES ('"+product.getId()+"' , '"+product.getName()+"' , "+ product.getPrice()+" ,"+ product.getQuantity()+")";

            result = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

            // Bước 5:
            JDBCProduct.closeConnection(con);
//            JDBCProduct.printInfo(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(Product product) {
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCProduct.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "UPDATE manage_product.product "+
                    " SET " +
                    " ProductName='"+ product.getName()+"'"+
                    ", ProductPrice="+ product.getPrice()+
                    ", ProductQuantity="+ product.getQuantity()+
                    " WHERE UserID='"+ product.getId()+"\'";
            System.out.println(sql);
            result = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

            // Bước 5:
            JDBCProduct.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int delete(Product product) {
        int result = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCProduct.getConnection();

            // Bước 2: tạo ra đối tượng statement
            Statement st = con.createStatement();

            // Bước 3: thực thi câu lệnh SQL

            String sql = "DELETE from manage_product.product "+
                    " WHERE UserID='"+product.getId()+"'";
            System.out.println(sql);
            result = st.executeUpdate(sql);

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ result+" dòng bị thay đổi!");

            // Bước 5:
            JDBCProduct.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }
}
