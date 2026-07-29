package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mutter;

public class MutterDAO {
    private final String url = "jdbc:postgresql://localhost:5432/dokotsubu";
    private final String user = "postgres";
    private final String password = "postgres";

    public List<Mutter> findAll() {
        List<Mutter> mutterList = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return mutterList;
        }
        String sql = "SELECT * FROM mutter ORDER BY id DESC";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Mutter mutter = new Mutter();
                mutter.setId(rs.getInt("ID"));
                mutter.setUserName(rs.getString("NAME"));
                mutter.setText(rs.getString("TEXT"));
                mutterList.add(mutter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mutterList;
    }

    // Mutterレコードを1件追加する。
    public boolean create(Mutter mutter) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        String sql = "INSERT INTO mutter (NAME, TEXT) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, mutter.getUserName());
            stmt.setString(2, mutter.getText());
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}