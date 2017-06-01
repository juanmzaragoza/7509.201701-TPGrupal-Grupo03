package psa;

import java.util.ArrayList;
import java.util.List;

import psa.excepciones.NoExisteRequerimientoException;

public class Fase {
	
	private String nombre;
	private List<Requerimiento> requerimientos;

	public Fase(String nombre){
		this.nombre = nombre;
		this.requerimientos = new ArrayList<Requerimiento>();
	}
	
	public void agregar(Requerimiento req){
		this.requerimientos.add(req);
	}

	public Requerimiento obtener(String nombreRequerimiento) {
		for(Requerimiento requerimiento: this.requerimientos){
			if(requerimiento.getNombre().equals(nombreRequerimiento)){
				return requerimiento;
			}
		}
		throw new NoExisteRequerimientoException();
	}
	
	public boolean existe(String nombreRequerimiento) {
		try{
			this.obtener(nombreRequerimiento);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public int obtenerHorasTrabajadas() {
		int horasTrabajadas = 0;
		for(Requerimiento requerimiento: this.requerimientos){
			horasTrabajadas += requerimiento.obtenerHorasTrabajadas();
		}
		return horasTrabajadas;
	}
}
