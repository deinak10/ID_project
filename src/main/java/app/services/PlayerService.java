package app.services;

import app.dao.PlayerDAO;
import app.entities.Player;
import app.logics.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerService extends Util implements PlayerDAO{

    Connection connection = getConnection();

    @Override
    public void add(Player player) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "INSERT INTO player(player_id, first_name, last_name, age, international, club, position, player_cost, agent, contract_term) VALUES(? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,player.getPlayer_id());
            preparedStatement.setString(2,player.getFirst_name());
            preparedStatement.setString(3,player.getLast_name());
            preparedStatement.setInt(4,player.getAge());
            preparedStatement.setString(5,player.getInternational());
            preparedStatement.setString(6,player.getClub());
            preparedStatement.setString(7,player.getPosition());
            preparedStatement.setInt(8,player.getPlayer_cost());
            preparedStatement.setString(9,player.getAgent());
            preparedStatement.setDate(10,player.getContract_term());

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
    public List<Player> getALL() throws SQLException {
        List<Player> playerList = new ArrayList<>();

        String sql = "SELECT player_id, first_name, last_name, age, international, club, position, player_cost, agent, contract_term FROM player";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Player player = new Player();
                player.setPlayer_id(resultSet.getLong("player_id"));
                player.setFirst_name(resultSet.getString("first_name"));
                player.setLast_name(resultSet.getString("last_name"));
                player.setAge(resultSet.getInt("age"));
                player.setInternational(resultSet.getString("international"));
                player.setClub(resultSet.getString("club"));
                player.setPosition(resultSet.getString("position"));
                player.setPlayer_cost(resultSet.getInt("player_cost"));
                player.setAgent(resultSet.getString("agent"));
                player.setContract_term(resultSet.getDate("contract term"));

                playerList.add(player);
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


        return playerList;
    }

    @Override
    public Player getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT player_id, first_name, last_name, age, international, club, position, player_cost, agent, contract_term FROM player WHERE player_id =?";

        Player player = new Player();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,player.getPlayer_id());

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            player.setPlayer_id(resultSet.getLong("player_id"));
            player.setFirst_name(resultSet.getString("first_name"));
            player.setLast_name(resultSet.getString("last_name"));
            player.setAge(resultSet.getInt("age"));
            player.setInternational(resultSet.getString("international"));
            player.setClub(resultSet.getString("club"));
            player.setPosition(resultSet.getString("position"));
            player.setPlayer_cost(resultSet.getInt("player_cost"));
            player.setAgent(resultSet.getString("agent"));
            player.setContract_term(resultSet.getDate("contract term"));

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

        return player;
    }

    @Override
    public void update(Player player) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "UPDATE player SET player_id =?, first_name =?, last_name =?, age =?, international =?, club =?, position =?, player_cost =?, agent =?, contract_term =? WHERE player_id =?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,player.getPlayer_id());
            preparedStatement.setString(2,player.getFirst_name());
            preparedStatement.setString(3,player.getLast_name());
            preparedStatement.setInt(4,player.getAge());
            preparedStatement.setString(5,player.getInternational());
            preparedStatement.setString(6,player.getClub());
            preparedStatement.setString(7,player.getPosition());
            preparedStatement.setInt(8,player.getPlayer_cost());
            preparedStatement.setString(9,player.getAgent());
            preparedStatement.setDate(10,player.getContract_term());

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
    public void remove(Player player) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "DELETE FROM player WHERE player_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,player.getPlayer_id());

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

