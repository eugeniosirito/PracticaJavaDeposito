package ar.edu.ort.tp1.pacial2.clases;

import ar.edu.ort.tp1.tdas.interfaces.ListaOrdenada;

public class Deposito implements Depositante<Producto, Integer> {

	private static final String MSG_TIPO_PROD_INVALIDO = "Tipo de producto inválido";
	private static final String MSG_NO_PUDO_DEPOSITAR = "No se pudo depositar el producto.";
	private static final String MSG_PROF_INVALIDO = "Profundidad de estantería inválido";
	private static final int ALTO_ESTANTERIA = 3;
	private static final int ANCHO_ESTANTERIA = 4;
	private static final int PROFUNDIDAD_ESTANTERIA_MAX = 10;
	private static final int PROFUNDIDAD_ESTANTERIA_MIN = 2;
	private static final int FILA_PELOTA = 0;
	private static final int FILA_RAQUETA = 1;
	private static final int FILA_BOLSO = 2;

	private Estante[][] estantes = new Estante[ALTO_ESTANTERIA][ANCHO_ESTANTERIA];
	private ListaProductoId listaProductoId;

	public Deposito(int profundidadEstanteria) {
		validarProfEstanteria(profundidadEstanteria);
		inicializarEstanteria(profundidadEstanteria);
		listaProductoId = new ListaProductoId();
	}

	private void inicializarEstanteria(int profundidadEstanteria) {
		this.estantes = new Estante[ALTO_ESTANTERIA][ANCHO_ESTANTERIA];
		for (int i = 0; i < ALTO_ESTANTERIA; i++) {
			for (int j = 0; j < ANCHO_ESTANTERIA; j++) {
				estantes[i][j] = new Estante(profundidadEstanteria);
			}
		}
	}

	private void validarProfEstanteria(int profundidadEstanteria) {
		if (profundidadEstanteria < PROFUNDIDAD_ESTANTERIA_MIN || profundidadEstanteria > PROFUNDIDAD_ESTANTERIA_MAX) {
			throw new RuntimeException(MSG_PROF_INVALIDO);
		}
	}

	@Override
	public void depositar(Producto elemento) {
		// TODO Auto-generated method stub

		if (elemento instanceof Pelota) {
			depositarProductoPorFila(elemento, FILA_PELOTA);
		} else if (elemento instanceof Bolso) {
			depositarProductoPorFila(elemento, FILA_BOLSO);
		} else if (elemento instanceof Raqueta) {
			depositarProductoPorFila(elemento, FILA_RAQUETA);
		}

		listaProductoId.add(elemento);
	}

	private void depositarProductoPorFila(Producto producto, int filaDeBusqueda) {
		int columna = 0;
		boolean depositado = false;

		while (columna < estantes[filaDeBusqueda].length && !depositado) {

			try {
				estantes[filaDeBusqueda][columna].depositar(producto);
				depositado = true;
			} catch (RuntimeException e) {
				columna++;
			}
		}
		if (!depositado) {
			throw new NoDepositadoException(MSG_NO_PUDO_DEPOSITAR);
		}

	}

	/**
	 * Indica si un producto se encuentra depositado
	 * 
	 * @param idProducto
	 * @return
	 */

	public boolean productoDepositado(Integer idProducto) {

		return listaProductoId.exists(idProducto);
	}

	/**
	 * Retira un producto en base a su ID
	 */

	@Override
	public Producto retirarPorId(Integer id) {

		Producto buscado = null;

		int fila = 0;

		while (fila < ALTO_ESTANTERIA && buscado == null) {

			int columna = 0;

			while (columna < ANCHO_ESTANTERIA && buscado == null) {

				buscado = estantes[fila][columna].retirarPorId(id);
				columna++;
			}

			fila++;
		}

		if (buscado != null) {
			listaProductoId.removeByKey(buscado.getId());
		}

		return buscado;
	}

}
