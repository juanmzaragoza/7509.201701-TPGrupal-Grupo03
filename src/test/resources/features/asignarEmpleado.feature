# language: es
Característica: Asignar empleado a tarea

  Escenario: Existe el empleado y la tarea de un requerimiento
    Dado que existe el empleado "Tito Testero"
    Cuando quiero asignarlo a la tarea "Pruebas de stress de la API"
    Entonces aparecerá asignado a la tarea "Pruebas de stress de la API"
    
  Escenario: Proyecto con requerimientos y tareas
  	Dado que existe el empleado "Tito Testero"
  		Y que existe el empleado "Progra Matico"
  	Cuando los asigno a la tarea "Pruebas de stress de la API" que demorará "12" horas de trabajo cada una
  		Y los asigno a la tarea "Pruebas de calidad" que demorará "10" horas de trabajo cada una
  	Entonces el proyecto tendrá "44" horas trabajadas
  	

