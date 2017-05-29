# language: es
Característica: Cargar ticket externo

  Escenario: Un cliente carga exitosamente un ticket
    Dado que existe el cliente "Juan Perez" con numero de telefono "9999-9999"
    Cuando carga el ticket "No veo los proyectos"
    Entonces se crea el ticket cuyo reportante es "Juan Perez" y cuya descripcion es "No veo los proyectos"
