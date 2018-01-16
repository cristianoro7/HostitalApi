package desperado.admin.user.dao;

import java.util.List;

import desperado.admin.user.domain.UserResult;

/**
 * Created by desperado on 18-1-14.
 */

public interface UserDao {

    int addUser(UserResult.User user);

    int updateUser(UserResult.User user);

    int deleteUser(int id);

    UserResult.User getUserById(int id);

    List<UserResult.User> listUser();

    List<UserResult.User> listUserByTitleId(int titleId);

}
