package desperado.admin.user.service;

import java.util.List;

import desperado.admin.user.dao.UserDao;
import desperado.admin.user.domain.UserResult;
import desperado.base.Service;

/**
 * Created by desperado on 18-1-14.
 */

public class UserService implements Service {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserResult addUser(UserResult.User user) {
        UserResult result = new UserResult();
        int c = userDao.addUser(user);
        if (c > 0) {
            result.addUser(user);
        }
        setSuccess(result);
        return result;
    }

    public UserResult deleteUser(int id) {
        UserResult result = new UserResult();

        UserResult.User user = userDao.getUserById(id);
        if (user.getName() != null) {
            int c = userDao.deleteUser(id);
            if (c > 0) {
                result.addUser(user);
            }
        }
        setSuccess(result);
        return result;
    }

    public UserResult updateUser(UserResult.User user) {
        UserResult result = new UserResult();
        int c = userDao.updateUser(user);
        if (c > 0) {
            result.addUser(user);
            setSuccess(result);
        }
        return result;
    }

    public UserResult getUserById(int id) {
        UserResult result = new UserResult();
        UserResult.User user = userDao.getUserById(id);
        if (user.getName() != null) {
            result.addUser(user);
        }
        setSuccess(result);
        return result;
    }

    public UserResult listUser() {
        UserResult result = new UserResult();
        List<UserResult.User> list = userDao.listUser();
        if (list.size() > 0) {
            result.addUsers(list);
        }
        setSuccess(result);
        return result;
    }

    public UserResult listUserByTitle(int titleId) {
        UserResult result = new UserResult();
        List<UserResult.User> list = userDao.listUserByTitleId(titleId);
        if (list.size() > 0) {
            result.addUsers(list);
        }
        setSuccess(result);
        return result;
    }
}