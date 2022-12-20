package connect1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Inserttext {
    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Connecttxt.Enall();
            String sql = "insert into customers(name) values(?)";
            ps = con.prepareStatement(sql);
            for (int i = 1; i <= 100000; i  ++) {
//                ps.setObject(1, i);  // 他这里是每插入一次都要提交一次，这样性能就会下降， 我们可以先暂存一定的数量， 然后再提交， 也就是进行批量提交
//                ps.execute();

                ps.setObject(1, i);
                ps.addBatch(); // 这里就是先暂存起来
                if (i % 500 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }

                // 然后还有一种就是  因为插入操作是DML然后这个是默认是提交的， 然后我们可以设置，先不提交，到最后一下提交
//                "set autocommit = false" 就行了


            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps);
        }
    }

    public void inm() {


        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            con = Connecttxt.Enall();
            String sql = "select id, name, email from customers where id = ?";
            ps = con.prepareStatement(sql);

            res = ps.executeQuery();

            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String email = res.getString("email");

            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps, res);
        }
    }
}
