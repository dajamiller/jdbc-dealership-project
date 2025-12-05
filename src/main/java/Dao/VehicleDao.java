package Dao;

import com.pluralsight.Vehicle;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class VehicleDao {

    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public getVehiclesByPrice(double min, double max) {

        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setDouble(1, min);
            statement.setDouble(2, max);

//            try (ResultSet results = statement.executeQuery()) {
//
//                while (results.next()) {
//                    // ERROR FIX 2: Use actual DB column names, not display labels
//                    double min = results.getString(saleprice);
//                    double  = results.getString("last_name");
//
//                    Actor actor = new Actor(actorID, dbFirstName, dbLastName);
//                    actors.add(actor);
//                }
//        }
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(mapRowToVehicle(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    private void displayVehicles(List<Vehicle> results) {
    }

//    private void displayVehicles(List<Vehicle> results) {
//    }
}
