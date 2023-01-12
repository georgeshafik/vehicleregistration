package au.com.nswdcs.vehicleregistration.controller;

import au.com.nswdcs.vehicleregistration.constants.VehicleRegistrationResponseConstants;
import au.com.nswdcs.vehicleregistration.dto.Individual;
import au.com.nswdcs.vehicleregistration.dto.IndividualReturnResponse;
import au.com.nswdcs.vehicleregistration.model.IndividualModel;
import au.com.nswdcs.vehicleregistration.repository.IndividualRepository;
import au.com.nswdcs.vehicleregistration.service.IndividualService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private IndividualController individualController;

    @MockBean
    private IndividualRepository individualRepository;

    @Test
    void getAllIndividuals_ReturnsAllIndividuals_Success() {

        when(individualService.getAllIndividuals()).thenReturn(getIndividualReturnResponseWithData());

        IndividualReturnResponse individualReturnResponse =
                individualService.getAllIndividuals();

        assertEquals("200", individualReturnResponse.getStatus());

        List<Individual> listIndivuals = (List<Individual>) individualReturnResponse.getData();

        assertEquals(1, listIndivuals.size());
    }


    private IndividualModel getIndividual() {
        IndividualModel individualModel = new IndividualModel();



       // INSERT INTO `individual` VALUES ('H45678109','Andrew','Newton','','1974-12-11','17893247',true,'2001-11-15 12:20:00','2001-11-12 12:20:00');
        individualModel.setId("H45678109");
        individualModel.setFirstname("Andrew");
        individualModel.setSecondname("");

        return individualModel;
    }

    private List<IndividualModel> getIndividuals() {
        List<IndividualModel> listIndividualModel = new ArrayList<>();

        listIndividualModel.add(getIndividual());

        return listIndividualModel;

    }

    private IndividualReturnResponse getIndividualReturnResponseWithData() {

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
