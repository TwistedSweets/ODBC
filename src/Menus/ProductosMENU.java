package Menus;

import ENUMS.MainENUM;
import model.ProductDetails;
import DAO.ProductDetailsDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductosMENU {
    public void prmenu (Scanner scanner) throws SQLException{
        ProductDetailsDAO productDetailsDAO = new ProductDetailsDAO();

        System.out.println(MainENUM.PRODUCTOS.getTexto() + "\n" + "\n" +
                "1."
        );
    }
}
