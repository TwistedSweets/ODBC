package DAO;

import config.DBCon;
import model.ProductDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailsDAO {
    public void crearProductDetails(ProductDetails productDetails) throws SQLException {
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO product_details (product_id, product_name) VALUES (?, ?)"
        );
        preparedStatement.setInt(1, productDetails.getProduct_id());
        preparedStatement.setString(2, productDetails.getProduct_name());

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public ProductDetails getProductDetails(int product_id) throws SQLException{
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM product_details WHERE product_id = ?"
        );
        preparedStatement.setInt(1,  product_id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            ProductDetails productDetails = new ProductDetails(
                    resultSet.getInt("product_id"),
                    resultSet.getString("product_name")
            );
            return productDetails;
        }

        resultSet.close();
        preparedStatement.close();

        return null;
    }
}
