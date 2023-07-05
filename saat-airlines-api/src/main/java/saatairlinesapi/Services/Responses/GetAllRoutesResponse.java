package saatairlinesapi.Services.Responses;

import lombok.Data;
import saatairlinesapi.entities.Airport;

@Data
public class GetAllRoutesResponse {
    private int id;
    private Airport source;
    private Airport destination;
    private int distanceInMiles;
}
