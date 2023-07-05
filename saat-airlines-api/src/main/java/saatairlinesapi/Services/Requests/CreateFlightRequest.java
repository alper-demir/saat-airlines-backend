package saatairlinesapi.Services.Requests;

import lombok.Data;
import saatairlinesapi.entities.FlightStatus;

@Data
public class CreateFlightRequest {
    private String flightNumber;
    private int route;
    private int price;
    private String date;
    private String arrivalTime;
    private int capacity;
    private FlightStatus status;
}
