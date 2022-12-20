package connect1;

import java.sql.*;

public class Connecttxt {

    public static Connection Enall() throws Exception {
        Class.forName("con.mysql.cj.jdbc.Driver");
//        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
//        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "pjm314159?";

        return DriverManager.getConnection(url, user, password);
    }

    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null)
                ps.close();  // 执行的关闭
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();  // 连接的关闭
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 这里形成了 重载，  因为方法名相同， 但是参数列表不同
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();  // 执行的关闭
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();  // 连接的关闭
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if (rs != null)
                rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
