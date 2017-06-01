package psa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarea {

	private String nombre;
	private String descripcion;
	private List<Empleado> empleadosTrabajando;
	private Date fechaInicio;

	public Tarea(String nombre) {
		this.nombre = nombre;
		this.descripcion = "-";
		this.fechaInicio = new Date();
		this.empleadosTrabajando = new ArrayList<Empleado>();
	}

	public void asignarEmpleado(Empleado empleado) {
		empleado.asignar(this);
		this.empleadosTrabajando.add(empleado);
	}
	
	public void asignarEmpleado(Empleado empleado, int duracionTarea) {
		empleado.asignar(this,duracionTarea);
		this.empleadosTrabajando.add(empleado);
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean estaTrabajando(Empleado empleado) {
		for(Empleado empleadoTrabajando: this.empleadosTrabajando){
			if(empleadoTrabajando.equals(empleado)){
				return true;
			}
		}
		return false;
	}

	public int obtenerHorasTrabajadas() {
		int horasTrabajadas = 0;
		for(Empleado empleado: this.empleadosTrabajando){
			horasTrabajadas += empleado.horasInsumidasEn(this);
		}
		return horasTrabajadas;
	}	

}
