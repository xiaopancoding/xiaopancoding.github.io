package connect1;



import java.lang.reflect.Field;
import java.sql.*;


public class Deletecustonmer {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Connecttxt.Enall();
            String sql = "delete from customers where id = ?";
            ps = conn.prepareStatement(sql);  //  写一个sql的预编译语句
            ps.setObject(1,2);  // 填充占位符， 第一个参数表示第几个占位符， 第二个参数表示你要填的数

            ps.execute();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(conn, ps);
        }

    }

    // 通用的增删改操作， 都可以认为是修改的
    public void update(String sql, Object ...str) {

        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = Connecttxt.Enall();

            ps = conn.prepareStatement(sql);
            for (int i = 0; i < str.length; i ++)
                ps.setObject(i+1, str[i]);

            ps.execute();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(conn, ps);
        }
    }

    // 同一张表中， 通用的查询操作
    public Customers queryForcustomer(String sql, Object ... str) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = Connecttxt.Enall();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < str.length; i ++)
                ps.setObject(i+1, str[i]);

            res = ps.executeQuery();

            // 获取结果集的元数据, 可以理解为 拿到了几个数据，
            ResultSetMetaData rsmd = res.getMetaData();
//            可以理解为拿到了 几个字段， 就是你在查询时，写了几个字段， 就返回几个
            int count = rsmd.getColumnCount();  // 返回数据有几个， 也就是字段有几个了
            if (res.next()) {
                Customers customers = new Customers();
                for (int i = 0; i < count; i ++) {
                    Object value = res.getObject(i+1);  // 获取某个字段上的值了， 因为不知道是什么类型的， 所以用最大的类Object来，表示， 因为所有的类都是它的子类， 这里就利用了多态性

                    // 获取列名, 是通过元数据里值 来获取列名
                    String columnname = rsmd.getColumnName(i+1);  // 这个是不推荐使用的
                    // 获取列的别名
                    String columnlabel = rsmd.getColumnLabel(i + 1);  // 这个方法是 如果类中的属性名和表中的字段名不一致时， 就给字段去给别名， 这个别名使用类的属性名 这样才可以反射到，
                    // 然后这个方法就是为了获取列的别名， 但是如果没有设置别名时， 那么获取的就是列名


                    // 给customers对象指定的columnname属性， 赋值为value： 通过反射
                    // 通过反射 找到类中属性名和这里的列名一样的 属性， 然后给这个属性进行赋值
//                    Field field = Customers.class.getDeclaredField()
                    Field field = Customers.class.getDeclaredField(columnname);
                    field.setAccessible(true);
//                    field.setAccessible(true);
                    field.set(customers, value);
                }
                return customers;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(conn, ps, res);
        }
        return null;
    }

    public Customers selectt(String sql, Object ... str) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            conn = Connecttxt.Enall();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < str.length; i ++)
                ps.setObject(i+1, str[i]);

//            ps.execute();

            res = ps.executeQuery();   // 获取一个结果集之后 就要获取这个结果集中的元数据
            // 利用结果集获取元数据
            ResultSetMetaData rsmd = res.getMetaData();
            int count = rsmd.getColumnCount();
            if (res.next()) {
                Customers customers = new Customers();
                for (int i = 0; i < count; i ++) {
                    Object value = res.getObject(i + 1);
                    String columnlabel = rsmd.getColumnLabel(i+1);

                    // 获取了表中的值和列名或是别名之后就要通过反射， 和类中的属性名对应起来
                    Field field = Customers.class.getDeclaredField(columnlabel);
                    field.setAccessible(true);
                    field.set(customers, value);

                }
                return customers;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(conn, ps, res);
        }

        return null;
    }


    public Customers gett(String sql, Object... str) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            con = Connecttxt.Enall();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < str.length; i ++)
                ps.setObject(i+1, str[i]);
            res = ps.executeQuery();
            ResultSetMetaData rsmd = ps.getMetaData();
            int count = rsmd.getColumnCount();
            if (res.next()) {
                Customers customers = new Customers();
                for (int i = 0; i < count; i ++) {
                    Object value = res.getObject(i+1);
                    String columnlabel = rsmd.getColumnLabel(i + 1);

                    Field field = Customers.class.getDeclaredField(columnlabel);
                    field.setAccessible(true);
                    field.set(customers, value);
                }
                return customers;
            }
        }catch(Exception e) {

            e.printStackTrace();
        }finally {

            Connecttxt.closeResource(con, ps, res);

        }
        return null;
    }

}
