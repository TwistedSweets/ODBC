import DAO.*;
import model.*;
import ENUMS.MainENUM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("=== MENU PRINCIPAL ===" + "\n" + "\n" +
                    "1. Usuarios." + "\n" +
                    "2. Productos." + "\n" +
                    "3. Órdenes." + "\n" +
                    "4. Detalles de órdenes" + "\n" +
                    "0. Salir."
            );

            int opcion = scanner.nextInt();

            scanner.nextLine();

            try {
                MainENUM mainENUM = MainENUM.fromOpcion(opcion);
                mainENUM.ejecutar(scanner);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
