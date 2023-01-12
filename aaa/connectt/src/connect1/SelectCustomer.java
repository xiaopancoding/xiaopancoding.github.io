package connect1;




import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectCustomer {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
//        SelectCustomer.insert1();
        SelectCustomer.duqu();
        try {
            conn = Connecttxt.Enall();
            String sql = "select id, name, email, birth from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 7);
            resultSet = ps.executeQuery();  // 这里是返回一个结果集, 如果是查询的话， 就要返回一个结果集，  判断了下这个结果集有没有下一条数据，


            // 这个结果集一开始指向的一个头节点， 是空的，
            if (resultSet.next()) {  // 这里的next就是一个指针，判断结果集的下一条是否有数据，如果有就返回true， 指针下移， 如果没有就返回false， 指针不动

                int id = resultSet.getInt(1);  // 这里的1 表示的是上面字段的位置， 从1开始，
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date date = resultSet.getDate(4);


                System.out.println("id: " + id + " name: " + name + " email: " + email + " date: " + date);

            }


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(conn, ps, resultSet);
        }

    }

    // 利用泛型返回
    public <T> T select(Class<T> clazz, String sql, Object... str) {
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
//                Customers customers = new Customers();
                T t = clazz.newInstance();
                for (int i = 0; i < count; i ++) {
                    Object value = res.getObject(i+1);
                    String columnlabel = rsmd.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnlabel);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                return t;
            }
        }catch(Exception e) {

            e.printStackTrace();
        }finally {

            Connecttxt.closeResource(con, ps, res);

        }
        return null;
    }

    public <T> List<T> sele(Class<T> clazz, String sql, Object...str) {
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

            ArrayList<T> list = new ArrayList<T>();

            while (res.next()) {
//                Customers customers = new Customers();
                T t = clazz.newInstance();
                for (int i = 0; i < count; i ++) {
                    Object value = res.getObject(i+1);
                    String columnlabel = rsmd.getColumnLabel(i + 1);

                    Field field = clazz.getDeclaredField(columnlabel);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                list.add(t);
            }
            return list;
        }catch(Exception e) {

            e.printStackTrace();
        }finally {

            Connecttxt.closeResource(con, ps, res);

        }
        return null;
    }

    // 这个是针对不同表的查询， 当然不同表就是不同类，， 因为是不确定是哪个类， 所以就要用泛型来表示
    public <T> T selectl(Class<T> clazz, String sql, Object...str) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            con = Connecttxt.Enall();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < str.length; i ++)
                ps.setObject(i+1, str[i]);
            res = ps.executeQuery();
            ResultSetMetaData rsmd = res.getMetaData();
            int count = rsmd.getColumnCount();
            if (res.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < count; i ++) {
                    Object value = res.getObject(i + 1);
                    String columnlabel = rsmd.getColumnLabel(i+1);

                    Field field = clazz.getDeclaredField(columnlabel);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                return t;

            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps, res);
        }
        return null;
    }

    public <T> ArrayList<T> selel(Class<T> clazz, String sql, Object...str) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            con = Connecttxt.Enall();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < str.length; i ++)
                ps.setObject(i+1, str[i]);
            res = ps.executeQuery();
            ResultSetMetaData rsmd = res.getMetaData();
            int count = rsmd.getColumnCount();
            ArrayList<T> list = new ArrayList<T>();
            if (res.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < count; i ++) {
                    Object value = res.getObject(i+1);
                    String name = rsmd.getColumnLabel(i+1);
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                list.add(t);
            }
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps, res);
        }

        return null;
    }


    public static void insert1() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Connecttxt.Enall();
            // 利用preparedStatement 插入blob文件， 这是一个大的二进制文件， 图片类型的
            String sql = "update customers set photo = ? where id = ?";
            ps = con.prepareStatement(sql);
            // 文件一般都是以流的形式传入的
            // 以文件流的形式
            FileInputStream is = new FileInputStream("C:\\Users\\天若有情天亦老\\Pictures\\R-C.jfif");

            ps.setBlob(1, is);
            ps.setInt(2, 5);
            ps.execute();
            System.out.println("插入成功");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps);
        }
    }


    public static void duqu() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            con = Connecttxt.Enall();
            String sql = "select photo from customers where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 16);
            res = ps.executeQuery();
            if (res.next()) {
                // 将blob类型的字段下载下来， 以文件的形式保存在本地
                Blob photo = res.getBlob("photo");
                InputStream is = photo.getBinaryStream();
                FileOutputStream fos = new FileOutputStream("211.png");
                byte[] bytes = new byte[1024];
                int len;
                while ((len = is.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }

                System.out.println("执行成功");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps, res);
        }
    }


    public void sss() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Connecttxt.Enall();
            String sql = "update customers set photo = ? where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(2, 6);
            // 要创建一个文件输入流， 用流的形式把一个图片以二进制文件以流的形式传进去



//            ps.setBlob(1, is);
            ps.execute();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps);
        }
    }

    public void selelll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            con = Connecttxt.Enall();
            String sql = "select photo from customers where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 5);
            res = ps.executeQuery();
            if (res.next()) {
                Blob blob = res.getBlob("photo");

                InputStream is = blob.getBinaryStream();
                FileOutputStream fos = new FileOutputStream("11.png");
                byte[] byte2 = new byte[1024];
                int len;
                while ((len = is.read(byte2)) != -1) {
                    fos.write(byte2, 0, len);
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps, res);
        }
    }

//    Blob blob = res.getBlob();
//    InputStream is = blob.getBinaryStream();
//    FileOutputStream fos = new FileOutputStream("weafwe");
//    byte[] bytes = new byte[1024];
//    int len;
//    while ((len = is.read(blob)) != -1) {
//        fos.write(bytes, 0, len);
//    }
}
