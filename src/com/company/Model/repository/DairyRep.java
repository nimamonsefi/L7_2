package com.company.Model.repository;

import com.company.Model.entity.DairyEnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DairyRep implements AutoCloseable{

    private Connection connection;
    private PreparedStatement preparedStatement;

    public DairyRep() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nimamonsfi","myjava123");
        connection.setAutoCommit(false);
    }

    public void insert(DairyEnt dairyEnt) throws Exception{
        preparedStatement = connection.prepareStatement("INSERT INTO dairy(num, name, product, expire) VALUES (?,?,?,?)");
        preparedStatement.setLong(1,dairyEnt.getNum());
        preparedStatement.setString(2,dairyEnt.getName());
        preparedStatement.setString(3,dairyEnt.getProduct());
        preparedStatement.setString(4,dairyEnt.getExpire());
        preparedStatement.executeUpdate();
    }

    public void update(DairyEnt dairyEnt) throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE dairy SET name=?, product=?, expire=?, WHERE num=?");
        preparedStatement.setLong(1,dairyEnt.getNum());
        preparedStatement.setString(2,dairyEnt.getName());
        preparedStatement.setString(3,dairyEnt.getProduct());
        preparedStatement.setString(4,dairyEnt.getExpire());
        preparedStatement.executeUpdate();
    }

    public void delete(long num) throws Exception{
        preparedStatement = connection.prepareStatement("DELETE FROM dairy WHERE num=?");
        preparedStatement.setLong(1,num);
        preparedStatement.executeUpdate();
    }

    public List<DairyEnt> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT * FROM dairy");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<DairyEnt> dairylist = new ArrayList<>();
        while (resultSet.next()){
            DairyEnt dairyEnt = new DairyEnt();
            dairyEnt.setNum(resultSet.getLong("num"));
            dairyEnt.setName(resultSet.getString("name"));
            dairyEnt.setProduct(resultSet.getString("product"));
            dairyEnt.setExpire(resultSet.getString("expire"));
            dairylist.add(dairyEnt);
        }
        return dairylist;
    }

    public void commit() throws Exception{
        connection.commit();
    }

    public void rollback() throws Exception{
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}