package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {

    @Override
    public City findById(int id) {
        try {
            Connection connection = MySQLConnection.mysqlGetConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM city WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return new City(); // No match found
    }

    @Override
    public List<City> findByCode(String code) {
        List<City> result = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.mysqlGetConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM city WHERE countrycode = ?");
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) { // Found match
                result.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<City> findByName(String name) {
        List<City> result = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.mysqlGetConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM city WHERE name LIKE ?");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) { // Found match
                result.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<City> findAll() {
        List<City> result = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.mysqlGetConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM city");

            while (resultSet.next()) {
                result.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public City add(City city) {
        try {
            Connection connection = MySQLConnection.mysqlGetConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into city VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(2, city.getName());
            preparedStatement.setString(3, city.getCountryCode());
            preparedStatement.setString(4, city.getDistrict());
            preparedStatement.setInt(5, city.getPopulation());
            preparedStatement.executeUpdate();
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public int delete(City city) {
        int result = 0;
        try {
            Connection connection = MySQLConnection.mysqlGetConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM city WHERE id = ?");


        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }

        return result;
    }

}
