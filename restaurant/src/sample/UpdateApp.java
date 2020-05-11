package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateApp {

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

        public void updatePay(int table_number, double payment) {
            String sql = "UPDATE customertables SET payment = ? WHERE table_number = ?";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setInt(1, table_number);
                pstmt.setDouble(2, payment);
                // update
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void updateDurum(int table_number, boolean durum) {

            String sql = "UPDATE main.customertables SET durum = ? WHERE table_number = ?";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setBoolean(1, durum);
                pstmt.setInt(2, table_number);
                // update
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        public void updateAll(int table_number, boolean durum,double payment) {
            String sql = "UPDATE customertables SET durum = ? , payment = ? WHERE table_number = ?";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setBoolean(1, durum);
                pstmt.setDouble(2, payment);
                pstmt.setInt(3, table_number);
                // update
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public static void main(String[] args) {

            UpdateApp app = new UpdateApp();
            // update the warehouse with id 3
            app.updatePay(3, 29.9);
        }

    }

