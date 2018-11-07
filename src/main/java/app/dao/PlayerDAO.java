package app.dao;

import app.entities.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {
    //create
    void add(Player player) throws SQLException;

    //read
    List<Player> getALL() throws SQLException;
    Player getById(long id) throws SQLException;

    //update
    void update(Player player) throws SQLException;

    //delete
    void remove(Player player) throws SQLException;
}
