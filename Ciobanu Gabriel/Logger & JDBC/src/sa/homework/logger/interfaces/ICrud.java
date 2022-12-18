package sa.homework.logger.interfaces;

import java.sql.ResultSet;

public interface ICrud {
    void readData(String tableName);
    void update(String tableName, String columnName, int id, Object value);
    void delete(String tableName, int id);
    void create(String tableName, String content);
}
