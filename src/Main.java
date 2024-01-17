
import java.util.Scanner;


    public class Main {

        public static void main(String[] args) {

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("¡Bienvenido a Bizzquest (DEMO)!");


                System.out.print("Ingrese el nombre del Jugador 1: ");
                String nombreJugador1 = scanner.nextLine();
                Jugador jugador1 = new Jugador(nombreJugador1, 100, 10);


                System.out.print("Ingrese el nombre del Jugador 2: ");
                String nombreJugador2 = scanner.nextLine();
                Jugador jugador2 = new Jugador(nombreJugador2, 100, 8);


                System.out.println("\nComienza la batalla:");


                while (jugador1.estaVivo() && jugador2.estaVivo()) {
                    System.out.println("\nEstado de los jugadores:");
                    System.out.println(jugador1.nombre + ": Salud=" + jugador1.salud);
                    System.out.println(jugador2.nombre + ": Salud=" + jugador2.salud);


                    System.out.println("\nTurno de " + jugador1.nombre);
                    jugador1.mostrarMovimientos();
                    System.out.print("Seleccione un movimiento (1-" + jugador1.movimientos.size() + "): ");
                    int movimientoSeleccionado1 = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    jugador1.ejecutarMovimiento(movimientoSeleccionado1, jugador2);


                    if (!jugador2.estaVivo()) {
                        System.out.println(jugador2.nombre + " ha sido derrotado. ¡" + jugador1.nombre + " es el ganador!");
                        break;
                    }


                    System.out.println("\nTurno de " + jugador2.nombre);
                    jugador2.mostrarMovimientos();
                    System.out.print("Seleccione un movimiento (1-" + jugador2.movimientos.size() + "): ");
                    int movimientoSeleccionado2 = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    jugador2.ejecutarMovimiento(movimientoSeleccionado2, jugador1);


                    if (!jugador1.estaVivo()) {
                        System.out.println(jugador1.nombre + " ha sido derrotado. ¡" + jugador2.nombre + " es el ganador!");
                        break;
                    }
                }
            }
        }
    }
