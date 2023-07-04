package saatairlinesapi.Services.Responses;

import lombok.Data;

@Data
public class GetAllAirportsResponse {
    private int id;
    private String name;
    private String code;
    private String city;
    private String country;
}
