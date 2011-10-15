package farma_movil

class Pedido {

String usuario
static belongsTo = [producto:Producto] 
int cantidad
int estado
int pedido

static constraints = {  
	cantidad(blank:true)
	pedido(blank:true)
	}	
}
