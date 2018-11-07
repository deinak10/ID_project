package app.services;

import app.dao.Transfer_infoDAO;
import app.entities.Transfer_info;
import app.logics.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Transfer_infoService extends Util implements Transfer_infoDAO {
    Connection connection = getConnection();

    @Override
    public void add(Transfer_info transfer_info) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "INSERT INTO transfer_info(transfer_info_id ,lefted ,joined ,transfer_date , market_value ,scout_name) VALUES(? , ? , ? , ? , ? , ? )";


        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,transfer_info.getTransfer_info_id());
            preparedStatement.setString(2,transfer_info.getLefted());
            preparedStatement.setString(3,transfer_info.getJoined());
            preparedStatement.setDate(4,transfer_info.getTransfer_date());
            preparedStatement.setInt(5,transfer_info.getMarket_value());
            preparedStatement.setString(6,transfer_info.getScout_name());

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
    public List<Transfer_info> getALL() throws SQLException {
        List<Transfer_info> transfer_infoList = new ArrayList<>();

        String sql = "SELECT transfer_info_id ,lefted ,joined ,transfer_date , market_value ,scout_name FROM transfer_info";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Transfer_info transfer_info = new Transfer_info();
                transfer_info.setTransfer_info_id(resultSet.getLong("transfer_info_id"));
                transfer_info.setLefted(resultSet.getString("lefted"));
                transfer_info.setJoined(resultSet.getString("joined"));
                transfer_info.setTransfer_date(resultSet.getDate("transfer_date"));
                transfer_info.setMarket_value(resultSet.getInt("market_value"));
                transfer_info.setScout_name(resultSet.getString("scout_name"));

                transfer_infoList.add(transfer_info);
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
        return transfer_infoList;
    }

    @Override
    public Transfer_info getById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT transfer_info_id ,lefted ,joined ,transfer_date , market_value ,scout_name FROM transfer_info WHERE transfer_info_id =?";

        Transfer_info transfer_info = new Transfer_info();
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,transfer_info.getTransfer_info_id());

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            transfer_info.setTransfer_info_id(resultSet.getLong("transfer_info_id"));
            transfer_info.setLefted(resultSet.getString("lefted"));
            transfer_info.setJoined(resultSet.getString("joined"));
            transfer_info.setTransfer_date(resultSet.getDate("transfer_date"));
            transfer_info.setMarket_value(resultSet.getInt("market_value"));
            transfer_info.setScout_name(resultSet.getString("scout_name"));

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

        return transfer_info;
    }

    @Override
    public void update(Transfer_info transfer_info) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "INSERT INTO transfer_info SET transfer_info_id =?,lefted ,joined =?,transfer_date =?, market_value =?,scout_name=? WHERE transfer_info_id";


        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,transfer_info.getTransfer_info_id());
            preparedStatement.setString(2,transfer_info.getLefted());
            preparedStatement.setString(3,transfer_info.getJoined());
            preparedStatement.setDate(4,transfer_info.getTransfer_date());
            preparedStatement.setInt(5,transfer_info.getMarket_value());
            preparedStatement.setString(6,transfer_info.getScout_name());

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
    public void remove(Transfer_info transfer_info) throws SQLException {
        PreparedStatement preparedStatement =  null;

        String sql = "DELETE FROM transfer_info WHERE transfer_info_id =?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,transfer_info.getTransfer_info_id());

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

