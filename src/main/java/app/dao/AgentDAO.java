package app.dao;

import app.entities.Agent;

import java.sql.SQLException;
import java.util.List;

public interface AgentDAO {
    //create
    void add(Agent agent) throws SQLException;

    //read
    List<Agent> getALL() throws SQLException;
    Agent getById(long id) throws SQLException;

    //update
    void update(Agent agent) throws SQLException;

    //delete
    void remove(Agent agent) throws SQLException;
}

