package moves;

import moves.Movimiento;

import java.util.Random;

class Calzio extends Movimiento {
    public Calzio() {
        super("Calzio / Fuego ", 35);
    }


    @Override
    public void ejecutar(Jugador oponente) {
        Random rand = new Random();
        int probabilidadAcertar = rand.nextInt(90);
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
