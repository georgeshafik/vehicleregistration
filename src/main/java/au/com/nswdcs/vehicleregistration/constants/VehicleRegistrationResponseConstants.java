package au.com.nswdcs.vehicleregistration.constants;


import java.util.AbstractMap;
import java.util.Map;

/**
 * Created by George Shafik on 12/1/2023
 */

public enum VehicleRegistrationResponseConstants {

    ACCEPTED("ACCEPTED", "202"),
    SUCCESS("SUCCESS", "200"),
    FAILED("FAILED", "424"),
    NOT_FOUND("FAILED", "404"),
    INTERNALSERVER("INTERNALSERVER", "500"),
    DBSTATUS("DBSTATUS", "503"),
    CREATED("CREATED", "201");

    private final String status;
    private final String code;

    VehicleRegistrationResponseConstants(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public Map.Entry<String, String> getBoth() {
        return new AbstractMap.SimpleEntry<>(status, code);
    }
}
