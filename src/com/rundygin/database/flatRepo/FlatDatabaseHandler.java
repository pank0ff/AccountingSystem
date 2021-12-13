package database.flatRepo;

import database.Configs;
import model.Flat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FlatDatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager
                    .getConnection(jdbcURL,
                            dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return dbConnection;
    }
    public void WriteFlat(Flat flat) {

        String insert = "INSERT INTO" + FlatConst.FLAT_TABLE + "(" + FlatConst.FLAT_NUMBER + "," + FlatConst.FLAT_FLOOR + "," + FlatConst.FLAT_ROOMS + "," + FlatConst.FLAT_RESIDENTS + "," + FlatConst.FLAT_SQUARE + "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insert);
            prSt.setInt(1, flat.getNumber());
            prSt.setInt(2, flat.getFloor());
            prSt.setInt(3, flat.getCountRooms());
            prSt.setInt(4, flat.getResidents());
            prSt.setInt(5, flat.getSquare());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
