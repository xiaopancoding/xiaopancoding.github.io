package user;

public class userDao extends Dao implements CaoZuo{
    //实现返回用户名的方法
    @Override
    public userBean selectUsername(String username) {
        String sql ="select `id`, `name`, `password`, `email` from t_user where name = ? ";
        return select2(userBean.class, sql, username);
    }

    //实现返回用户名和密码的方法
    @Override
    public userBean selectUsernameAndPassword(String username, String password) {
        String sql ="select `id`, `name`, `password`, `email` from t_user where name = ? and password = ?";
        return select2(userBean.class, sql, username, password);
    }

    //  实现保存数据的方法，也就是插入数据的方法
    @Override
    public int saveUser(userBean user) {
        String sql = "insert into t_user(`name`, `password`, `email`)values(?, ?, ?)";

        return update(sql, user.getName(), user.getPassword(), user.getEmail());
    }
}
