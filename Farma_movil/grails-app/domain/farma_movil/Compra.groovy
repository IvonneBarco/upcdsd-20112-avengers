package farma_movil

class Compra {

int pedido
String usuario
static belongsTo = [producto:Producto] 
int cantidad
int estado

    static constraints = {
    }
}
