package connect2;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.DataSources;
import connect1.Connecttxt;
import connect1.Customers;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;

public class Druid {

    public static void main(String[] args) throws Exception {


//        DruidDataSource dds = new DruidDataSource();

        DruidDataSource source = new DruidDataSource();

//        source.setDriverClassName("");
//        source.setUrl();
//        source.setUsername();
//        source.setPassword();
        Connection con = source.getConnection();

        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl();
//        dataSource.setPassword();
//        dataSource.setDriver();
//        dataSource.setUsername();


//        dds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dds.setUrl("jdbc:mysql://localhost:3306/test");
//        dds.setUsername("root");
//        dds.setPassword("pjm314159?");
//        Connection con = null;
//        try{
//            con = dds.getConnection();
////        System.out.println(con);
//
//            QueryRunner runner = new QueryRunner();  // 这个类当中封装了 针对于数据库的增删改查的操作
//
//       这个里面封装了很多 针对数据库的增删改查的操作，  这个里面也是考虑了事务的， 也就是出现了网路错误也不会有问题
        QueryRunner runner = new QueryRunner();

//            String sql = "insert into customers(name, email, birth)values(?, ?, ?)";
//            int count = runner.update(con, sql, "潘建民", "panjianmin@11.com", "2001-01-17");
//            // 这个返回值表示  这个sql语句影响了几条记录
//        }catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            Connecttxt.closeResource(con, null);
//            System.out.println("插入成功");

//        }

//        runner.update(con, sql, i, 1, w);

        Druid.selectll();
    }


    public static void selectll() {

        QueryRunner runner = new QueryRunner();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Connecttxt.Enall();

            String sql = "select id, name, email, birth from customers where id < ?";
            // 这个BeanHandler: 是ResultSetHandler接口中的实现类，用于封装表中的一条记录
//            BeanHandler<Customers> handler = new BeanHandler<>(Customers.class);
            // 这个里面是填写  你要把查到的数据封装到哪个类当中，
//            Customers customers = runner.query(con, sql, handler, 6);

            // 这里就是查询 多条记录， 也就是用集合去封装，这样就可以一下返回多条了
//            BeanHandler<Customers> customersBeanHandler = new BeanHandler<>(Customers.class);

            BeanListHandler<Customers> customer = new BeanListHandler<>(Customers.class);
            List<Customers> list = runner.query(con, sql, customer, 8);

            list.forEach(System.out::println);

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps);
        }

    }


    public <T> T dd(Class<T> clazz, String sql, Object ...str) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            con = Connecttxt.Enall();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < str.length; i ++)
                ps.setInt(1, 5);
            res = ps.executeQuery();
            ResultSetMetaData metaData = res.getMetaData();
            int cnt = metaData.getColumnCount();
            while (res.next()) {
                T t = clazz.newInstance();
                for (int i = 1; i <= cnt; i ++) {
                    Object val = res.getObject(i);
                    String name = metaData.getColumnLabel(i);

                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t, val);
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


    public void f() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            con = Connecttxt.Enall();
            String sql = "insert into customers(photo)value(?)";
//            FileInputStream is = new FileInputStream("ffff");
            ps = con.prepareStatement(sql);
//            ps.setBlob(1, is);
            res = ps.executeQuery();
            if (res.next()) {
                Blob blob = res.getBlob(1);
                InputStream in = blob.getBinaryStream();
                FileOutputStream fos = new FileOutputStream("ffff");
                byte[] bytes = new byte[1024];
                int len;
                while ((len = in.read(bytes)) != -1) {
                    fos.write(bytes,0, len);
                }
            }

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(con, ps);
        }
    }


    static {
        Connection con = null;
        try {
            con = Connecttxt.Enall();
        } catch (Exception e) {
            e.printStackTrace();
        }
        QueryRunner runner = new QueryRunner();

        String sql = "update customers set name = ? where id = ?";
        try {
            runner.update(con, sql, "122", 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
