package connect2;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3p0 {

//    public static void main(String[] args) throws Exception {
//
//        // 获取c3p0数据库连接池
//        ComboPooledDataSource cpds = new ComboPooledDataSource();
//        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");  // 加载数据库驱动
//        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");  // 设置哪个数据库
//        cpds.setUser("root");  // 设置用户名
//        cpds.setPassword("pjm314159?");  // 设置密码
//
//        // 设置初始数据库连接池中连接数
//        cpds.setInitialPoolSize(10);  // 设置连接池最多有10个连接
//        Connection con = cpds.getConnection();
//        System.out.println(con);
//        // 如果这里关闭了连接那么这个连接又回到了连接池当中
//
//        // 销毁连接池，  一般情况是不会关闭连接池的
////        DataSources.destroy(cpds);
//    }
    // 这样是因为 就只造了一个， 不然放在里面的话， 没调用一次方法都会执行一次， 也就是不会找很多连接池， 这样就得不偿失了
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("hello3p0");

    public static void main(String[] args) throws Exception {
        Connection con = cpds.getConnection();
//        System.out.println(con);
        String sql = "select name from customers where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, 5);
        ResultSet res = ps.executeQuery();
        if (res.next()) {
            System.out.println(res.getString(1));
        }

    }

}
