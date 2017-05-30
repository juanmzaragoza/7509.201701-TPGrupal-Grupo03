package psa;

public class Trabajo {

	private Tarea tarea;
	private int cantidadHoras;
	private int costo;

	public Trabajo(Tarea tarea) {
		this.tarea = tarea;
		this.cantidadHoras = 0;
		this.costo = 1;
	}

	public boolean estaRealizando(Tarea tarea) {
		return this.tarea.equals(tarea);
	}

}
