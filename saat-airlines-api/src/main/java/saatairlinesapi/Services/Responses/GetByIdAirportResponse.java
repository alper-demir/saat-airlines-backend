package saatairlinesapi.Services.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAirportResponse {
    private int id;
    private String name;
    private String code;
    private String city;
    private String country;
}
