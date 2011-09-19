package farmamovil



import org.junit.*
import grails.test.mixin.*


@TestFor(UnidadMedidaController)
@Mock(UnidadMedida)
class UnidadMedidaControllerTests {


    @Test
    void testIndex() {
        controller.index()
        assert "/unidadMedida/list" == response.redirectedUrl
    }

    @Test
    void testList() {

        def model = controller.list()

        assert model.unidadMedidaInstanceList.size() == 0
        assert model.unidadMedidaInstanceTotal == 0

    }

    @Test
    void testCreate() {
       def model = controller.create()

       assert model.unidadMedidaInstance != null


    }

    @Test
    void testSave() {
        controller.save()

        assert model.unidadMedidaInstance != null
        assert view == '/unidadMedida/create'

        // TODO: Populate valid properties

        controller.save()

        assert response.redirectedUrl == '/unidadMedida/show/1'
        assert controller.flash.message != null
        assert UnidadMedida.count() == 1
    }


    @Test
    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/unidadMedida/list'


        def unidadMedida = new UnidadMedida()

        // TODO: populate domain properties

        assert unidadMedida.save() != null

        params.id = unidadMedida.id

        def model = controller.show()

        assert model.unidadMedidaInstance == unidadMedida
    }

    @Test
    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/unidadMedida/list'


        def unidadMedida = new UnidadMedida()

        // TODO: populate valid domain properties

        assert unidadMedida.save() != null

        params.id = unidadMedida.id

        def model = controller.edit()

        assert model.unidadMedidaInstance == unidadMedida
    }

    @Test
    void testUpdate() {

        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/unidadMedida/list'

        response.reset()


        def unidadMedida = new UnidadMedida()

        // TODO: populate valid domain properties

        assert unidadMedida.save() != null

        // test invalid parameters in update
        params.id = unidadMedida.id

        controller.update()

        assert view == "/unidadMedida/edit"
        assert model.unidadMedidaInstance != null

        unidadMedida.clearErrors()

        // TODO: populate valid domain form parameter
        controller.update()

        assert response.redirectedUrl == "/unidadMedida/show/$unidadMedida.id"
        assert flash.message != null
    }

    @Test
    void testDelete() {
        controller.delete()

        assert flash.message != null
        assert response.redirectedUrl == '/unidadMedida/list'

        response.reset()

        def unidadMedida = new UnidadMedida()

        // TODO: populate valid domain properties
        assert unidadMedida.save() != null
        assert UnidadMedida.count() == 1

        params.id = unidadMedida.id

        controller.delete()

        assert UnidadMedida.count() == 0
        assert UnidadMedida.get(unidadMedida.id) == null
        assert response.redirectedUrl == '/unidadMedida/list'


    }


}