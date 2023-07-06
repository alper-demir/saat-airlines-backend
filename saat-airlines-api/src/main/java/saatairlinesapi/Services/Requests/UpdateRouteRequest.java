package saatairlinesapi.Services.Requests;

import lombok.Data;

@Data
public class UpdateRouteRequest {
    private int id;
    private int sourceAirportId;
    private int destinationAirportId;
    private int distanceInMiles;
}
