package au.com.nswdcs.vehicleregistration.controller;

import au.com.nswdcs.vehicleregistration.constants.ServiceMainConstants;
import au.com.nswdcs.vehicleregistration.dto.*;
import au.com.nswdcs.vehicleregistration.model.IndividualModel;
import au.com.nswdcs.vehicleregistration.service.IndividualService;
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

/**
 * Created by George Shafik on 11/1/2023
 */
@RestController
@Slf4j
public class IndividualController {

    @Autowired
    IndividualService individualService;

    @Operation(summary = "", description = "returns all individual", tags = { "Individual" })
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
    @RequestMapping(value = ServiceMainConstants.GET_ALL_INDIVIDUALS,
            produces = { "application/json" },
            method = RequestMethod.GET)
    public IndividualReturnResponse getAllIndividuals() {
        return individualService.getAllIndividuals();
    }

    @Operation(summary = "", description = "add new individual", tags = { "Individual" })
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
    @RequestMapping(value = ServiceMainConstants.ADD_NEW_INDIVIDUALS,
            produces = { "application/json" },
            method = RequestMethod.POST)
    public IndividualReturnResponse addNewIndividuals(@Parameter(in = ParameterIn.DEFAULT, description = "",
                required = true, schema = @Schema()) @Valid @RequestBody Individual individual) {

        IndividualModel individualModel = new IndividualModel();
        individualModel.mapIndividualToIndividualModel(individual);

        return individualService.saveIndividual(individualModel);
    }

    @Operation(summary = "", description = "update individual", tags = { "Individual" })
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
    @RequestMapping(value = ServiceMainConstants.ADD_NEW_INDIVIDUALS,
            produces = { "application/json" },
            method = RequestMethod.PUT)
    public IndividualReturnResponse updateIndividual(@Parameter(in = ParameterIn.DEFAULT, description = "",
            required = true, schema = @Schema()) @Valid @RequestBody Individual individual) {

        IndividualModel individualModel = new IndividualModel();
        individualModel.mapIndividualToIndividualModel(individual);

        return individualService.updateIndividual(individualModel);
    }
}
