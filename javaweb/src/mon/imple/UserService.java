package mon.imple;
import user.userBean;

public interface UserService {

    /**
     * 注册
     * @param user
     */
    public void zhuce(userBean user);


    /**
     * 登入
     * @param user
     * @return
     */
    public userBean login(userBean user);


    /**
     * 检查用户名是否存在
     * @param username
     * @return
     */
    public boolean existsUsername(String username);

}
