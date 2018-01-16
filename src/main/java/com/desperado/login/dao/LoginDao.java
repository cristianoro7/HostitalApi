package desperado.login.dao;

import desperado.admin.user.domain.UserResult;

/**
 * Created by desperado on 18-1-12.
 */

public interface LoginDao {
    UserResult.User login(int id);

    int getMatchCounts(String account, String password);
}
