package connect1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Alterjdbc {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = Connecttxt.Enall();
            // 写sql语句， 形成预编译的sql语句， 利用占位符， 暂时填充
            String sql = "update customers set name = ? where name = ?";
            ps = conn.prepareStatement(sql);

            // 填充占位符， 要修改什么，
            ps.setString(1, "木吒");
            ps.setString(2, "金吒");





            ps.execute();
            System.out.println("执行成功");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(conn, ps);
        }

    }

}
