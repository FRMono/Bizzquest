package org.Main;
import Entity.Entidad;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Jugador extends Entidad {
    GamePanel gp;
    KeyHandler keyH;
    String nombre;
    int salud;
    int resistencia;
    List<Movimiento> movimientos;

    public Jugador (GamePanel gp, KeyHandler keyH, String nombre, int salud, int resistencia) {

        this.nombre = nombre;
        this.salud = salud;
        this.resistencia = resistencia;
        this.movimientos = new ArrayList<>();
        this.keyH = keyH;
        this.gp = gp;
        // Agregar movimientos iniciales
        movimientos.add(new AtaqueBasico());
        movimientos.add(new Calzio());
        movimientos.add(new Lacrim());
        movimientos.add(new Gaia());
        movimientos.add(new Flora());
        setDefaultValues();
        getJugadorImage();
    }


    public void mostrarMovimientos() {
        System.out.println("Movimientos disponibles para " + nombre + ":");
        for (int i = 0; i < movimientos.size(); i++) {
            System.out.println((i + 1) + ". " + movimientos.get(i).nombre);
        }
    }
    public void ejecutarMovimiento(int indice, Jugador oponente) {
        if (indice >= 0 && indice < movimientos.size()) {
            Movimiento movimientoSeleccionado = movimientos.get(indice);
            movimientoSeleccionado.ejecutar(oponente);
        } else {
            System.out.println("Movimiento fallido.");
        }
    }


    public boolean estaVivo() {
        return salud > 0;
    }

    public int elegirMovimiento() {
        return 0;
    }
    public void setDefaultValues(){

        x = 100;
        y = 100;
        jugadorVelocidadE = 3;
        Direccion = "down";
    }
    public void getJugadorImage(){
        try{

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/up1.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/down1.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/left1.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/right1.png")));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2){

        //g2.setColor(Color.white);

        //g2.fillRect(x,y,gp.tileSize, gp.tileSize);

        BufferedImage imagen = switch (Direccion) {
            case "up" -> up1;
            case "down" -> down1;
            case "left" -> left1;
            case "right" -> right1;
            default -> null;
        };

        g2.drawImage(imagen, x, y, gp.tileSize, gp.tileSize, null);
    }
}


abstract class Movimiento {
    String nombre;
    int damage;


    public Movimiento(String nombre, int damage) {
        this.nombre = nombre;
        this.damage = damage;
    }
    public abstract void ejecutar(Jugador oponente);

}

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

class Lacrim extends Movimiento {
    public Lacrim() {
        super("Lacrim / Agua", 30);
    }


    @Override
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

class Gaia extends Movimiento {
    public Gaia() {
        super("Gaia / Tierra", 40);
    }


    @Override
    public void ejecutar(Jugador oponente) {
        Random rand = new Random();
        int probabilidadAcertar = rand.nextInt(100);
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
class Flora extends Movimiento {
    public Flora() {
        super("Flora / Planta", 30);
    }


    @Override
    public void ejecutar(Jugador oponente) {
        Random rand = new Random();
        int probabilidadAcertar = rand.nextInt(100);
        if (probabilidadAcertar > 20) { // 80% de probabilidad de acertar
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

class AtaqueBasico extends Movimiento {
    public AtaqueBasico() {
        super("Ataque Básico", 20);
    }


    @Override
    public void ejecutar(Jugador oponente) {
        Random rand = new Random();
        int probabilidadAcertar = rand.nextInt(100);
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
