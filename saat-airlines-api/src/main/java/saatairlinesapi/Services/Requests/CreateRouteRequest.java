package saatairlinesapi.Services.Requests;

import lombok.Data;

@Data
public class CreateRouteRequest {
    private int sourceAirportId;
    private int destinationAirportId;
    private int distanceInMiles;
}
