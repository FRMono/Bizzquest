package org.Main;

import Entity.Entidad;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class JugadorGP  extends Entidad {
    GamePanel gp;
    KeyHandler keyH;
    public JugadorGP (GamePanel gp, KeyHandler keyH) {

    }
    public void Update () {
        if (keyH.upPressed == true){
            y -= jugadorVelocidadE;
            y = y - jugadorVelocidadE;

        } else if (keyH.downPressed == true) {
            y += jugadorVelocidadE;

        } else if (keyH.leftPressed == true) {
            x -= jugadorVelocidadE;

        } else if (keyH.rightPressed == true) {
            x += jugadorVelocidadE;
        }

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

}
