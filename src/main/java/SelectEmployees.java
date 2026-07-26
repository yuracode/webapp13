import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployees {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/skilldb";
        String user = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String sql = "SELECT * FROM employees_tbl";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int employeeId = rs.getInt("ID");
                String employeeName = rs.getString("NAME");
                int age = rs.getInt("AGE");
                System.out.println("Employee ID: " + employeeId + ", Name: " + employeeName + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}