package au.com.nswdcs.vehicleregistration.repository;

import au.com.nswdcs.vehicleregistration.model.VehicleModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by George Shafik on 12/1/2023
 */
public interface VehicleRepository extends CrudRepository<VehicleModel, String>  {

    Optional<VehicleModel>  findVehicleModelById(final String id);

}
