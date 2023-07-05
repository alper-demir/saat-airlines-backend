package saatairlinesapi.Services;

import saatairlinesapi.Services.Requests.CreateFlightRequest;
import saatairlinesapi.Services.Requests.UpdateFlightRequest;
import saatairlinesapi.Services.Responses.GetAllFlightsResponse;
import saatairlinesapi.Services.Responses.GetByIdFlightResponse;

import java.util.List;

public interface FlightService {
    List<GetAllFlightsResponse> getAll();
    void add(CreateFlightRequest createFlightRequest);
    GetByIdFlightResponse getById(int id);
    void deleteById(int id);
    void update(UpdateFlightRequest updateFlightRequest);
}
