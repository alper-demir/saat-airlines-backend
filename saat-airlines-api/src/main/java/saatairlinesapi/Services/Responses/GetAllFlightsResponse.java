package saatairlinesapi.Services.Responses;

import lombok.Data;
import saatairlinesapi.entities.FlightStatus;
import saatairlinesapi.entities.Route;

@Data
public class GetAllFlightsResponse {
    private int id;
    private String flightNumber;
    private Route route;
    private int price;
    private String date;
    private String arrivalTime;
    private int capacity;
    private FlightStatus status;
}
