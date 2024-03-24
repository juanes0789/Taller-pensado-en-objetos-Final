/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;


/**
 *
 * @author Juaan
 */
import java.util.HashMap;
import java.util.Map;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    Map<String, String> turnosTrabajo;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.turnosTrabajo = new HashMap<>();
    }
    

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }


    public String getTurnosTrabajo() {
        StringBuilder turnosInfo = new StringBuilder();
        turnosInfo.append("Empleado: ").append(this.getClass().getSimpleName()).append(" - ").append(getNombreCompleto()).append("\n");
        for (Map.Entry<String, String> entry : turnosTrabajo.entrySet()) {
            turnosInfo.append("Día: ").append(entry.getKey()).append(" - Turno: ").append(entry.getValue()).append("\n");
        }
        return turnosInfo.toString();
    }

    public abstract void asignarTurno(String dia, String hora);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
