package org.Main;

import Entity.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GamePanel extends JPanel implements Runnable{
    // CONFIGURACION
    final int originalTileSize = 16; // 16x16
    final int scale = 3; // 16x3 (escala) = 48

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int ScreenWidth = tileSize * maxScreenCol; // 768 pixeles
    final int ScreenHeight = tileSize * maxScreenRow; // 576 pixeles

    // FPS
    int FPS = 60;


    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    JugadorGP jugadorG = new JugadorGP(this, keyH);

    // Jugador posición default
    int jugadorX = 100;
    int jugadorY = 100;
    int jugadorVelocidad = 4;


    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){

        gameThread = new Thread(this); //  constructor
        gameThread.start(); // llama automaticamente a run
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.0166666 SEGUNDOS
        double nextDrawTime = System.nanoTime() + drawInterval; // // nanotime : devuelve el valor en nanosegundos
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){

            // Primero - Actualizamos la información del personaje (posición)
            update();

            // Segundo - Mostrar en pantalla la información actualizada
            repaint();
            drawCount++;



            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                timer +=  nextDrawTime - System.nanoTime();

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                if (timer >= 1000000000){
                    //System.out.println("FPS: " + drawCount);
                    drawCount = 0;
                    timer = 0;
                }

                Thread.sleep((long) remainingTime); // sleep acepta solo milisegundos por lo que hay que convertir el tiempo restante en milisegundos.

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() { // x aumenta hacia la derecha e y aumenta hacia abajo.
        if (keyH.upPressed == true){

            jugadorY -= jugadorVelocidad;
            jugadorY = jugadorY - jugadorVelocidad;
        } else if (keyH.downPressed == true) {

            jugadorY += jugadorVelocidad;
        } else if (keyH.leftPressed == true) {

            jugadorX -= jugadorVelocidad;
        } else if (keyH.rightPressed == true) {

            jugadorX += jugadorVelocidad;
        }
    }



    public void paintComponent(Graphics g){ // metodo estandar

        super.paintComponent(g); // hacer esto es una práctica enseñada por java para hacer que estos comandos funcionen

        Graphics2D g2 = (Graphics2D) g; // cambiamos una por otra

        g2.setColor(Color.white);

        g2.fillRect(jugadorX,jugadorY,tileSize,tileSize);

        g2.dispose();
    }

}
