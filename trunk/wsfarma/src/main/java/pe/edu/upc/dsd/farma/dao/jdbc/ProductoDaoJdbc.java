package pe.edu.upc.dsd.farma.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.upc.dsd.farma.dao.ProductoDao;
import pe.edu.upc.dsd.farma.model.Producto;

@Repository
public class ProductoDaoJdbc extends SimpleJdbcDaoSupport implements ProductoDao {

	@Autowired
	public ProductoDaoJdbc(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public List<Producto> listarProducto() {
		return getSimpleJdbcTemplate().query(
				"select codigo, descripcion, unidMedida, precio from producto",
				new BeanPropertyRowMapper<Producto>(Producto.class));
	}

}
