package user;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.Connection;
import java.util.List;


public abstract class Dao {

    private  QueryRunner runner = new QueryRunner();
    //  这个可以执行增删改
    public  int update(String sql, Object... str) {
        Connection con = null;
        try {
            con = jdbcUtils.getConnection();
            int update = runner.update(con, sql, str);
            return update;    // 这里表示插入成功影响了几条数据
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(con);
        }
        return -1;   // 这里表示插入不成功
    }

    //  这里是返回多条记录
    public  <T> List<T> SelectSome(Class<T> type, String sql, Object... str) {
        Connection con = null;
        try {
            con = jdbcUtils.getConnection();
            return runner.query(con, sql, new BeanListHandler<>(type), str);
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            jdbcUtils.close(con);
        }
        return null;
    }


    // 返回一条记录
    public  <T> T select2(Class<T> type, String sql, Object... str) {
        Connection con = null;
        try {
            con = jdbcUtils.getConnection();
            return runner.query(con, sql, new BeanHandler<T>(type), str);
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            jdbcUtils.close(con);
        }
        return null;
    }


    // 返回单个值
    public  Object select3(String sql, Object... str) {
        Connection con = null;
        try {
            con = jdbcUtils.getConnection();
            return runner.query(con, sql, new ScalarHandler(), str);
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            jdbcUtils.close(con);
        }
        return null;
    }


}
