package psa;

import java.util.ArrayList;
import java.util.List;

public class Requerimiento {

	private String nombre;
	private List<Tarea> tareas;

	public Requerimiento(String nombre) {
		this.nombre = nombre;
		this.tareas = new ArrayList<Tarea>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void agregar(Tarea tarea) {
		this.tareas.add(tarea);		
	}

	public int obtenerHorasTrabajadas() {
		int horasTrabajadas = 0;
		for(Tarea tarea: this.tareas){
			horasTrabajadas += tarea.obtenerHorasTrabajadas();
		}
		return horasTrabajadas;
	}

}