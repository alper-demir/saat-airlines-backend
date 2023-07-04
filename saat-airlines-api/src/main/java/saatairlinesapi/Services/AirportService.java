package saatairlinesapi.Services;


import saatairlinesapi.Services.Requests.CreateAirportRequest;
import saatairlinesapi.Services.Requests.UpdateAirportRequest;
import saatairlinesapi.Services.Responses.GetAllAirportsResponse;
import saatairlinesapi.Services.Responses.GetByIdAirportResponse;

import java.util.List;

public interface AirportService {
    List<GetAllAirportsResponse> getAll();
    void add(CreateAirportRequest createAirportRequest);
    void update(UpdateAirportRequest updateAirportRequest);
    void deleteById(int id);
    GetByIdAirportResponse getById(int id);
}
