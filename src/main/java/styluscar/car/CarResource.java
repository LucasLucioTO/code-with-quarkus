package styluscar.car;

import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;

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
    public Car createCar (CreateCarDto createCarDto) {
        try {
            return this.service.createCar(createCarDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/update_car")
    @Transactional
    public Car updateCar (UpdateCarDto updateCarDto) {
        try {
            return this.service.updateCar(updateCarDto);
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
