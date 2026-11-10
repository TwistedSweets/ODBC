package DAO;

import config.DBCon;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void crearUsuario(Usuario usuario) throws SQLException {
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "INSERT INTO usuarios (name, email, edad) VALUES (?, ?, ?)"
                );
        preparedStatement.setString(1, usuario.getName());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setInt(3, usuario.getEdad());

        int filas = preparedStatement.executeUpdate();

        System.out.println("Registro creado: " + filas);
        preparedStatement.close();
    }

    public Usuario buscarUsuario(String email) throws SQLException {
        Connection connection = DBCon.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM usuarios WHERE email = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        boolean encontrado = resultSet.next();

        if (encontrado) {
            Usuario usuario = new Usuario(
                    resultSet.getInt("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("edad")
            );

            return usuario;
        }

        resultSet.close();
        preparedStatement.close();

        return null;
    }

    public void actualizarUsuario(Usuario usuario, String emailActual) throws SQLException {
        Connection connection  = DBCon.getConnection();

        PreparedStatement preparedStatement =
                connection.prepareStatement(
                        "UPDATE usuarios SET name = ?, email = ?, edad = ? WHERE email = ?"
                );
        preparedStatement.setString(1, usuario.getName());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setInt(3, usuario.getEdad());
        preparedStatement.setString(4, emailActual);

        int filas = preparedStatement.executeUpdate();

        System.out.println("Registro actualizado: " + filas);
        preparedStatement.close();
    }

    public void eliminarUsuario(String email) throws SQLException {
        Connection connection = DBCon.getConnection();

        PreparedStatement preparedStatement =
                connection.prepareStatement("DELETE FROM usuarios WHERE email = ?");
        preparedStatement.setString(1, email);

        int filas = preparedStatement.executeUpdate();

        System.out.println("Registro eliminado: " + filas);
        preparedStatement.close();
    }
}
