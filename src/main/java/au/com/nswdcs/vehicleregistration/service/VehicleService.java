package au.com.nswdcs.vehicleregistration.service;

import au.com.nswdcs.vehicleregistration.constants.VehicleRegistrationResponseConstants;
import au.com.nswdcs.vehicleregistration.dto.IndividualReturnResponse;
import au.com.nswdcs.vehicleregistration.dto.Vehicle;
import au.com.nswdcs.vehicleregistration.dto.VehicleReturnResponse;
import au.com.nswdcs.vehicleregistration.model.IndividualModel;
import au.com.nswdcs.vehicleregistration.model.VehicleModel;
import au.com.nswdcs.vehicleregistration.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by George Shafik on 12/1/2023
 */
@Slf4j
@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleReturnResponse getAllVehicles() {
        Iterable<VehicleModel> vehicles = vehicleRepository.findAll();

        List<Vehicle> listVehicles = new ArrayList<>();

        for (VehicleModel vehicleModel: vehicles) {
            listVehicles.add(vehicleModel.mapVehicleToVehicleModel());
        }

        return VehicleReturnResponse.builder()
                .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                .data(listVehicles)
                .build();
    }

    /**
     *
     * Adds new vehicle.
     *
     * @param vehicle
     * @return
     */
    public VehicleReturnResponse saveVehicle(VehicleModel vehicle) {
        VehicleReturnResponse vehicleReturnResponse = null;

        Optional<VehicleModel> foundVehicle = vehicleRepository.
                findVehicleModelById(vehicle.getId());

        if (foundVehicle.isPresent()) {
            vehicleReturnResponse = VehicleReturnResponse.builder()
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                    .message( "Vehicle " + vehicle.getId() + " already exists, look at Put request to update details.")
                    .build();
        } else {
            vehicleRepository.save(vehicle);

            vehicleReturnResponse = VehicleReturnResponse.builder()
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                    .message( "Vehicle " + vehicle.getId() + " created.")
                    .build();
        }

        return vehicleReturnResponse;
    }


    /**
     *
     * Update a vehicle.
     *
     * @param vehicle
     * @return
     */
    public VehicleReturnResponse updateVehicle(VehicleModel vehicle) {
        VehicleReturnResponse vehicleReturnResponse = null;

        Optional<VehicleModel> foundVehicle = vehicleRepository.
                findVehicleModelById(vehicle.getId());

        if (foundVehicle.isPresent()) {
            vehicleRepository.save(vehicle);

            vehicleReturnResponse = VehicleReturnResponse.builder()
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                    .message( "Vehicle " + vehicle.getId() + " updated. ")
                    .build();


        } else {
            vehicleReturnResponse = VehicleReturnResponse.builder()
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                    .message( "Vehicle " + vehicle.getId() + " does not exist.")
                    .build();
        }

        return vehicleReturnResponse;
    }
}
