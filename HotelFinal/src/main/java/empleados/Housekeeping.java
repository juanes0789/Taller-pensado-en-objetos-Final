/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;


/**
 *
 * @author Juaan
 */

public class Housekeeping extends Empleado {

    public Housekeeping(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void asignarTurno(String dia, String hora) {
        turnosTrabajo.put(dia, hora); // Agregar el turno al mapa de turnosTrabajo
    }

    @Override
    public String getNombreCompleto() {
        return "Housekeeping " + super.getNombreCompleto();
    }
}