package psa;

import java.util.Date;

public class TicketExterno {
	
	private String descripcion;
	private Date fecha_emision;
	private Cliente reportante;
	
	public TicketExterno(String descripcion, Cliente reportante){
		this.fecha_emision = new Date();
		this.reportante = reportante;
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Cliente getReportante() {
		return this.reportante;
	}
}
