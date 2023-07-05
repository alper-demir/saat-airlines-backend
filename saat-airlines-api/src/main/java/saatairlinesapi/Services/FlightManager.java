package saatairlinesapi.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import saatairlinesapi.Repositories.FlightRepository;
import saatairlinesapi.Repositories.RouteRepository;
import saatairlinesapi.Services.Requests.CreateFlightRequest;
import saatairlinesapi.Services.Requests.UpdateFlightRequest;
import saatairlinesapi.Services.Responses.GetAllFlightsResponse;
import saatairlinesapi.Services.Responses.GetByIdFlightResponse;
import saatairlinesapi.core.utilities.mappers.ModelMapperService;
import saatairlinesapi.entities.Flight;
import saatairlinesapi.entities.Route;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FlightManager implements FlightService {
    private FlightRepository flightRepository;
    private RouteRepository routeRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllFlightsResponse> getAll() {
        List<Flight> flights = flightRepository.findAll();

        List<GetAllFlightsResponse> flightsResponse = flights.stream()
                .map(flight -> this.modelMapperService.forResponse().map(flight, GetAllFlightsResponse.class))
                .collect(Collectors.toList());

        return flightsResponse;
    }

    @Override
    public void add(CreateFlightRequest createFlightRequest) {
        //Not: frontend tarafında tarih ve zaman bilgisi alınacakken tarih için : yy-mm-dd (2023-08-25), zaman için : hh:mm:ss (12:30:00) formatında olmalıdır.
        //Aksi halde listeyi döndürürken Mapper Date olarak okurken sorun çıkarıyor veritabanına bağlı olarak. Biz burada String olarak tanımladık.

        Route route = routeRepository.findById(createFlightRequest.getRoute()).orElseThrow();

        Flight flight = new Flight();
        flight.setFlightNumber(createFlightRequest.getFlightNumber());
        flight.setDate(createFlightRequest.getDate());
        flight.setPrice(createFlightRequest.getPrice());
        flight.setStatus(createFlightRequest.getStatus());
        flight.setArrivalTime(createFlightRequest.getArrivalTime());
        flight.setCapacity(createFlightRequest.getCapacity());
        flight.setRoute(route);

        flightRepository.save(flight);
    }

    @Override
    public GetByIdFlightResponse getById(int id) {
        Flight flight = this.flightRepository.findById(id).orElseThrow();
        GetByIdFlightResponse response = this.modelMapperService.forResponse().map(flight,GetByIdFlightResponse.class);
        return response;
    }

    @Override
    public void deleteById(int id) {
        this.flightRepository.deleteById(id);
    }

    @Override
    public void update(UpdateFlightRequest updateFlightRequest) {
        Flight existingFlight = flightRepository.findById(updateFlightRequest.getId()).orElseThrow();

        Route route = routeRepository.findById(updateFlightRequest.getRoute()).orElseThrow();

        existingFlight.setRoute(route);
        existingFlight.setFlightNumber(updateFlightRequest.getFlightNumber());
        existingFlight.setDate(updateFlightRequest.getDate());
        existingFlight.setPrice(updateFlightRequest.getPrice());
        existingFlight.setStatus(updateFlightRequest.getStatus());
        existingFlight.setArrivalTime(updateFlightRequest.getArrivalTime());
        existingFlight.setCapacity(updateFlightRequest.getCapacity());

        flightRepository.save(existingFlight);
    }
}