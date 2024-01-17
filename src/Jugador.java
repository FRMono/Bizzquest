import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Jugador {
    String nombre;
    int salud;
    int resistencia;
    List<Movimiento> movimientos;


    public Jugador(String nombre, int salud, int resistencia) {
        this.nombre = nombre;
        this.salud = salud;
        this.resistencia = resistencia;
        this.movimientos = new ArrayList<>();
        // Agregar movimientos iniciales
        movimientos.add(new AtaqueBasico());
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
                System.out.println(nombre + " falló. ¡" + oponente.nombre + " esquivó el ataque!");
            }
        }
    }
}

