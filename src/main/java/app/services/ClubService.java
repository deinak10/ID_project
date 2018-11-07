package app.services;



import app.dao.ClubDAO;
import app.entities.Club;
import app.logics.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClubService extends Util implements ClubDAO {

    Connection connection = getConnection();

    @Override
    public void add(Club club) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "INSERT INTO club(club_id ,name ,location ,league ,foundation_year ,stadium ,number_titles ,club_cost_bil) VALUES(? , ? , ? , ? , ? , ? , ? , ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,club.getClub_id());
            preparedStatement.setString(2,club.getName());
            preparedStatement.setString(3,club.getLocation());
            preparedStatement.setString(4,club.getLeague());
            preparedStatement.setDate(5,club.getFoundation_year());
            preparedStatement.setString(6,club.getStadium());
            preparedStatement.setInt(7,club.getNumber_titles());
            preparedStatement.setDouble(8,club.getClub_cost_bil());

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
    public List<Club> getALL() throws SQLException {
        List<Club> clubList = new ArrayList<>();

        String sql = "SELECT club_id ,name ,location ,league ,foundation_year ,stadium ,number_titles ,club_cost_bil FROM club";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Club club = new Club();
                club.setClub_id(resultSet.getLong("club_id"));
                club.setName(resultSet.getString("name"));
                club.setLocation(resultSet.getString("location"));
                club.setLeague(resultSet.getString("league"));
                club.setFoundation_year(resultSet.getDate("foundation_year"));
                club.setStadium(resultSet.getString("stadium"));
                club.setNumber_titles(resultSet.getInt("number_titles"));
                club.setClub_cost_bil(resultSet.getDouble("club_cost_bil"));

                clubList.add(club);
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

        return clubList;
    }

    @Override
    public Club getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT club_id ,name ,location ,league ,foundation_year ,stadium ,number_titles ,club_cost_bil FROM club Where club_id = ?";

        Club club = new Club();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,club.getClub_id());

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            club.setClub_id(resultSet.getLong("club_id"));
            club.setName(resultSet.getString("name"));
            club.setLocation(resultSet.getString("location"));
            club.setLeague(resultSet.getString("league"));
            club.setFoundation_year(resultSet.getDate("foundation_year"));
            club.setStadium(resultSet.getString("stadium"));
            club.setNumber_titles(resultSet.getInt("number_titles"));
            club.setClub_cost_bil(resultSet.getDouble("club_cost_bil"));

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

        return club;
    }

    @Override
    public void update(Club club) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "UPDATE club SET club_id =? ,name =?,location =?,league =?,foundation_year=? ,stadium =?,number_titles =?,club_cost_bil =? WHERE club_id =?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,club.getClub_id());
            preparedStatement.setString(2,club.getName());
            preparedStatement.setString(3,club.getLocation());
            preparedStatement.setString(4,club.getLeague());
            preparedStatement.setDate(5,club.getFoundation_year());
            preparedStatement.setString(6,club.getStadium());
            preparedStatement.setInt(7,club.getNumber_titles());
            preparedStatement.setDouble(8,club.getClub_cost_bil());

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
    public void remove(Club club) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "DELETE FROM club WHERE club_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,club.getClub_id());

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

