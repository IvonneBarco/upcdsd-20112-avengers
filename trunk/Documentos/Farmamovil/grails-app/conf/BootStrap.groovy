import foobar.*
import farmamovil.*

class BootStrap {

    def init = { servletContext ->	
		def event1 = new User(email: 'cesitary@hotmail.com',
                     password: 'diazero1').save()					

		def event2 = new User(email: 'lata@hotmail.com',
                     password: '12345').save()	

		def event3 = new User(email: 'pie@hotmail.com',
                     password: '34567').save()	

		def event4 = new User(email: 'winner@hotmail.com',
                     password: '0987').save()	

		def event5 = new Producto(description: 'Aspirina x 500 mg',
                     cantidad: 50).save()					

		def event6 = new Producto(description: 'Aspirina x 1000 mg',
                     cantidad: 50).save()					
					 
		def event7 = new Producto(description: 'Jaraba par la tos',
                     cantidad: 5).save()					
					 
		def event8 = new Producto(description: 'Tapsin',
                     cantidad: 10).save()	
					 
		def event9 = new Producto(description: 'Aspirina x 500 mg',
                     cantidad: 50).save()					
					 
		
		
				
					 
			
			}
    def destroy = {
    }
}
