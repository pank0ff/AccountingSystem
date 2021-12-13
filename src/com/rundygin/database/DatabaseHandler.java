package database;

import model.Flat;
import model.House;
import services.HouseService;

import java.sql.*;


public class DatabaseHandler extends Configs {

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

    public void WriteHouse(House house) {

        String insert = "INSERT INTO" + Const.HOUSE_TABLE + "(" + Const.HOUSE_NUMBER + "," + Const.HOUSE_FLOORS + "," + Const.HOUSE_FLATS + ")" + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insert);
            prSt.setInt(1, house.getNumber());
            prSt.setInt(2, house.getFloorCount());
            prSt.setInt(3, house.getFlatCount());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void WriteFlat(Flat flat) {

        String insert = "INSERT INTO" + Const.FLAT_TABLE + "(" + Const.FLAT_NUMBER + "," + Const.FLAT_FLOOR + "," + Const.FLAT_ROOMS + "," + Const.FLAT_RESIDENTS + "," + Const.FLAT_SQUARE + "VALUES(?,?,?,?,?)";
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

    public void dataRetrieval() {
        String selectTableSQL = "SELECT * from district";
        try {
            dbConnection = getDBConnection();
            Statement statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String houseID = rs.getString("id");
                String houseNumber = rs.getString("house_number");
                String flatCount = rs.getString("flat_count");
                String floorCount = rs.getString("floor_count");

                System.out.println("house ID : " + houseID);
                System.out.println("house number : " + houseNumber);
                System.out.println("flat count : " + flatCount);
                System.out.println("floor count : " + floorCount);

            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
