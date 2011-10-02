package pe.edu.upc.dsd.farma.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dsd.farma.dao.ClienteDao;
import pe.edu.upc.dsd.farma.model.Cliente;
import pe.edu.upc.dsd.farma.model.Pedido;

@Repository
public class ClienteDaoJdbc extends SimpleJdbcDaoSupport implements ClienteDao {

	@Autowired
	public ClienteDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void insertarCliente(Cliente cliente) {
		getSimpleJdbcTemplate()
				.update("insert into cliente(DNI, nombre, direccion, telefono, distrito, email, flagNotif, password) values(?, ?, ?, ?, ?, ?, ?, ?)",
						cliente.getStrDNI(), cliente.getStrNombre(),
						cliente.getStrDireccion(), cliente.getStrTelefono(),
						cliente.getStrDistrito(), cliente.getStrEmail(),
						cliente.getStrFlagNotif(), cliente.getStrPassword());
	}

	@Override
	public Cliente validaCliente(String dni, String pwd) {
		
		try {
			return getSimpleJdbcTemplate()
					.queryForObject(
							"select DNI, nombre, direccion, telefono, " +
							"distrito,email,flagNotif,password where DNI=? and password = ?",
							new BeanPropertyRowMapper<Cliente>(Cliente.class),
							dni, pwd);
		} catch (EmptyResultDataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
}
