package au.com.nswdcs.vehicleregistration.repository;


import au.com.nswdcs.vehicleregistration.model.IndividualModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.Optional;

/**
 * Created by George Shafik on 12/1/2023
 */
@Repository
public interface IndividualRepository extends CrudRepository<IndividualModel, String> {
    Optional<IndividualModel> findIndividualModelByFirstnameAndSecondnameAndLicenseno(
            final String firstName, final String lastName, final String licenseNo);

    Optional<IndividualModel> findIndividualModelById(final String id);

}
