package ro.ase.acs.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface InserareInterfata {
    void insertData(Connection connection) throws SQLException;
}
