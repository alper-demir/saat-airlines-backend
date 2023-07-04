package saatairlinesapi.Services.Requests;

import lombok.Data;

@Data
public class CreateAirportRequest {
    private String name;
    private String code;
    private String city;
    private String country;
}
