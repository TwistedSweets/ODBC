package DAO;

import config.DBCon;
import model.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDAO {
    public void crearOrderDetails(OrderDetails orderDetails) throws SQLException{
        Connection connection = DBCon.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO order_details (order_id, product_id, quantity) VALUES (?, ?, ?)"
        );
        preparedStatement.setInt(1, orderDetails.getOrder_id());
        preparedStatement.setInt(2, orderDetails.getProduct_id());
        preparedStatement.setInt(3, orderDetails.getQuantity());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public List<OrderDetails> getOrderDetails(int order_id) throws SQLException{
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM order_details WHERE order_id = ?");
        preparedStatement.setInt(1, order_id);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<OrderDetails> orderDetails = new ArrayList<>();

        while(resultSet.next()){
            OrderDetails orderDetails1 = new OrderDetails(
                    resultSet.getInt("order_id"),
                    resultSet.getInt("product_id"),
                    resultSet.getInt("quantity")
            );

            orderDetails.add(orderDetails1);
        }

        resultSet.close(); //SIEMPRE CERRAR PRIMERO ESTE ANTES DEL PREPAREDSTAMENT, porque el resultset depende del stament, es logico ¿no?
        preparedStatement.close();

        return orderDetails;
    }

    public void actualizarOrderDetails(OrderDetails orderDetails) throws SQLException{
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE order_details SET quantity = ? WHERE product_id = ? AND order_id = ?"
        );
        preparedStatement.setInt(1, orderDetails.getQuantity());
        preparedStatement.setInt(2, orderDetails.getProduct_id());
        preparedStatement.setInt(3, orderDetails.getOrder_id());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public void eliminarOrderDetails(OrderDetails orderDetails) throws SQLException{
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM order_details WHERE product_id = ? AND order_id = ?"
        );
        preparedStatement.setInt(1, orderDetails.getProduct_id());
        preparedStatement.setInt(2, orderDetails.getOrder_id());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }
}
