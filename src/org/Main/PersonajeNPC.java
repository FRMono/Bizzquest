package org.Main;
public class PersonajeNPC {
    String nombre;

    public PersonajeNPC(String nombre){
        this.nombre = nombre;
    }
    public void hablar(String mensaje) {
        System.out.println(nombre + ": " + mensaje);
    }
}
