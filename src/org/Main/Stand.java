package org.Main;
import javax.management.modelmbean.ModelMBeanConstructorInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stand {
    String NombreStand;
    List<Moves> MovimientosStand;

    public Stand(String NombreStand, List<Moves> movimientos) {
        this.NombreStand = NombreStand;
        this.MovimientosStand = movimientos;
    }
    public static Stand crearStandF(){
        String nombre = "Moody Reds";
        List<Moves> movimientos = new ArrayList<>();
        movimientos.add(new CalzioS());
        return new Stand(nombre, movimientos);
    }
    public static Stand crearStandA(){
        String nombre = "Surfer's Highway";
        List<Moves> movimientos = new ArrayList<>();
        movimientos.add(new LacrimS());
        return new Stand(nombre, movimientos);
    }

    public static Stand crearStandP(){
        String nombre = "Oogie's Way";
        List<Moves> movimientos = new ArrayList<>();
        movimientos.add(new FloraS());
        return new Stand(nombre, movimientos);
    }

    abstract static class Moves {
        String nombre;
        int damage;


        public Moves(String nombre, int damage) {
            this.nombre = nombre;
            this.damage = damage;
        }

        public abstract void ejecutar(Jugador oponente);

    }

     static class LacrimS extends Moves {
        public LacrimS() {
            super("Lacrim / Agua", 30);
        }

        public void ejecutar(Jugador oponente) {
            Random rand = new Random();
            int probabilidadAcertar = rand.nextInt(110);
            if (probabilidadAcertar > 30) { // 80% de probabilidad de acertar
                int damageRealizado = damage - oponente.resistencia;
                if (damageRealizado > 0) {
                    oponente.salud -= damageRealizado;
                    System.out.println("¡" + oponente.nombre + " fue dañado por " + nombre + " y le hizo " + damageRealizado + " PTS.");
                } else {
                    System.out.println("¡" + oponente.nombre + " bloqueó " + nombre + "!");
                }
            } else {
                System.out.println(nombre + " falló. ¡" + oponente.nombre + " esquivó el ataque!");
            }
        }
    }

    static class CalzioS extends Moves {
        public CalzioS() {
            super("Calzio / Fuego", 30);
        }

        public void ejecutar(Jugador oponente) {
            Random rand = new Random();
            int probabilidadAcertar = rand.nextInt(110);
            if (probabilidadAcertar > 30) { // 80% de probabilidad de acertar
                int damageRealizado = damage - oponente.resistencia;
                if (damageRealizado > 0) {
                    oponente.salud -= damageRealizado;
                    System.out.println("¡" + oponente.nombre + " fue dañado por " + nombre + " y le hizo " + damageRealizado + " PTS.");
                } else {
                    System.out.println("¡" + oponente.nombre + " bloqueó " + nombre + "!");
                }
            } else {
                System.out.println(nombre + " falló. ¡" + oponente.nombre + " esquivó el ataque!");
            }
        }
    }
    static class FloraS extends Moves {
        public FloraS() {
            super("Calzio / Fuego", 30);
        }

        public void ejecutar(Jugador oponente) {
            Random rand = new Random();
            int probabilidadAcertar = rand.nextInt(110);
            if (probabilidadAcertar > 30) { // 80% de probabilidad de acertar
                int damageRealizado = damage - oponente.resistencia;
                if (damageRealizado > 0) {
                    oponente.salud -= damageRealizado;
                    System.out.println("¡" + oponente.nombre + " fue dañado por " + nombre + " y le hizo " + damageRealizado + " PTS.");
                } else {
                    System.out.println("¡" + oponente.nombre + " bloqueó " + nombre + "!");
                }
            } else {
                System.out.println(nombre + " falló. ¡" + oponente.nombre + " esquivó el ataque!");
            }
        }
    }
}


