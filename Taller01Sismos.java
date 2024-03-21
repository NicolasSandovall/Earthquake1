import java.util.Scanner;
import java.util.Random;

public class Taller01Sismos {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Double[][] sismos = generarSismos();

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar el mayor sismo registrado.");
            System.out.println("2. Contar la cantidad de sismos mayores o iguales a 5.0.");
            System.out.println("3. Enviar SMS de alerta para sismos mayores o iguales a 7.0.");
            System.out.println("4. Salir.");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    double mayor = mayorSismo(sismos);
                    System.out.println("El mayor sismo registrado es: " + mayor);
                    break;
                case 2:
                    int contador = contarSismos(sismos);
                    System.out.println("La cantidad de sismos mayores o iguales a 5.0 es: " + contador);
                    break;
                case 3:
                    enviarSMS(sismos);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    public static Double[][] generarSismos() {
        Double[][] sismos = new Double[7][24];
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                sismos[i][j] = Math.round(random.nextDouble() * 100) / 10.0;
            }
        }
        return sismos;
    }

    public static double mayorSismo(Double[][] sismos) {
        double mayor = 0;

        for (Double[] fila : sismos) {
            for (Double sismo : fila) {
                if (sismo > mayor) {
                    mayor = sismo;
                }
            }
        }
        return mayor;
    }

    public static int contarSismos(Double[][] sismos) {
        int contador = 0;

        for (Double[] fila : sismos) {
            for (Double sismo : fila) {
                if (sismo >= 5.0) {
                    contador += 1;
                }
            }
        }

        return contador;
    }

    public static void enviarSMS(Double[][] sismos) {
        for (Double[] fila : sismos) {
            for (Double sismo : fila) {
                if (sismo >= 7.0) {
                    System.out.println("Alerta!!! se debe evacuar zona costera!");
                }
            }
        }
    }
}
