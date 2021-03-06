package principal;

import java.util.Scanner;

import model.Pedido;
import service.PedidoService;

public class GestionarPedidos {
	private static Scanner scan = new Scanner(System.in);
	private static PedidoService service = new PedidoService();
	private static int opcion;

	public static void main(String[] args) {

		do {
			menu();
			opcion = Integer.parseInt(scan.nextLine());

			switch (opcion) {
			case 1:
				if (service.agregarPedido(crearPedido())) {
					System.out.println("El pedido se ha añadido.");
				} else {
					System.out.println("Pedido con este numero ya existe en la lista.");
				}
				break;
			case 2:
				if (service.procesarPedido()) {
					System.out.println("Pedido procesado con exito.");
				} else {
					System.out.println("No hay pedidos por procesar.");
				}
				break;
			case 3:
				System.out.println("Introduce el numero del pedido: ");
				int numero = Integer.parseInt(scan.nextLine());

				if (service.priorizarPedido(numero)) {
					System.out.println("El pedido con numero " + numero + " fue priorizado.");
				} else {
					System.out.println("No existe pedido con numero " + numero + 
							", o el pedido esta listo para procesar.");
				}
				break;
			case 4:
				pedidosPendientes();
				break;
			case 5:
				if (service.nombresPedidosPendientes() != null) {
					for (String pedido : service.nombresPedidosPendientes()) {
						System.out.println("Producto- " + pedido);
					}
				} else {
					System.out.println("No hay pedidos pendientes.");
				}
				break;
			}
		} while (opcion != 6);

		scan.close();

	}

	private static void menu() {
		System.out.println("--------Opciones--------");
		System.out.println("1. Agregar pedido");
		System.out.println("2. Procesar pedido");
		System.out.println("3. Priorizar pedido");
		System.out.println("4. Facturación pendiente");
		System.out.println("5. Pedidos pendientes");
		System.out.println("6. Salir");
	}

	private static Pedido crearPedido() {
		scan = new Scanner(System.in);

		System.out.println("Introduce numero de pedido: ");
		int numero = Integer.parseInt(scan.nextLine());

		System.out.println("Introduce producto: ");
		String producto = scan.nextLine();

		System.out.println("Introduce el precio: ");
		double precio = Double.parseDouble(scan.nextLine());

		return new Pedido(numero, producto, precio);

	}
	
	private static void pedidosPendientes() {
		System.out.println("Pedidos pendientes por procesar:");

		if (service.facturacionPendiente() != null) {
			int contador = service.facturacionPendiente().size();
			for (Pedido pedido : service.facturacionPendiente()) {
				System.out.println("Numero: " + pedido.getNumero() + ", producto- " + pedido.getProducto()
						+ ", precio: " + pedido.getPrecio() + "€");
			}
			if (contador == 1) {
				System.out.println("Total: " + contador + " producto.");
			} else {
				System.out.println("Total: " + contador + " productos.");
			}
		} else {
			System.out.println("0");
		}
	}

}
