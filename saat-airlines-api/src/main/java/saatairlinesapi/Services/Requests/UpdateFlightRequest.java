package saatairlinesapi.Services.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import saatairlinesapi.entities.FlightStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFlightRequest {
    private int id;
    private String flightNumber;
    private int route;
    private int price;
    private String date;
    private String arrivalTime;
    private int capacity;
    private FlightStatus status;
}
