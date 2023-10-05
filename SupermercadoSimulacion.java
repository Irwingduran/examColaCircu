import java.util.Scanner;

public class SupermercadoSimulacion {
public static void main(String[] args) {
ColaCircular caja1 = new ColaCircular(10);
ColaCircular caja2 = new ColaCircular(10);
ColaCircular caja3 = new ColaCircular(10);

Scanner scanner = new Scanner(System.in);

while (true) {
System.out.println("Seleccione una caja (1, 2, 3) o ingrese 0 para salir:");
int opcionCaja = scanner.nextInt();

if (opcionCaja == 0) {
break;
} else if (opcionCaja < 1 || opcionCaja > 3) {
System.out.println("Caja no válida. Por favor, seleccione 1, 2 o 3.");
continue;
}

System.out.println("Seleccione una acción:");
System.out.println("1. Agregar venta");
System.out.println("2. Eliminar venta");
int opcionAccion = scanner.nextInt();

if (opcionAccion == 1) {
System.out.println("Ingrese la cantidad de productos vendidos:");
int productos = scanner.nextInt();
System.out.println("Ingrese el total en pesos:");
int total = scanner.nextInt();

switch (opcionCaja) {
case 1:
caja1.agregar(new Venta(productos, total));
break;
case 2:

caja2.agregar(new Venta(productos, total));
break;
case 3:
caja3.agregar(new Venta(productos, total));
break;
}
} else if (opcionAccion == 2) {
switch (opcionCaja) {
case 1:
if (!caja1.estaVacia()) {
Venta venta = (Venta) caja1.sacar();
System.out.println("Venta eliminada - Productos: " + venta.getProductos() + ", Total: " +

venta.getTotal());
} else {
System.out.println("Caja 1 está vacía, no se pueden eliminar ventas.");
}
break;
case 2:
if (!caja2.estaVacia()) {
Venta venta = (Venta) caja2.sacar();
System.out.println("Venta eliminada - Productos: " + venta.getProductos() + ", Total: " +

venta.getTotal());
} else {
System.out.println("Caja 2 está vacía, no se pueden eliminar ventas.");
}
break;
case 3:
if (!caja3.estaVacia()) {
Venta venta = (Venta) caja3.sacar();
System.out.println("Venta eliminada - Productos: " + venta.getProductos() + ", Total: " +

venta.getTotal());
} else {
System.out.println("Caja 3 está vacía, no se pueden eliminar ventas.");
}
break;
}
} else {
System.out.println("Acción no válida. Por favor, seleccione 1 para agregar venta o 2 para eliminar venta.");

}
}
}
}

class Venta {
private int productos;
private int total;

public Venta(int productos, int total) {
this.productos = productos;
this.total = total;
}

public int getProductos() {
return productos;
}

public int getTotal() {
return total;
}
}
