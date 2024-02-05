package moves;

abstract class Movimiento {
    String nombre;
    int damage;


    public Movimiento(String nombre, int damage) {
        this.nombre = nombre;
        this.damage = damage;
    }

    public abstract void ejecutar(Jugador oponente);

}
