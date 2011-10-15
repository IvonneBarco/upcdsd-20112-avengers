package farma_movil

class User {

Long id
Long version

 String dni; 
 String nombre; 
 String direccion; 
 String telefono; 
 String distrito; 
 String email; 
 String password; 
 String flagNotif; 

String toString()
{ "$email" }

def constraints =
{
email(email:true)
password(blank:false, password:true)
}
}
