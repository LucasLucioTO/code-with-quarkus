package styluscar.car;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Endpoints relacionados aos carros
 */
@Path("car")
public class CarResource {
    @Inject CarService service;

    @GET
    @Path("/cars")
    public List<Car> getAllCars () {
        try {
            return  this.service.findAllCars();
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/create_car")
    @Transactional
    public Car createCar (Car car) {
        try {
            return this.service.createCar(car);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/create_car")
    @Transactional
    public Car updateCar (Car car) {
        try {
            return this.service.updateCar(car);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_car")
    @Transactional
    public boolean deleteCar (Long id) {
        try {
            return this.service.deleteCar(id);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

}
