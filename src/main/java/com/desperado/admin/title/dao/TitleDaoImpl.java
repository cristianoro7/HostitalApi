package desperado.admin.title.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import desperado.admin.title.domain.TitleResult;
import desperado.base.AbstractDao;

/**
 * Created by desperado on 18-1-13.
 */

public class TitleDaoImpl extends AbstractDao implements TitleDao {

    private static final String SQL_ADD_TITLE = "INSERT INTO user_title(title_name, create_time) " +
            "VALUES(?, ?);";

    private static final String SQL_DELETE_TITLE = "DELETE FROM " +
            "user_title WHERE title_id = ?;";

    private static final String SQL_QUERY_TITLE = "SELECT title_name " +
            "FROM user_title " +
            "WHERE title_id = ?";

    private static final String SQL_UPDATE_TITLE = "UPDATE user_title " +
            "SET title_name = ?, modified_time = ?" +
            "WHERE title_id = ?;";

    private static final String SQL_QUERY_ALL_TITLE = "SELECT title_id, title_name " +
            "FROM user_title;";

    @Override
    public int addTitle(TitleResult.Title title) {
        return insert(SQL_ADD_TITLE, new Object[]{title.getName(),
                new Timestamp(System.currentTimeMillis())});
    }

    @Override
    public int deleteTitle(TitleResult.Title title) {
        return delete(SQL_DELETE_TITLE, new Object[]{title.getId()});
    }

    @Override
    public TitleResult.Title getTitleById(int id) {
        TitleResult.Title title = new TitleResult.Title();
        query(SQL_QUERY_TITLE, new Object[]{id}, resultSet -> {
            title.setId(String.valueOf(id));
            title.setName(resultSet.getString(1));
        });
        return title;
    }

    @Override
    public int updateTitle(TitleResult.Title title) {
        return update(SQL_UPDATE_TITLE, new Object[]{title.getName(), new Timestamp(System.currentTimeMillis()),
                Integer.parseInt(title.getId())});
    }

    @Override
    public List<TitleResult.Title> listTitle() {
        List<TitleResult.Title> list = new ArrayList<>();
        query(SQL_QUERY_ALL_TITLE, null, resultSet -> {
            TitleResult.Title t = new TitleResult.Title();
            t.setId(String.valueOf(resultSet.getInt(1)));
            t.setName(String.valueOf(resultSet.getString(2)));
            list.add(t);
        });
        return list;
    }
}
