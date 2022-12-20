package connect1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务： 一组逻辑操作单元， 使数据从一种状态变为另一种状态
 *         > 一组逻辑操作单元：  一个或多个DML操作
 *
 *   其实简单的来讲就是要么都发生  要么都不发生，
 *
 *   事务处理，  要保证所有事务都作为一个工作单元来执行， 即使出现了故障也是不能改变原来状态， 只能是成功和失败没有中间的状态
 *
 *   如果一旦出错就要回滚到最初的状态
 *
 *
 *
 *   // 这个就是事务的要点
 *   // 就比如转账就一个事务，  只能要么都成功 要么都失败，  总不能说转到一半没有转出去， 然后转的人还扣了钱了  这就不行了
 *   //  这时就要使这个扣掉的进行回滚， 使他变回来， 这样就会都没有成功，
 *
 *
 *
 *
 */



public class Shiwu {

    public static void main(String[] args)  {
        Connection con = null;
        try {

            con = Connecttxt.Enall();
            // 1.  取消自动提交

            con.setAutoCommit(false);  // 因为，DML是默认是提交， 所以要设置为不自动提交

            String sql1 = "update customers set name = ? where id = ?";
            Shiwu.lelle(con, sql1, "abc", 4);  // 这里就是把连接作为参数， 这样就可以把两个操作放在一个连接里， 这样就避免了 关闭连接而提交了

            // 这里是模拟网络异常
            System.out.println(10 / 0);  // 这里碰到了异常， 所以要回滚


            String sql2 = "update customers set name = ? where id = ?";
            Shiwu.lelle(con, sql2, "we", 2);

            // 2.提交数据
            con.commit(); // 之后在手动提交

        }catch(Exception e) {
            e.printStackTrace();
            // 3. 出现异常  再回滚数据
            try {
                if (con != null)
                    con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            // 最后要把取消掉的自动提交功能给打开
            try {
                if (con != null)
                    con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Connecttxt.closeResource(con, null);
        }




        /**
         *
         * 1. 这里如果不加这个网络异常的话， 就会正常进行， 也就是这个这两个数据会被同时改变，
         * 把这个理解成转账的话，那么上面的就会减少钱，下面的就会增加钱
         *
         * 但是一旦加上了这个网络异常的话， 就会发生， 上面的减少钱， 然后下面还没有加钱， 也就是说这个状态没有同步了， 对于两个来讲  就少钱了
         * 这个就是事务放生错误了
         *
         * 我们就要解决这种事
         *
         * 其实发生这样的事， 那是因为DML的操作是默认提交的
         *
         *2.  数据一旦提交 就不可以回滚了
         *
         * 3.1 DDL操作一旦执行，都会自动提交
         *         > set autocommit = false 对DDL无效
         * 3.2 DML默认情况下， 一旦执行就会自动提交
         *         > 但是我们可以通过 set autocommit = false 的方式取消DML操作的自动提交
         * 3.3 默认关闭连接时，会自动提交
         *
         * 我们就要解决这些问题就能 使这个事务  同时转移到一种状态  或保持原来的状态
         *
         * 这些是缺一不可的，  一旦有一个没有成功就会被提交， 这样发生了网络异常等就不能回滚了
         *
         * 我们可以这样  就是先创一个连接， 然后这个连接不要关， 之后用这个连接在做一个操作，  这样就都在一个连接里的  就不存在关闭连接的事情了
         *
         * 所以我们就可以把连接作为参数进行传入，就行了， 到最后一起关掉就行
         *
         *
         */






    }

    public static void lelle(Connection con, String sql, Object... str) {
        PreparedStatement ps = null;

        try {
            con = Connecttxt.Enall();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < str.length; i ++)
                ps.setObject(i+1, str[i]);
            ps.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            Connecttxt.closeResource(null, ps);
        }
    }

}
