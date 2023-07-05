package saatairlinesapi.Services.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import saatairlinesapi.entities.FlightStatus;
import saatairlinesapi.entities.Route;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdFlightResponse {
    private int id;
    private String flightNumber;
    private Route route;
    private int price;
    private String date;
    private String arrivalTime;
    private int capacity;
    private FlightStatus status;
}
