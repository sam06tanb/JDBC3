package application;
import application.data.ConnectionJDBC;
import db.DB;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        ConnectionJDBC connectionJDBC = new ConnectionJDBC();


        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = connectionJDBC.getConnection();
            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE DepartmentId = ?");


            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);

                    ;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}