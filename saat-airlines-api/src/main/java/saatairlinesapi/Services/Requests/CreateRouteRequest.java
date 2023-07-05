package saatairlinesapi.Services.Requests;

import lombok.Data;

@Data
public class CreateRouteRequest {
    private int source;
    private int destination;
    private int distanceInMiles;
}
