/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;



/**
 *
 * @author Juaan
 */
public class Chef extends Empleado {

    public Chef(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void asignarTurno(String dia, String hora) {
        turnosTrabajo.put(dia, hora); 
    }

    @Override
    public String getNombreCompleto() {
        return "Chef " + super.getNombreCompleto();
    }
}
