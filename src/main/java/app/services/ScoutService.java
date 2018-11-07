package app.services;

import app.dao.ScoutDAO;
import app.entities.Scout;
import app.logics.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoutService extends Util implements ScoutDAO {
    Connection connection = getConnection();

    @Override
    public void add(Scout scout) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "INSERT INTO scout(scout_id ,name ,club ,age ,players ) VALUES(? , ? , ? , ? , ? )";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,scout.getScout_id());
            preparedStatement.setString(2,scout.getName());
            preparedStatement.setString(3,scout.getClub());
            preparedStatement.setInt(4,scout.getAge());
            preparedStatement.setString(5,scout.getPlayers());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public List<Scout> getALL() throws SQLException {
        List<Scout> scoutList = new ArrayList<>();

        String sql = "SELECT scout_id ,name ,club ,age ,players FROM scout";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Scout scout = new Scout();
                scout.setScout_id(resultSet.getLong("scout_id"));
                scout.setName(resultSet.getString("name"));
                scout.setClub(resultSet.getString("club"));
                scout.setAge(resultSet.getInt("age"));
                scout.setPlayers(resultSet.getString("players"));

                scoutList.add(scout);
            }

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return scoutList;
    }

    @Override
    public Scout getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT scout_id ,name ,club ,age ,players FROM scout WHERE scout_id =?";

        Scout scout = new Scout();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,scout.getScout_id());

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            scout.setScout_id(resultSet.getLong("scout_id"));
            scout.setName(resultSet.getString("name"));
            scout.setClub(resultSet.getString("club"));
            scout.setAge(resultSet.getInt("age"));
            scout.setPlayers(resultSet.getString("players"));

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }

        return scout;
    }

    @Override
    public void update(Scout scout) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "UPDATE scout SET scout_id=? ,name=? ,club=? ,age=? ,players=? WHERE scout_id =?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,scout.getScout_id());
            preparedStatement.setString(2,scout.getName());
            preparedStatement.setString(3,scout.getClub());
            preparedStatement.setInt(4,scout.getAge());
            preparedStatement.setString(5,scout.getPlayers());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }

    @Override
    public void remove(Scout scout) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "DELETE FROM scout WHERE scout_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,scout.getScout_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
