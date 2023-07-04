package saatairlinesapi.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import saatairlinesapi.Repositories.AirportRepository;
import saatairlinesapi.Services.Requests.CreateAirportRequest;
import saatairlinesapi.Services.Requests.UpdateAirportRequest;
import saatairlinesapi.Services.Responses.GetAllAirportsResponse;
import saatairlinesapi.Services.Responses.GetByIdAirportResponse;
import saatairlinesapi.core.utilities.mappers.ModelMapperService;
import saatairlinesapi.entities.Airport;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AirportManager implements AirportService {
    private AirportRepository airportRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllAirportsResponse> getAll() {
        List<Airport> airports = airportRepository.findAll();

        List<GetAllAirportsResponse> airportsResponse = airports.stream()
                .map(airport -> this.modelMapperService.forResponse().map(airport,GetAllAirportsResponse.class))
                .collect(Collectors.toList());

        return airportsResponse;
    }

    @Override
    public void add(CreateAirportRequest createAirportRequest) {

        Airport airport = modelMapperService.forRequest().map(createAirportRequest,Airport.class);
        this.airportRepository.save(airport);
    }

    @Override
    public void update(UpdateAirportRequest updateAirportRequest) {
        Airport airport = modelMapperService.forRequest().map(updateAirportRequest,Airport.class);
        this.airportRepository.save(airport);
    }

    @Override
    public void deleteById(int id) {
        this.airportRepository.deleteById(id);
    }

    @Override
    public GetByIdAirportResponse getById(int id) {
        Airport airport = this.airportRepository.findById(id).orElseThrow();

        GetByIdAirportResponse response = this.modelMapperService.forResponse().map(airport,GetByIdAirportResponse.class);

        return response;
    }
}
