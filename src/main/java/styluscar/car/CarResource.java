package styluscar.car;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import styluscar.car.dto.CreateCarDto;
import styluscar.car.dto.UpdateCarDto;

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
    @Transactional
    public Car createCar(CreateCarDto createCarDto) {
        try {
            return this.service.createCar(createCarDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Car updateCar(@PathParam("id") Long id, UpdateCarDto updateCarDto) {
        try {
            return this.service.updateCar(id, updateCarDto);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public boolean deleteCar(@PathParam("id") Long id) {
        try {
            return this.service.deleteCar(id);
        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }

}
