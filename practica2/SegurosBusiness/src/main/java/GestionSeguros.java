


public class GestionSeguros implements IGestionSeguros, IGestionClientes, IInfoSeguros {
	private ISegurosDAO seguros;
	private IClientesDAO clientes;
	

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
		
		return null;
	}

	@Override
	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seguro anhadeConductorAdicional(String matricula, String conductor) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente cliente(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seguro seguro(String matricula) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente nuevoCliente(Cliente c) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente bajaCliente(String dni) throws OperacionNoValida, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
