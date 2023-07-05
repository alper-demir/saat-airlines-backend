package saatairlinesapi.Services.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import saatairlinesapi.entities.Airport;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdRouteResponse {
    private int id;
    private Airport source;
    private Airport destination;
    private int distanceInMiles;
}

