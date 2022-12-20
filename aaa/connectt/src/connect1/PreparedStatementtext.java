package connect1;

import java.sql.*;
import java.text.SimpleDateFormat;


//这里是增加了一条记录， 也就是增加的操作

public class PreparedStatementtext {

    public static void main(String[] args){

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Connecttxt.Enall();

            //        System.out.println(conn);
            // 要在连接的对象中找到  返回  PreparedStatement类型的方法

            // 这里就是预编译的sql语句
            String sql = "insert into customers(name,email,birth)values(?,?,?)";  // 这里的问号？  表示占位符， 说明这里是有数据的，  就是这里能决解Statement的sqp注入问题
            ps = conn.prepareStatement(sql);

            // 现在就是填充 上面的占位符
            ps.setString(1, "哪吒");  // 第一个参数表示第几个占位符， 是从1开始计算的
            ps.setString(2, "nezha@111");
            // 这里是为了控制时间的格式

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("2001-01-17");
            ps.setDate(3, new Date(date.getTime()));

            // 上面的就相当于只是写了sql的语句， 但是还没有执行，下面就要开始执行了
            ps.execute();  // execute就是执行的意思
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            // 资源的关闭
            Connecttxt.closeResource(conn, ps);
        }



    }



}
