package farmamovil



import org.junit.*
import grails.test.mixin.*


@TestFor(PedidoController)
@Mock(Pedido)
class PedidoControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/pedido/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.pedidoInstanceList.size() == 0
        assert model.pedidoInstanceTotal == 0

    }

    @Test
    void testCreate() {
       def model = controller.create()

       assert model.pedidoInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.pedidoInstance != null
        assert view == '/pedido/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/pedido/show/1'
        assert controller.flash.message != null
        assert Pedido.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pedido/list'


        def pedido = new Pedido()

        // TODO: populate domain properties

        assert pedido.save() != null

        params.id = pedido.id

        def model = controller.show()

        assert model.pedidoInstance == pedido
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pedido/list'


        def pedido = new Pedido()

        // TODO: populate valid domain properties

        assert pedido.save() != null

        params.id = pedido.id

        def model = controller.edit()

        assert model.pedidoInstance == pedido
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pedido/list'

        response.reset()


        def pedido = new Pedido()

        // TODO: populate valid domain properties

        assert pedido.save() != null

        // test invalid parameters in update
        params.id = pedido.id

        controller.update()

        assert view == "/pedido/edit"
        assert model.pedidoInstance != null

        pedido.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/pedido/show/$pedido.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/pedido/list'

        response.reset()

        def pedido = new Pedido()

        // TODO: populate valid domain properties
        assert pedido.save() != null
        assert Pedido.count() == 1

        params.id = pedido.id

        controller.delete()

        assert Pedido.count() == 0
        assert Pedido.get(pedido.id) == null
        assert response.redirectedUrl == '/pedido/list'


    }


}