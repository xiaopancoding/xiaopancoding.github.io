package user;

public interface CaoZuo {


    /**
     * 根据用户名查询信息
     * 如果返回null则说明没有这个用户， 则这个用户名是可以注册的
     * @param username
     */
    public userBean selectUsername(String username);


    /**
     * 返回用户的用户名和密码
     * @param username
     * @param password
     * @return
     */
    public userBean selectUsernameAndPassword(String username, String password);

    /**
     * 用于保存用户的信息
     * @param user
     * @return
     */
    public int saveUser(userBean user);

}
