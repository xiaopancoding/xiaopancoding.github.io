package mon;

import mon.imple.UserService;
import user.CaoZuo;
import user.userBean;
import user.userDao;

public class UserServiceImple implements UserService {


    private CaoZuo caoZuo = new userDao();

    @Override
    public void zhuce(userBean user) {
        caoZuo.saveUser(user);
    }

    @Override
    public userBean login(userBean user) {
        return caoZuo.selectUsernameAndPassword(user.getName(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (caoZuo.selectUsername(username) != null) {
            return true;
        }else {
            return false;
        }
    }

}
