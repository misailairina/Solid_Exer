package ro.ase.acs.main;

import ro.ase.acs.classes.CreateTable;
import ro.ase.acs.classes.InsertTable;
import ro.ase.acs.classes.SelectTable;
import ro.ase.acs.interfaces.CreareInterfata;
import ro.ase.acs.interfaces.InserareInterfata;
import ro.ase.acs.interfaces.SelectareInterfata;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            CreareInterfata createInterface = new CreateTable();
            createInterface.createTable(connection);

            InserareInterfata inserareInterfata = new InsertTable();
            inserareInterfata.insertData(connection);

            SelectareInterfata selectInterface = new SelectTable();
            selectInterface.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
