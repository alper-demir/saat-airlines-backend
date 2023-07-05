package saatairlinesapi.Services.Requests;

import lombok.Data;

@Data
public class UpdateRouteRequest {
    private int id;
    private int source;
    private int destination;
    private int distanceInMiles;
}
