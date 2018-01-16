package desperado.base;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by desperado on 18-1-12.
 */

public interface RowMapper {
    void map(ResultSet resultSet) throws SQLException;
}
