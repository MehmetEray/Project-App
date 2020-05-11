package sample;

import java.sql.*;

public class selecttable {

    private Connection connect() {
        Connection conn;
        // SQLite connection string
        String url = "jdbc:sqlite:SQLite.db";
        conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public double selectPay(int table_number) {
        String sql = "SELECT payment FROM customertables WHERE table_number = ?";
        double se = 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, table_number);
            // select
//            pstmt.executeUpdate();
            ResultSet rs =pstmt.executeQuery();
            if (rs.next()) {
                se = rs.getDouble("payment");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return se;
    }
    public boolean selectDurum (int table_number) {
        String sql = "SELECT durum FROM customertables WHERE table_number = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, table_number);
            // select
            pstmt.executeUpdate();
            System.out.println(pstmt.executeUpdate());

//            ResultSet rs = pstmt.executeQuery();
//            return rs.next();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return false;
    }

    public static void main(String[] args) {

        selecttable select = new selecttable();
        // update the warehouse with id 3
        select.selectPay(3);
    }

}
