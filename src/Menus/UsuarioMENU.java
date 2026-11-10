package Menus;

import ENUMS.MainENUM;
import model.Usuario;
import DAO.UsuarioDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class UsuarioMENU {
    public void usmenu (Scanner scanner) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println(MainENUM.USUARIOS.getTexto() + "\n" + "\n" +
                "1. Crear usuario." + "\n" +
                "2. Actualizar usuario." + "\n" +
                "3. Eliminar usuario." + "\n" +
                "0. Anterior."
        );

        int opcion = scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {
            case 1: {
                System.out.println("Elige el nombre del usuario:");
                String nombre = scanner.nextLine();
                System.out.println("Escribe el email del usuario:");
                String email = scanner.next();
                System.out.println("Escribe la edad del usuario:");
                int edad = scanner.nextInt();

                Usuario usuario = new Usuario(nombre, email, edad);

                usuarioDAO.crearUsuario(usuario);
                break;
            }
            case 2: {
                System.out.println("Introduce el email del usuario:");
                String email = scanner.next();

                if (usuarioDAO.buscarUsuario(email)!= null) {
                    System.out.println("Introduce el nuevo nombre del usuario:");
                    String nombre = scanner.next();
                    System.out.println("Introduce el nuevo email del usuario:");
                    String email2 = scanner.next();
                    System.out.println("Introduce la nueva edad del usuario:");
                    int edad = scanner.nextInt();

                    Usuario usuario = new Usuario(nombre, email2, edad);

                    usuarioDAO.actualizarUsuario(usuario, email);
                }

                break;
            }
            case 3: {
                System.out.println("Introduce el email del usuario:");
                String email = scanner.next();

                if (usuarioDAO.buscarUsuario(email) != null) {
                    usuarioDAO.eliminarUsuario(email);
                }
                break;
            }
            case 0: {
                return;
            }

        }
    }
}
