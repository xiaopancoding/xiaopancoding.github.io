package connect1;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectText {


    public static void main(String[] args) throws SQLException {

        Driver driver = new  com.mysql.cj.jdbc.Driver();  // Driver这个实现了jdbc这个标准，
        //前面的  jdbc:mysql://  这个就有点像  网络协议的  https://    也就是jdbc:mysql  这个就相当于https
        // jdbc是主协议，  mysql是子协议  3306是端口号  后面跟着的是你要使用的数据库
        // localhost:  ip地址
        // 3306： 默认的mysql端口号

        String url = "jdbc:mysql://localhost:3306/atguigudb";
        // 将用户名和密码封装在Properties中

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "pjm314159?");


        // 连接数据库的接口
        Connection conn = driver.connect(url, info);  // 这里返回的是一个接口

        System.out.println(conn);
        System.out.println("成功连接数据库");



    }

    // 方式2： 对方式一的迭代， 是程序不出现第三方的api，使得程序具有更好的可移植性
    public void connecttext2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        // 使用反射，获取Driver实现类对象
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();


        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "pjm314159?");


        // 连接数据库的接口
//        Connection conn = driver.connect(url, info);  // 这里返回的是一个接口

//        System.out.println(conn);
        System.out.println("成功连接数据库");
    }


    public void connecttext3() throws Exception {
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        String url = "jdbc:mysql://localhost:3306/text";
        String user = "root";
        String password = "123456";
        //注册驱动
        DriverManager.registerDriver(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }


    public void connecttext4() throws Exception {
//        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
//        DriverManager.registerDriver(driver);
        // 相比与方式三  可以直接去掉注册驱动， 这是因为在mysql的Deiver类中已经帮你实现了， 写在静态的代码块中了
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/text";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);


    }

}
