package saatairlinesapi.Services.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAirportRequest {
    private int id;
    private String name;
    private String code;
    private String city;
    private String country;
}
