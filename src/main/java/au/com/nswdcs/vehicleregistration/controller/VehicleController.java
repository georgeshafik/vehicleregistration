package au.com.nswdcs.vehicleregistration.controller;

import au.com.nswdcs.vehicleregistration.constants.ServiceMainConstants;
import au.com.nswdcs.vehicleregistration.dto.*;
import au.com.nswdcs.vehicleregistration.model.VehicleModel;
import au.com.nswdcs.vehicleregistration.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by George Shafik on 11/1/2023
 */
@RestController
@Slf4j
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Operation(summary = "", description = "returns all vehicles", tags = { "Vehicles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Individual.class))),

            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BasicAuthError.class))),

            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BadRequestError.class))),

            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerError.class))),

            @ApiResponse(responseCode = "503", description = "The service requested is currently unavailable",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceNotAvailableError.class))) })
    @RequestMapping(value = ServiceMainConstants.GET_ALL_VEHICLES,
            produces = { "application/json" },
            method = RequestMethod.GET)
    public VehicleReturnResponse getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @Operation(summary = "", description = "add a vehicle", tags = { "Vehicles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Individual.class))),

            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BasicAuthError.class))),

            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BadRequestError.class))),

            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerError.class))),

            @ApiResponse(responseCode = "503", description = "The service requested is currently unavailable",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceNotAvailableError.class))) })
    @RequestMapping(value = ServiceMainConstants.ADD_NEW_VEHICLE,
            produces = { "application/json" },
            method = RequestMethod.POST)
    public VehicleReturnResponse addNewVehicle(@Parameter(in = ParameterIn.DEFAULT, description = "",
            required = true, schema = @Schema()) @Valid @RequestBody Vehicle vehicle) {

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.mapVehicleToVehicleModel(vehicle);

        return vehicleService.saveVehicle(vehicleModel);
    }

    @Operation(summary = "", description = "update a vehicle", tags = { "Vehicles" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Individual.class))),

            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BasicAuthError.class))),

            @ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BadRequestError.class))),

            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InternalServerError.class))),

            @ApiResponse(responseCode = "503", description = "The service requested is currently unavailable",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceNotAvailableError.class))) })
    @RequestMapping(value = ServiceMainConstants.UPDATE_NEW_VEHICLE,
            produces = { "application/json" },
            method = RequestMethod.PUT)
    public VehicleReturnResponse updateVehicle(@Parameter(in = ParameterIn.DEFAULT, description = "",
            required = true, schema = @Schema()) @Valid @RequestBody Vehicle vehicle) {

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.mapVehicleToVehicleModel(vehicle);

        return vehicleService.updateVehicle(vehicleModel);
    }

}
