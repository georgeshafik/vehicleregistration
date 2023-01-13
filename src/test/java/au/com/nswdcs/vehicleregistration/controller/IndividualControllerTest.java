package au.com.nswdcs.vehicleregistration.controller;

import au.com.nswdcs.vehicleregistration.constants.VehicleRegistrationResponseConstants;
import au.com.nswdcs.vehicleregistration.dto.Individual;
import au.com.nswdcs.vehicleregistration.dto.IndividualReturnResponse;
import au.com.nswdcs.vehicleregistration.model.IndividualModel;
import au.com.nswdcs.vehicleregistration.service.IndividualService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static au.com.nswdcs.vehicleregistration.utilities.GeneralUtilities.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by George Shafik on 13/1/2023
 */
@ActiveProfiles("test")
@SpringBootTest
public class IndividualControllerTest {

    @Mock
    private IndividualService individualService;

    @Test
    void getAllIndividuals_ReturnsAllIndividuals_Success() throws ParseException {

        when(individualService.getAllIndividuals()).thenReturn(getIndividualReturnResponseWithData());

        IndividualReturnResponse individualReturnResponse =
                individualService.getAllIndividuals();

        assertEquals("200", individualReturnResponse.getStatus());

        List<Individual> listIndivuals = (List<Individual>) individualReturnResponse.getData();

        assertEquals(1, listIndivuals.size());
    }


    private IndividualModel getIndividual() throws ParseException {
        IndividualModel individualModel = new IndividualModel();

        individualModel.setId("H45678109");
        individualModel.setFirstname("Andrew");
        individualModel.setSecondname("Newton");
        individualModel.setMiddlename("");
        individualModel.setDob(convertYYYYMMddToDate("1974-12-11"));
        individualModel.setLicenseno("17893247");
        individualModel.setIsactive(true);
        individualModel.setDatecreated(new Timestamp(convertYYYYMMddhhmmconvertYYYYMMddhhmmssToDatessToDate(getCurrentDateTime()).getTime()));
        individualModel.setDatemodified(new Timestamp(convertYYYYMMddhhmmconvertYYYYMMddhhmmssToDatessToDate(getCurrentDateTime()).getTime()));

        return individualModel;
    }

    private List<IndividualModel> getIndividuals() throws ParseException {
        List<IndividualModel> listIndividualModel = new ArrayList<>();

        listIndividualModel.add(getIndividual());

        return listIndividualModel;

    }

    private IndividualReturnResponse getIndividualReturnResponseWithData() throws ParseException {

        List<IndividualModel> listIndividualModel = getIndividuals();

        List<Individual> listIndividuals = new ArrayList<>();

        for(IndividualModel individualModel: listIndividualModel) {
            listIndividuals.add(individualModel.mapIndividualToIndividualModel());
        }

        return IndividualReturnResponse.builder()
                .status(VehicleRegistrationResponseConstants.SUCCESS.getStatus())
                .status(VehicleRegistrationResponseConstants.SUCCESS.getCode())
                .data(listIndividuals)
                .build();
    }
}
