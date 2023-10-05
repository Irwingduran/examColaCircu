public class Usuario {
private String nombre;
private int id;
private String tipoServicio;

public Usuario(String nombre, int id, String tipoServicio) {
this.nombre = nombre;
this.id = id;
this.tipoServicio = tipoServicio;
}

// Getters y setters (si es necesario)

@Override
public String toString() {
return "Nombre: " + nombre + ", ID: " + id + ", Tipo de Servicio: " + tipoServicio;
}
}

public class Banco {
private ColaCircular colaUsuarios;
private int numeroEjecutivos;

public Banco(int capacidad, int numeroEjecutivos) {
colaUsuarios = new ColaCircular(capacidad);
this.numeroEjecutivos = numeroEjecutivos;
}

public void agregarUsuario(Usuario usuario) {
if (colaUsuarios.numElementos() < colaUsuarios.getTamaño()) {
colaUsuarios.agregar(usuario);
System.out.println("Usuario agregado a la cola: " + usuario);
} else {
System.out.println("La cola de usuarios está llena. Espere su turno.");
}
}

public void atenderSiguienteUsuario() {
if (!colaUsuarios.estaVacia()) {
Usuario usuarioAtendido = (Usuario) colaUsuarios.sacar();
System.out.println("Ejecutivo atendiendo a: " + usuarioAtendido);
} else {
System.out.println("No hay usuarios en la cola.");
}
}

public int obtenerNumeroUsuariosEnCola() {
return colaUsuarios.numElementos();
}

public boolean estaColaVacia() {
return colaUsuarios.estaVacia();
}
}

public class Main {
public static void main(String[] args) {
Banco banco = new Banco(10, 1); // Crear un banco con capacidad para 10 usuarios y 1 ejecutivo

// Agregar usuarios a la cola
banco.agregarUsuario(new Usuario("Usuario1", 1, "Servicio A"));
banco.agregarUsuario(new Usuario("Usuario2", 2, "Servicio B"));
banco.agregarUsuario(new Usuario("Usuario3", 3, "Servicio A"));

// Atender a los usuarios en orden de llegada
banco.atenderSiguienteUsuario();
banco.atenderSiguienteUsuario();
banco.atenderSiguienteUsuario();
}
}
