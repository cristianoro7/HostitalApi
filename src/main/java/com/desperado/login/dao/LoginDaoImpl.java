package desperado.login.dao;

import java.nio.charset.Charset;
import java.util.Base64;

import desperado.admin.user.domain.UserResult;
import desperado.base.AbstractDao;
import desperado.base.RowMapper;

/**
 * Created by desperado on 18-1-12.
 */

public class LoginDaoImpl extends AbstractDao implements LoginDao {


    private static final String SQL_QUERY_USER = "SELECT user_id, user_name, sex, age, tel_phone," +
            "title_name, department_name, location " +
            "FROM v_user " +
            "WHERE user_id = ?";

    private static final String SQL_GET_MATCH_COUNTS = "SELECT user_id FROM h_user " +
            "WHERE user_account=? AND passwd=?";

    @Override
    public UserResult.User login(int userId) {
        UserResult.User user = new UserResult.User();
        query(new Object[]{userId}, resultSet -> {
            user.setId(String.valueOf(resultSet.getInt(1)));
            user.setName(resultSet.getString(2));
            user.setSex(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
            user.setTel(resultSet.getString(5));
            user.setTitle(resultSet.getString(6));
            user.setDepartmentName(resultSet.getString(7));
            user.setConsultingRoomName(resultSet.getString(8));
        });
        return user;
    }

    @Override
    public int getMatchCounts(String account, String password) {
        final int[] matchCounts = {0};
        query(SQL_GET_MATCH_COUNTS, new Object[]{account, encodePassword(password)}, resultSet ->
                matchCounts[0] = resultSet.getInt(1)
        );
        return matchCounts[0];
    }

    private void query(Object[] args, RowMapper rowMapper) {
        super.query(SQL_QUERY_USER, args, rowMapper);
    }

    private String encodePassword(String password) {
        byte[] pwStream = Base64.getEncoder().encode(password.getBytes());
        return new String(pwStream, Charset.forName("UTF-8"));
    }
}
