package sa.homework.jdbc.others;

import java.sql.ResultSet;

public interface ICrud {
    void readData(final String tableName);
    void update(final String tableName, final String columnName, final int id, final Object value);
    void delete(final String tableName, final int id);
    void create(final String tableName, final String content);
}
