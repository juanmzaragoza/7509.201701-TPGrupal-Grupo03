package psa;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private static int UNIQUE_ID = 0;
	private int id;
	private String nombre;
	private String contacto;
	
	public Cliente(String nombre, String contacto) {
		UNIQUE_ID = UNIQUE_ID++;
		this.id = UNIQUE_ID;
        this.nombre = nombre;
        this.contacto = contacto;
    }
	
	public int getId(){
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	
}
