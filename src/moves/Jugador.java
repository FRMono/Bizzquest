package moves;
import Entity.Entidad;
import org.Main.GamePanel;
import org.Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jugador extends Entidad {
    GamePanel gp;
    KeyHandler keyH;
    public String nombre;
    public int salud;
    public int resistencia;
    public List<Movimiento> movimientos;

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


