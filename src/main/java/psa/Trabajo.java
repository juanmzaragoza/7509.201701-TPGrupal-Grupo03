package psa;

public class Trabajo {

	private Tarea tarea;
	private int cantidadHoras;
	
	public Trabajo(Tarea tarea) {
		this.tarea = tarea;
		this.cantidadHoras = 0;
	}

	public Trabajo(Tarea tarea, int cantidadHoras) {
		this.tarea = tarea;
		this.cantidadHoras = cantidadHoras;
	}

	public boolean estaRealizando(Tarea tarea) {
		return this.tarea.equals(tarea);
	}

	public int obtenerCantidadHoras() {
		return this.cantidadHoras;
	}

}
