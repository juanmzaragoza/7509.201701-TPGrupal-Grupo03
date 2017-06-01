package psa;

import java.util.ArrayList;
import java.util.List;

public class Empleado {

	private String nombre;
	private List<Trabajo> trabajos;

	public Empleado(String nombre){
		this.nombre = nombre;
		this.trabajos = new ArrayList<Trabajo>();
	}

	public String getNombre() {
		return  nombre;
	}

	public void asignar(Tarea tarea) {
		this.trabajos.add(new Trabajo(tarea));
	}
	
	public void asignar(Tarea tarea, int cuyaDuracion) {
		this.trabajos.add(new Trabajo(tarea, cuyaDuracion));
	}

	public boolean estaAsignadoA(Tarea tarea) {
		for(Trabajo trabajo: this.trabajos){
			if(trabajo.estaRealizando(tarea)){
				return true;
			}
		}
		return false;
	}

	public int horasInsumidasEn(Tarea tarea) {
		int horasInsumidas = 0;
		for(Trabajo trabajo: this.trabajos){
			if(trabajo.estaRealizando(tarea)){
				horasInsumidas += trabajo.obtenerCantidadHoras();
			}
		}
		return horasInsumidas;
	}
}
