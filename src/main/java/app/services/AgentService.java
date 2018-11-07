package app.services;

import app.dao.AgentDAO;
import app.entities.Agent;
import app.logics.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentService extends Util implements AgentDAO {
    Connection connection = getConnection();

    @Override
    public void add(Agent agent) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "INSERT INTO agent(agent_id ,name ,founded ,international ,website ,players ) VALUES(? , ? , ? , ? , ? , ? )";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,agent.getAgent_id());
            preparedStatement.setString(2,agent.getName());
            preparedStatement.setDate(3,agent.getFounded());
            preparedStatement.setString(4,agent.getInternational());
            preparedStatement.setString(5,agent.getWebsite());
            preparedStatement.setString(6,agent.getPlayers());


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
    public List<Agent> getALL() throws SQLException {
        List<Agent> agentList = new ArrayList<>();

        String sql = "SELECT agent_id ,name ,founded ,international ,website ,players  FROM agent";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Agent agent = new Agent();
                agent.setAgent_id(resultSet.getLong("agent_id"));
                agent.setName(resultSet.getString("name"));
                agent.setFounded(resultSet.getDate("founded"));
                agent.setInternational(resultSet.getString("international"));
                agent.setWebsite(resultSet.getString("website"));
                agent.setPlayers(resultSet.getString("players"));

                agentList.add(agent);
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

        return agentList;
    }

    @Override
    public Agent getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT agent_id ,name ,founded ,international ,website ,players  FROM agent WHERE agent_id =?";

        Agent agent = new Agent();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,agent.getAgent_id());

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            agent.setAgent_id(resultSet.getLong("agent_id"));
            agent.setName(resultSet.getString("name"));
            agent.setFounded(resultSet.getDate("founded"));
            agent.setInternational(resultSet.getString("international"));
            agent.setWebsite(resultSet.getString("website"));
            agent.setPlayers(resultSet.getString("players"));

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

        return agent;
    }

    @Override
    public void update(Agent agent) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "UPDATE agent SET agent_id =?,name=? ,founded=? ,international=? ,website=? ,players=? WHERE agent_id ==?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,agent.getAgent_id());
            preparedStatement.setString(2,agent.getName());
            preparedStatement.setDate(3,agent.getFounded());
            preparedStatement.setString(4,agent.getInternational());
            preparedStatement.setString(5,agent.getWebsite());
            preparedStatement.setString(6,agent.getPlayers());

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
    public void remove(Agent agent) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "DELETE FROM agent WHERE agent_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,agent.getAgent_id());

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

