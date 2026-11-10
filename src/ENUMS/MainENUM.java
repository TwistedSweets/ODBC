package ENUMS;

import java.sql.SQLException;
import java.util.Scanner;

public enum MainENUM {
    USUARIOS(1, "=== MENU USUARIOS ==="){
        @Override
        public void ejecutar(Scanner scanner) {
            Menus.UsuarioMENU menu = new Menus.UsuarioMENU();
            try {
                menu.usmenu(scanner);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    },
    PRODUCTOS(2, "=== MENU PRODUCTOS ==="){
        @Override
        public void ejecutar(Scanner scannerm) {
            Menus.ProductosMENU menu = new Menus.ProductosMENU();
        }
    },
    ORDENES(3, "=== MENU ORDENES ==="){
        @Override
        public void ejecutar(Scanner scanner) {
            Menus.OrdenesMENU menu = new Menus.OrdenesMENU();
        }
    },
    DETALLOR(4, "=== MENU DETALLES DE ORDENES ==="){
        @Override public void ejecutar(Scanner scanner) {
            Menus.DetallOrMENU menu = new Menus.DetallOrMENU();
        }
    },
    SALIR(0, "=== SALIR ==="){
        @Override public void ejecutar(Scanner scanner) {
            System.exit(0);
        }
    };

    //Constructor
    private final int opcion;
    private final String texto;

    MainENUM(int opcion, String texto) {
        this.opcion = opcion;
        this.texto = texto;
    }

    //getter
    public int getOpcion(){return opcion;}
    public String getTexto(){return texto;}

    public static MainENUM fromOpcion (int opcion){
        return switch (opcion) {
            case 1 -> USUARIOS;
            case 2 -> PRODUCTOS;
            case 3 -> ORDENES;
            case 4 -> DETALLOR;
            case 0 -> SALIR;
            default -> throw new IllegalArgumentException("Opción invalida.");
        };
    }

    public abstract void ejecutar(Scanner scanner);
}
