package au.com.nswdcs.vehicleregistration.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by George Shafik on 12/1/2023
 */

@Data
@Builder
@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class VehicleReturnResponse {
    private String status;

    private String statusCode;

    private Object message;

    private String time;

    private Object data;

    private Object errors;
}
