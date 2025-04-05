
package exp2_s4_benjamin_ignacio_ruiz_miranda;

import java.util.Scanner;
 
/**
 *
 * @author Darklight
 */
public class Exp2_S4_Benjamin_Ignacio_Ruiz_Miranda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Inicializamos variables 
        int precioTotal = 0;
        int precioZonaElegida = 0;
        String letraZona = "";

        // Precios de las zonas
        int precioA = 12500;
        int precioB = 11000;
        int precioC = 6500;
        
        Scanner sc = new Scanner(System.in);
        
        // menuP funciona como verificador de la opcion que vaya a seleccionar el usuario
        // menuP == 1 -> Comprar entradas
        // menuP == 2 -> Salir del programa
        int menuP;

        System.out.println("Bienvenido al sistema de compra de entradas de el Teatro Moro");

        // Ciclo inicial para el menu de opciones
        do {
            System.out.println("Escriba un numero segun la opcion que desea realizar");
            System.out.println("1.- Comprar Entradas");
            System.out.println("2.- Salir");
            menuP = sc.nextInt();
            
            // menuP == 1 -> Ingreso al sistema de compra de entradas
            if (menuP == 1) {
                System.out.println("Seleccione la ubicacion del asiento");
                System.out.println("Zonas disponibles: A, B ,C");
                System.out.println("-Ingrese un numero segun la zona que desea comprar-");
                System.out.println("1.- Zona A" + " (Precio: " + precioA + ")");
                System.out.println("2.- Zona B" + " (Precio: " + precioB + ")");
                System.out.println("3.- Zona C" + " (Precio: " + precioC + ")");
                
                int asiento = sc.nextInt();
                boolean checkAsiento = false;

                // do-while que verifica que salga un checkAsiento == true en uno de los casos
                do {
                    // Switch de los actuales posibles asientos (3 zonas)
                    switch (asiento) {
                        case 1:
                            System.out.println("Has seleccionado la Zona A" + " (Precio: " + precioA + ")");
                            precioZonaElegida = precioA;
                            letraZona = "A";
                            checkAsiento = true;
                            break;
                        case 2:
                            System.out.println("Has seleccionado la Zona B" + " (Precio: " + precioB + ")");
                            precioZonaElegida = precioB;
                            letraZona = "B";
                            checkAsiento = true;
                            break;
                        case 3:
                            System.out.println("Has seleccionado la Zona C" + " (Precio: " + precioC + ")");
                            precioZonaElegida = precioC;
                            letraZona = "C";
                            checkAsiento = true;
                            break;
                        default: // No se cambia el valor de checkAsiento, por lo que se repite el ciclo
                            System.out.println("Esa entrada no es valida, vuelva a intentarlo");
                            break;
                    }
                } while (!checkAsiento);

                System.out.println("A continuacion, ingrese la edad del reservante del asiento");
                int edad;
                double descuento = 0;

                // ciclo do-while que alberga un if que verifica la edad del usuario para aplicar el descuento correspondiente
                // el while se encarga de verificar que la edad sea una respuesta valida
                do {
                    edad = sc.nextInt();
                    if (edad <=17) {
                        descuento = 0.10; // Representa un 10% de descuento para "Estudiantes" (un poco ambiguo en las instrucciones originales)
                    } else if (edad == 18) {
                        descuento = 0; // Sin descuento para adultos
                    } else if (edad >= 65) {
                        descuento = 0.15; // Representa un 15% de descuento para "Adultos mayores"
                    } else {
                        System.out.println("Edad no valida, intentelo de nuevo");
                    }
                } while (edad < 0 || edad > 122); // Asumimos que la edad no puede ser negativa o mayor a 122 años... 

                boolean calculohecho = false;

                // Ciclo do-while que puede ser innecesario, pero aparecia en las instrucciones originales...
                // de todas formas, se encarga de aplicar el descuento al precio total y mostrar el resumen de la transaccion individual
                do {
                    precioTotal = (int)(precioTotal + (precioZonaElegida - (precioZonaElegida * descuento)));
                    calculohecho = true;
                    System.out.println("--- RESUMEN DE ESTA TRANSACCION ---");
                    System.out.println("Ubicacion del asiento: ZONA " + letraZona);
                    System.out.println("PRECIO BASE DE ESTA ZONA: " + precioZonaElegida);
                    System.out.println("PORCENTAJE DE DESCUENTO APLICADO: " + (descuento * 100) + "%");
                    System.out.printf("PRECIO DE ESTA ZONA DESPUES DEL DESCUENTO: %.0f\n\n", (precioZonaElegida - (precioZonaElegida * descuento)));
                } while (!calculohecho);

                System.out.println("EN TOTAL, TIENE QUE PAGAR: " + precioTotal + "\n");

            // menuP == 2 -> Salida del programa, se verifica si hay algun valor en precioTotal para mostrar un mensaje diferente
            } else if (menuP == 2 && precioTotal > 0) {
                System.out.println("Gracias por comprar con nosotros, vuelva pronto!");
            } else if (menuP == 2 && precioTotal == 0) {
                System.out.println("No ha comprado entradas, esperamos que vuelva pronto!");
            // si no es ni 1 ni 2, entonces se le pide al usuario que vuelva a intentarlo
            } else {
                System.out.println("Opcion no valida, vuelva a intentarlo"); 
            } 
        } while (menuP != 2); 
            sc.close();
    }
}   
