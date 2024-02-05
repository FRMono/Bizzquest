package org.Main;

import java.util.Scanner;
import javax.swing.JFrame;

public class Main {

        public static void main(String[] args) {
                JFrame window = new JFrame();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setResizable(false);
                window.setTitle("Bizzquest");

                GamePanel gamePanel = new GamePanel();
                window.add (gamePanel);

                window.pack();

                window.setLocationRelativeTo(null); // con esto hago que la ventana salga en el centro de la pantalla.
                window.setVisible(true);

                gamePanel.startGameThread();

                PersonajeNPC NPC = new PersonajeNPC("P. Brunio");
                try (Scanner scanner = new Scanner(System.in)) {
                        System.out.println("¡Bienvenido a Bizzquest (DEMO)!");
                        NPC.hablar("Hola Viajero, bienvenido al Underworld, en este mundo hay un poder al que llamámos stands.");
                        ;
                        NPC.hablar("Solo la flecha decidirá si eres lo suficientemente capaz...");
                        NPC.hablar("Antes que nada...¿Cómo te llamas?");

                        System.out.print("Ingresa tu nombre: ");
                        String nombreJugador1 = scanner.nextLine();
                        Jugador jugador1 = new Jugador(new GamePanel(), new KeyHandler(), nombreJugador1, 100, 10);

                        NPC.hablar("Elige la flecha que quieras para saber si estás capacitado...");

                        System.out.println("1 . Flecha Sanguínea (MDY REDS)");
                        System.out.println("2 . Flecha Animal (OOG'S WAY)");
                        System.out.println("3 . Flecha Robot (SRFR'S HIGHWAY)");

                        System.out.println("Elige la flecha :");
                        int opcionFlecha = scanner.nextInt();
                        scanner.nextLine();

                        Stand Stand = null;
                        switch (opcionFlecha) {
                                case 1:
                                        Stand = Stand.crearStandF();
                                        break;
                                case 2:
                                        Stand = Stand.crearStandP();
                                        break;
                                case 3:
                                        Stand = Stand.crearStandA();
                                        break;
                        }
                        System.out.println("*Te atraviesa con la flecha...* ");

                        System.out.println("Sientes emerger una especie de poder magnífico de tu interior..." + "\n(Has conseguido el poder de " + Stand.NombreStand + "!)");

                        System.out.println("*te desmayas.*");
                        System.out.println("Pasa un cuarto de hora");
                        System.out.println(nombreJugador1 + ": " + "*Sientes entrar luz por una ventana...* \n (Decides levantarte)");

                        System.out.println("*Escuchas el sonido que hace el bacon en la sartén a lo lejos. \nDecides acercarte atraído por el aroma que llena la casa");
                        NPC.hablar("Oh, " + nombreJugador1 + " finalmente despiertas... Eso significa que has sido capaz...");
                        System.out.println(nombreJugador1 + " : " + " \n(Es cierto, me siento realmente extraño...)");

                        NPC.hablar("Bueno, " + nombreJugador1 + " ha sido un placer haberte conocido, pero me temo que no tengo nada más que enseñarte." + "\n Espero que te vaya bien y suerte con tu nuevo poder." + " Espero que te llegue un viaje largo y lleno de emociones.");
                        System.out.println(nombreJugador1 + " : " + " Un gusto..." + "\n (Espera un momento... Este hombre nunca me ha dicho su nombre.)" + "Perdonáme pero, ¿cómo te llamas?");
                        NPC.hablar("Ah claro, si no te lo había dicho. " + nombreJugador1 + "\nMe llamo Profesor Brunio, un placer " + nombreJugador1);

                        System.out.println(nombreJugador1 + " : " + " ahora si, un gusto " + NPC.nombre);
                        System.out.println("*Te vas del sitio intrigado y con curiosidad por este nuevo poder...* \n" + nombreJugador1 + " : " + Stand.NombreStand + " que nombre más peculiar.");
                        System.out.println("*Caminas recto durante apróximadamente unos 15 minutos, sin rumbo y dubitativo llegas a una especie de plaza*");

                        System.out.println("*Tienes un mal presentimiento.*");
                        System.out.println("*Ves unos carteles enormes en el centro de la plaza, son 3, cada uno de un color*");
                        System.out.println(nombreJugador1 + " : " + "Rojo, verde y azul, un bosque, un hospital y un coliseo...");

                        System.out.println("¿Qué camino escogerás?");
                        System.out.println("1 . Camino rojizo (Coliseo)");
                        System.out.println("2 . Camino celeste (Hospital)");
                        System.out.println("3 . Camino frondoso (Bosque)");

                        int opcionEscenario = scanner.nextInt();
                        scanner.nextLine();


                        JugadorR jugadorR = null;

                        switch (opcionEscenario) {
                                case 1:
                                        System.out.println("*Decides ir al coliseo, donde los valerosos gladiadores lucharon alguna vez. Esperas no encontrar mucho problema.*");
                                        System.out.println("(Escuchas unas risas a lo lejos, pero no paras de ir hacia tu destino.)");
                                        jugadorR = new JugadorR("Hamm", 100, 8);
                                        System.out.println(jugadorR.nombre + " : " + " YOHOHOHOHOHO! AL FIN UN ENEMIGO, VAMOS A LUCHAR." + "\n(Intentas correr un poco para pensar en que hacer.)" + nombreJugador1 + " : " + "Espera, dame un momento, ¿TÚ QUIÉN ERES?");
                                        System.out.println(jugadorR.nombre + " : " + " MUJAJAJAJJAJJA SOY EL GRAN HAMM, LIDER DE LOS CERDOS OSCUROS DEL UNDERWORLD. AHORA SI VAMOS A LUCHAR.");
                                        break;
                                case 2:
                                        System.out.println("*Decides ir al hospital, donde supuestamente según has escuchado, los últimos pacientes sufrieron tanto que un día dejaron de gritar. Preocupante pero intrigante.*");
                                        System.out.println("(En cuanto más te acercas al hospital, más alto oyes los quejidos.)");
                                        jugadorR = new JugadorR("Vikkas", 120, 7);
                                        System.out.println(jugadorR.nombre + " : " + " Hola corazón, ¿estás enfermo? " + " *dice con una voz seductora*" + "\n (Te fijas en su traje y ves varias manchas de sangre que no es reciente)"
                                                + nombreJugador1 + " : " + " N-No, estoy bien, ¿usted quien es perdón?");
                                        System.out.println(jugadorR.nombre + " : " + " Me llamo Vikkas, soy la jefa aquí. ¿Quieres entrar a tomar algo?" + "\n" + nombreJugador1 + " : " + " No , gracias, por cierto, tienes una mancha encima de la mascarilla.");
                                        System.out.println("*Ves salir una lengua enorme de la mascarilla y chupar lo que parecía una mancha de sangre.*" + "\n" + jugadorR.nombre + " : " + " Que pena, tampoco es que tengas otra opción.... AHORA SERÁS MÍO TÚ TAMBIÉN");
                                        System.out.println("(Se abalanza sobre ti)" + "\n" + "Te da tiempo a esquivarle, pero no tienes de otra. Te preparas para la pelea.");
                                        break;
                                case 3:
                                        System.out.println("*Decides ir al bosque, el camino está lleno de flores preciosas, continúas tu camino hasta que aparece un sujeto enorme en medio del camino, parece que está desmayado.*");
                                        System.out.println(nombreJugador1 + " : " +  " Hola, ¿está bien?" + "\n (No recibes respuesta. Pero el sujeto se levanta, se rasca los ojos y te mira.)");
                                        jugadorR = new JugadorR("Margon", 115, 9);
                                        System.out.println(jugadorR.nombre + " : " + " Ughhhhashdsan" + "(Te mira fijamente)" + " \n" + jugadorR.nombre + " : " + " AHHHHHHHRG " + "(Parece que se enfada y te ataca)" );
                                        System.out.println(nombreJugador1 + " : " + " NO HE ENTENDIDO NADA. ¿QUIÉN ERES?" + "\n" + jugadorR.nombre + " : " + " UGHAAAAAAAGAAAA");
                                        break;
                        }

                        System.out.println("\nComienza la batalla:");


                        while (jugador1.estaVivo() && jugadorR.estaVivo()) {
                                System.out.println("\nEstado de los jugadores:");
                                System.out.println(jugador1.nombre + ": Salud=" + jugador1.salud);
                                System.out.println(jugadorR.nombre + ": Salud=" + jugadorR.salud);


                                System.out.println("\nTurno de " + jugador1.nombre);
                                jugador1.mostrarMovimientos();
                                System.out.print("Seleccione un movimiento (1-" + jugador1.movimientos.size() + "): ");
                                int movimientoSeleccionado1 = scanner.nextInt() - 1;
                                scanner.nextLine(); // Limpiar el buffer de entrada
                                jugador1.ejecutarMovimiento(movimientoSeleccionado1, jugadorR);

                                if (!jugadorR.estaVivo()) {
                                        System.out.println(jugadorR.nombre + " ha sido derrotado. ¡" + jugador1.nombre + " es el ganador!");
                                        break;
                                }

                                System.out.println("\nTurno de " + jugadorR.nombre);
                                int movimientosJugadorR = jugadorR.elegirMovimiento();
                                jugadorR.ejecutarMovimiento(movimientosJugadorR, jugador1);


                                if (!jugador1.estaVivo()) {
                                        System.out.println(jugador1.nombre + " ha sido derrotado. ¡" + jugadorR.nombre + " es el ganador!");
                                        break;
                                }
                        }

                }
        }
}