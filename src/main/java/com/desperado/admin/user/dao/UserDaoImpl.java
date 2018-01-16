package desperado.admin.user.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import desperado.admin.user.domain.UserResult;
import desperado.base.AbstractDao;

/**
 * Created by desperado on 18-1-14.
 */

public class UserDaoImpl extends AbstractDao implements UserDao {

    private static final String SQL_ADD_USER = "INSERT INTO h_user(user_name, sex, age, tel_phone, title_id, user_account," +
            "passwd, department_id, consulting_room_id, create_time) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String SQL_DELETE_USER = "DELETE FROM " +
            "h_user WHERE user_id = ?;";

    private static final String SQL_QUERY_USERS_BY_TITLE_ID = "SELECT user_id, user_name, sex, age, tel_phone, " +
            "title_id, title_name, department_name, location, department_id, consulting_room_id " +
            "FROM v_user " +
            "WHERE title_id = ?";

    private static final String SQL_QUERY_USER_BY_ID = "SELECT user_name, sex, age, tel_phone, title_id " +
            "FROM h_user " +
            "WHERE user_id = ?";

    private static final String SQL_UPDATE_USER = "UPDATE h_user " +
            "SET user_name = ?, sex = ?, age = ?, tel_phone = ?, title_id = ?, department_id = ?, consulting_room_id = ?," +
            "modified_time = ? " +
            "WHERE user_id = ?";

    private static final String SQL_QUERY_ALL_USER = "SELECT user_id, user_name, sex, age, tel_phone, title_id," +
            "title_name, department_name, location, department_id, consulting_room_id " +
            "FROM v_user";

    @Override
    public int addUser(UserResult.User user) {
        return insert(SQL_ADD_USER, new Object[]{user.getName(), user.getSex(), user.getAge(),
                user.getTel(), Integer.parseInt(user.getTitleId()), user.getAccount(), user.getPassword(),
                user.getDepartmentId(), user.getConsultingRoomId(), new Timestamp(System.currentTimeMillis())});
    }

    @Override
    public int updateUser(UserResult.User user) {
        return update(SQL_UPDATE_USER, new Object[]{user.getName(), user.getSex(), user.getAge(), user.getTel(),
                Integer.parseInt(user.getTitleId()), user.getDepartmentId(), user.getConsultingRoomId(),
                new Timestamp(System.currentTimeMillis()),
                Integer.parseInt(user.getId())});
    }

    @Override
    public int deleteUser(int id) {
        return delete(SQL_DELETE_USER, new Object[]{id});
    }

    @Override
    public UserResult.User getUserById(int id) {
        UserResult.User user = new UserResult.User();
        query(SQL_QUERY_USER_BY_ID, new Object[]{id}, resultSet -> {
            user.setId(String.valueOf(id));
            user.setName(resultSet.getString(1));
            user.setSex(resultSet.getString(2));
            user.setAge(resultSet.getInt(3));
            user.setTel(resultSet.getString(4));
            user.setTitleId(String.valueOf(resultSet.getInt(5)));
        });
        return user;
    }

    @Override
    public List<UserResult.User> listUser() {
        List<UserResult.User> users = new ArrayList<>();
        query(SQL_QUERY_ALL_USER, null, resultSet -> {
            UserResult.User user = new UserResult.User();
            user.setId(String.valueOf(resultSet.getInt(1)));
            user.setName(resultSet.getString(2));
            user.setSex(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
            user.setTel(resultSet.getString(5));
            user.setTitleId(String.valueOf(resultSet.getInt(6)));
            user.setTitle(resultSet.getString(7));
            user.setDepartmentName(resultSet.getString(8));
            user.setConsultingRoomName(resultSet.getString(9));
            user.setDepartmentId(String.valueOf(resultSet.getInt(10)));
            user.setConsultingRoomId(String.valueOf(resultSet.getInt(11)));
            users.add(user);
        });
        return users;
    }

    @Override
    public List<UserResult.User> listUserByTitleId(int titleId) {
        List<UserResult.User> list = new ArrayList<>();
        query(SQL_QUERY_USERS_BY_TITLE_ID, new Object[]{titleId}, resultSet -> {
            UserResult.User user = new UserResult.User();
            user.setId(String.valueOf(resultSet.getInt(1)));
            user.setName(resultSet.getString(2));
            user.setSex(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));
            user.setTel(resultSet.getString(5));
            user.setTitleId(String.valueOf(resultSet.getString(6)));
            user.setTitle(resultSet.getString(7));
            user.setDepartmentName(resultSet.getString(8));
            user.setConsultingRoomName(resultSet.getString(9));
            user.setDepartmentId(String.valueOf(resultSet.getInt(10)));
            user.setConsultingRoomId(String.valueOf(resultSet.getInt(11)));
            list.add(user);
        });
        return list;
    }
}
