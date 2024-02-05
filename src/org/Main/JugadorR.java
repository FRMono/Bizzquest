package org.Main;
import moves.Jugador;

import java.util.Random;

public class JugadorR extends Jugador {
    String nombreR;

    int saludR;
    int resistenciaR;

    public JugadorR(String nombreR, int saludR, int resistenciaR) {
        super(new GamePanel(), new KeyHandler(), nombreR, saludR, resistenciaR);
    }

    @Override
    public int elegirMovimiento() {
        Random rand = new Random();
        return rand.nextInt(movimientos.size());
    }
}