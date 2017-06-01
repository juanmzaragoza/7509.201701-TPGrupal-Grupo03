package psa;

import java.util.ArrayList;
import java.util.List;

import psa.excepciones.ProyectoSinFasesExpcetion;

public class Proyecto {
	
	private String nombre;
	private List<Fase> fases;

	public Proyecto(String nombre){
		this.nombre = nombre;
		this.fases = new ArrayList<Fase>();
		
		this.fases.add(new Fase("Default"));
	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean agregar(Requerimiento requerimiento) {
		if(!this.fases.isEmpty()){
			this.fases.get(0).agregar(requerimiento);
			return true;
		}
		return false;
	}

	public Requerimiento obtener(String nombreRequerimiento) {
		if(!this.fases.isEmpty()){
			return this.fases.get(0).obtener(nombreRequerimiento);
		}
		throw new ProyectoSinFasesExpcetion();
	}

	public boolean existe(String nombreRequerimiento) {
		if(!this.fases.isEmpty()){
			return this.fases.get(0).existe(nombreRequerimiento);
		}
		return false;
	}

	public int cantidadHorasTotalesTrabajadas() {
		int cantidadHoras = 0;
		for(Fase fase: this.fases){
			cantidadHoras += fase.obtenerHorasTrabajadas();
		}
		return cantidadHoras;
	}
	
}
