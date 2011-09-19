package pe.edu.upc.dsd.farma.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.model.Cliente;

public class ClienteDaoJdbc extends SimpleJdbcDaoSupport implements ClienteDao {

	@Autowired
	public ClienteDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void insertarCliente(Cliente cliente) {
		getSimpleJdbcTemplate()
				.update("insert into cliente(DNI, nombre, direccion, telefono, distrito, email, flagNotif, password) values(?, ?, ?, ?, ?, ?, ?)",
						cliente.getStrDNI(), cliente.getStrNombre(),
						cliente.getStrDireccion(), cliente.getStrTelefono(),
						cliente.getStrDistrito(), cliente.getStrEmail(),
						cliente.getStrFlagNotif(), cliente.getStrPassword());
	}
}
