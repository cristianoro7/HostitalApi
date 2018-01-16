package desperado.login.service;

import desperado.admin.user.domain.UserResult;
import desperado.base.Service;
import desperado.login.dao.LoginDao;

/**
 * Created by desperado on 18-1-12.
 */

public class LoginService implements Service {

    private LoginDao userDao;

    public LoginService(LoginDao userDao) {
        this.userDao = userDao;
    }

    public UserResult login(String account, String password) {
        UserResult userResult = new UserResult();
        int userId = userDao.getMatchCounts(account, password);
        if (userId > 0) {
            UserResult.User user = userDao.login(userId);
            userResult.addUser(user);
            setSuccess(userResult);
        }
        return userResult;
    }
}
