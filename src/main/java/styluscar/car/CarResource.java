package styluscar.car;

import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Endpoints relacionados aos carros
 */
@Produces("application/json")
@Consumes("application/json")
@Path("/car")
public class CarResource {
    @Inject
    CarService service;

    @GET
    @Path("/cars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getAllCars() {
        try {
            List<Car> cars = this.service.findAllCars();
            return cars;
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("/create_car")
    @Transactional
    public Car createCar(CreateCarDto createCarDto) {
        try {
            return this.service.createCar(createCarDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/update_car")
    @Transactional
    public Car updateCar(UpdateCarDto updateCarDto) {
        try {
            return this.service.updateCar(updateCarDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/delete_car")
    @Transactional
    public boolean deleteCar(Long id) {
        try {
            return this.service.deleteCar(id);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

}
