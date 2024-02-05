package org.Main;
import java.util.ArrayList;
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