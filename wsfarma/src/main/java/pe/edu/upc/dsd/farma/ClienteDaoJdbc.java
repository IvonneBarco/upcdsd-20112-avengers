package pe.edu.upc.dsd.farma;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class ClienteDaoJdbc extends SimpleJdbcDaoSupport implements ClienteDao {

	@Autowired
	public ClienteDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void insertarCliente(Cliente cliente) {
		getSimpleJdbcTemplate()
				.update("insert into cliente(DNI,nombre,direccion,telefono,distrito,email,flagNotif) values(?,?,?,?,?,?,?)",
						cliente.getStrDNI(), cliente.getStrNombre(),
						cliente.getStrDireccion(), cliente.getStrTelefono(),
						cliente.getStrDistrito(), cliente.getStrEmail(), cliente.getStrFlagNotif());
	}
}
