package psa;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AsignarEmpleado {
	
	private FachadaSistema sistema;
	private String nombreEmpleado;
	private boolean resultadoExitoso;
	
	private final String nombreProyecto = "PSA New Sprintg v1.0.2";
	private final String nombreRequerimiento = "Pruebas no funcionales";
	
	@Dado("^que existe el sistema$")
	public void que_existe_el_sistema() throws Throwable {
		sistema = new FachadaSistema();
	}

	@Dado("^que existe el empleado \"(.*?)\"$")
	public void que_existe_el_empleado(String empleadoNombre) throws Throwable {
		
		sistema.crearEmpleado(empleadoNombre);
		nombreEmpleado = empleadoNombre;
		
		sistema.crearProyecto(nombreProyecto);
		sistema.agregarRequerimientoaProyecto(nombreRequerimiento,nombreProyecto);
	}

	@Cuando("^quiero asignarlo a la tarea \"(.*?)\"$")
	public void quiero_asignarlo_a_la_tarea_que_es_parte_del_requerimiento_del_proyecto(String nombreTarea) throws Throwable {
		sistema.crearTarea(nombreTarea);
		resultadoExitoso = sistema.asignarEmpleadoaTarea(nombreEmpleado,nombreTarea);
	}
	
	@Cuando("^los asigno a la tarea \"(.*?)\" que demorará \"(.*?)\" horas de trabajo cada una$")
	public void los_asigno_a_la_tarea_que_demorara_horas_de_trabajo_cada_una(String nombreTarea, int duracionTarea) throws Throwable {
	    sistema.crearTareaParaRequerimiento(nombreTarea,nombreRequerimiento);
		sistema.asignarTodosLosEmpleadosaTarea(nombreTarea,duracionTarea);
	}

	@Entonces("^aparecerá asignado a la tarea \"(.*?)\"$")
	public void aparecera_asignado_al_proyecto(String tareaNombre) throws Throwable {
		assertTrue(resultadoExitoso);
		assertTrue(sistema.estaEmpleadoTrabajandoEnTarea(nombreEmpleado, tareaNombre));
	}
	
	@Entonces("^el proyecto tendrá \"(.*?)\" horas trabajadas$")
	public void el_proyecto_tendrá_horas_trabajadas(int horasTrabajadas) throws Throwable {
		assertEquals(horasTrabajadas,sistema.obtenerHorasTotalTrabajadasEnProyecto(nombreProyecto));
	}

}
