package connect1;

import java.sql.*;
import java.util.ArrayList;

public class Ml {

    public static void main(String[] args) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try{
            con = Connecttxt.Enall();
            String sql = "select id, name, email, birth from customers where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 7);
            res = ps.executeQuery();
            ArrayList<Customers> customers = new ArrayList<>();
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String email = res.getString("email");
                Date birth = res.getDate("birth");
//                customers.add()
                System.out.println(customers);

            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps, res);
        }

    }
}
