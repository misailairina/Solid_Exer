package ro.ase.acs.classes;

import ro.ase.acs.interfaces.InserareInterfata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable implements InserareInterfata {
    @Override
    public void insertData(Connection connection) throws SQLException {
        String sqlInsert = "INSERT INTO employees VALUES(1, 'Misaila Irina', 'Galati', 6000)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlInsert);
        statement.close();

        String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";
        PreparedStatement preparedStatement =
                connection.prepareStatement(sqlInsertWithParams);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Popescu Liviu");
        preparedStatement.setString(3, "Constanta");
        preparedStatement.setDouble(4, 2800);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
    }
}
