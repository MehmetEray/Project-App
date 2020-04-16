package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, table_number);
            // select
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public boolean selectDurum (int table_number) {

        String sql = "SELECT durum FROM customertables WHERE table_number = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, table_number);
            // select
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;



        // masa doluyken siparis verememe yapilacak
        //

        //
        //
        //
        //
        //

    }
    public static void main(String[] args) {

        selecttable select = new selecttable();
        // update the warehouse with id 3
        select.selectPay(3);
    }

}
