package org.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener { // metodos añadidos de manera aútomatica porque depende.

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            upPressed = true;

        }
        if (code == KeyEvent.VK_S){
            downPressed = true;

        }
        if (code == KeyEvent.VK_A){
            leftPressed = true;

        }
        if (code == KeyEvent.VK_D){
            rightPressed = true;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int codeR = e.getKeyCode();

        if (codeR == KeyEvent.VK_W){
            upPressed = false;

        }
        if (codeR == KeyEvent.VK_S){
            downPressed = false;

        }
        if (codeR == KeyEvent.VK_A){
            leftPressed = false;

        }
        if (codeR == KeyEvent.VK_D){
            rightPressed = false;

        }

    }
}
