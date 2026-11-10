package DAO;

import config.DBCon;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public void crearOrder(Order order) throws SQLException{
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO order (user_id, city, order_total, order_date) VALUES (?, ?, ?, ?)"
        );
        preparedStatement.setInt(1, order.getUser_id());
        preparedStatement.setString(2, order.getCity());
        preparedStatement.setBigDecimal(3, order.getOrder_total());
        preparedStatement.setDate(4, Date.valueOf(order.getDate()));

        int filas = preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public List<Order> buscarOrder(int user_id) throws SQLException {
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM orders WHERE user_id = ?"
        );
        preparedStatement.setInt(1, user_id);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Order> orders = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order(
              resultSet.getInt("order_id"),
              resultSet.getInt("user_id"),
              resultSet.getString("city"),
              resultSet.getBigDecimal("order_total"),
                    resultSet.getDate("order_date").toLocalDate()
            );

            orders.add(order);
        }

        preparedStatement.close();
        resultSet.close();

        return orders;
    }

    public void actualizarOrder(Order order) throws SQLException {
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE orders SET order_total = ? WHERE order_id = ?"
        );
        preparedStatement.setBigDecimal(1, order.getOrder_total());
        preparedStatement.setInt(2, order.getOrder_id());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public void elininarOrder(Order order) throws SQLException {
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM orders WHERE order_id = ?"
        );
        preparedStatement.setInt(1, order.getOrder_id());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}
