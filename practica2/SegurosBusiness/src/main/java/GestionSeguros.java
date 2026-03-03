

public class GestionSeguros implements IGestionSeguros, IGestionClientes, IInfoSeguros {
	private ISegurosDAO seguros;
	private IClientesDAO clientes;
	
	/**
	 * Constructor gestion seguros
	 * @param daoClientes interfaz de la dao de clientes
	 * @param daoSeguros interfaz de la dao de seguros
	 */
	public GestionSeguros(IClientesDAO daoClientes, ISegurosDAO daoSeguros) {
		clientes = daoClientes;
		seguros = daoSeguros;
	}

	@Override
	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida, DataAccessException {
		Cliente c = clientes.cliente(dni);
		if (c == null) {
			throw new OperacionNoValida("No existe el cliente");
		}
		if (seguros.seguro(s.getId()).getMatricula().equals(s.getMatricula())) {
			throw new OperacionNoValida("Ya existe el seguro");
		}
		c.getSeguros().add(s);
		return seguros.creaSeguro(s);
	}

	@Override
	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida, DataAccessException {
		Cliente c = clientes.cliente(dni);
		if (c == null) {
			throw new OperacionNoValida("No existe el cliente");
		}
		Seguro s = seguros.seguroPorMatricula(matricula);
		if (!seguros.seguro(s.getId()).getMatricula().equals(s.getMatricula())) {
			throw new OperacionNoValida("No existe el seguro");
		}
		return seguros.eliminaSeguro(s.getId());
	}

	@Override
	public Seguro anhadeConductorAdicional(String matricula, String conductor) throws DataAccessException {
		Seguro s = seguros.seguroPorMatricula(matricula);
		if (s == null) {
			return s;
		}
		s.setConductorAdicional(conductor);
		return seguros.actualizaSeguro(s);
	}

	@Override
	public Cliente cliente(String dni) throws DataAccessException {
		return clientes.cliente(dni);
	}

	@Override
	public Seguro seguro(String matricula) throws DataAccessException {
		return seguros.seguroPorMatricula(matricula);
	}

	@Override
	public Cliente nuevoCliente(Cliente c) throws DataAccessException {
		return clientes.creaCliente(c);
	}

	@Override
	public Cliente bajaCliente(String dni) throws OperacionNoValida, DataAccessException {
		if (clientes.cliente(dni) == null) {
			throw new OperacionNoValida("No existia el cliente");
		}
		Cliente c = clientes.cliente(dni);
		if (!c.getSeguros().isEmpty()) {
			throw new OperacionNoValida("El cliente aun tiene seguros");
		}
		return clientes.eliminaCliente(dni);
	}

}
