package au.com.nswdcs.vehicleregistration.service;

import au.com.nswdcs.vehicleregistration.constants.VehicleRegistrationResponseConstants;
import au.com.nswdcs.vehicleregistration.dto.Individual;
import au.com.nswdcs.vehicleregistration.dto.IndividualReturnResponse;
import au.com.nswdcs.vehicleregistration.dto.VehicleReturnResponse;
import au.com.nswdcs.vehicleregistration.model.IndividualModel;
import au.com.nswdcs.vehicleregistration.model.VehicleModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import au.com.nswdcs.vehicleregistration.repository.IndividualRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by George Shafik on 12/1/2023
 */
@Slf4j
@Service
public class IndividualService {

    @Autowired
    private IndividualRepository individualRepository;

    public IndividualService(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }

    public IndividualReturnResponse getAllIndividuals() {
        Iterable<IndividualModel> individuals = individualRepository.findAll();

        List<Individual> listIndividuals = new ArrayList<>();

        for (IndividualModel individualModel: individuals) {
            listIndividuals.add(individualModel.mapIndividualToIndividualModel());
        }

        return IndividualReturnResponse.builder()
                .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                .data(individuals)
                .build();
    }


    /**
     *
     * Adds new individual.
     *
     * @param individual
     * @return
     */
    public IndividualReturnResponse saveIndividual(IndividualModel individual) {
        IndividualReturnResponse individualReturnResponse = null;

        Optional<IndividualModel> foundIndividual = individualRepository.
                findIndividualModelById(individual.getId());

        if (!foundIndividual.isPresent()) {
            foundIndividual = individualRepository.
                    findIndividualModelByFirstnameAndSecondnameAndLicenseno(
                            individual.getFirstname(), individual.getSecondname(), individual.getLicenseno());
        }

        if (foundIndividual.isPresent()) {
            individualReturnResponse = IndividualReturnResponse.builder()
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                    .message( "Individual " +
                            individual.getFirstname() + " " +
                            individual.getSecondname() + " registration no: " + individual.getLicenseno() +
                            " already exists, look at Put request to update details.")
                    .build();
        } else {
            individualRepository.save(individual);

            individualReturnResponse = IndividualReturnResponse.builder()
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                    .message( "Individual " +
                            individual.getFirstname() + " " +
                            individual.getSecondname() + " registration no: " + individual.getLicenseno() +
                            " created.")
                    .build();
        }

        return individualReturnResponse;
    }

    /**
     *
     * Update individual.
     *
     * @param individual
     * @return
     */
    public IndividualReturnResponse updateIndividual(IndividualModel individual) {
        IndividualReturnResponse individualReturnResponse = null;

        Optional<IndividualModel> foundIndividual = individualRepository.
                findIndividualModelById(individual.getId());

        if (foundIndividual.isPresent()) {
            individualRepository.save(individual);

            individualReturnResponse = IndividualReturnResponse.builder()
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                    .message( "Individual " +
                            individual.getFirstname() + " " +
                            individual.getSecondname() + " registration no: " + individual.getLicenseno() +
                            " updated.")
                    .build();

        } else {

            individualReturnResponse = IndividualReturnResponse.builder()
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                    .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                    .message( "Individual " +
                            individual.getFirstname() + " " +
                            individual.getSecondname() + " registration no: " + individual.getLicenseno() +
                            " does not exist.")
                    .build();
        }

        return individualReturnResponse;
    }

}
