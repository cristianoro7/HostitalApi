package desperado.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by desperado on 18-1-12.
 */

public abstract class AbstractDao {

    private static final String DS_URL = "java:/comp/env/db/homework";

    protected static DataSource dataSource;

    static {
        initDataSource();
    }

    private static void initDataSource() {
        try {
            dataSource = getDataSource(DS_URL);
        } catch (NamingException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static DataSource getDataSource(String url) throws NamingException {
        Context context = new InitialContext();
        return (DataSource) context.lookup(url);
    }


    public int update(String sql, Object[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        int c = -1;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            setArgs(statement, args);
            c = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement, connection);
        }
        return c;
    }

    public int[] updateBatch(String sql, List<Object[]> args) {
        Connection connection = null;
        PreparedStatement statement = null;
        int[] c;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            setBatchArgs(statement, args);
            c = statement.executeBatch();

            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement, connection);
        }
        return new int[0];
    }

    private void setBatchArgs(PreparedStatement statement, List<Object[]> args) throws SQLException {
        for (int i = 0; i < args.size(); i++) {
            Object[] objects = args.get(i);
            for (int j = 0; j < objects.length; j++) {
                statement.setObject(j + 1, objects[j]);
            }
            statement.addBatch();
        }
    }


    public int insert(String sql, Object[] args) {
        return update(sql, args);
    }

    public int[] insertBatch(String sql, List<Object[]> args) {
        return updateBatch(sql, args);
    }

    public int delete(String sql, Object[] args) {
        return update(sql, args);
    }

    public void query(String sql, Object[] args, RowMapper mapper) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            if (args != null) {
                setArgs(statement, args);
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (mapper != null) {
                    mapper.map(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement, resultSet, connection);
        }
    }

    private void setArgs(PreparedStatement preparedStatement, Object[] args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
    }

    private void close(Statement s, Connection connection) {
        close(s, null, connection);
    }

    private void close(Statement s, ResultSet resultSet, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (s != null) {
                s.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
