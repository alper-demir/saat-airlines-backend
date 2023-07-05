package saatairlinesapi.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import saatairlinesapi.Repositories.AirportRepository;
import saatairlinesapi.Repositories.RouteRepository;
import saatairlinesapi.Services.Requests.CreateRouteRequest;
import saatairlinesapi.Services.Requests.UpdateRouteRequest;
import saatairlinesapi.Services.Responses.GetAllRoutesResponse;
import saatairlinesapi.Services.Responses.GetByIdRouteResponse;
import saatairlinesapi.core.utilities.mappers.ModelMapperService;
import saatairlinesapi.entities.Airport;
import saatairlinesapi.entities.Route;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RouteManager implements RouteService {

    private RouteRepository routeRepository;
    private ModelMapperService modelMapperService;
    private AirportRepository airportRepository;
    @Override
    public List<GetAllRoutesResponse> getAll() {
        List<Route> routes = routeRepository.findAll();

        List<GetAllRoutesResponse> routesResponse = routes.stream()
                .map(route -> this.modelMapperService.forResponse().map(route,GetAllRoutesResponse.class))
                .collect(Collectors.toList());

        return routesResponse;
    }

    @Override
    public GetByIdRouteResponse getById(int id) {
        Route route = this.routeRepository.findById(id).orElseThrow();
        GetByIdRouteResponse response = this.modelMapperService.forResponse().map(route,GetByIdRouteResponse.class);
        return response;
    }

    @Override
    public void add(CreateRouteRequest createRouteRequest) {
        // Kaynak ve hedef havalimanlarını id'lerine göre alıyoruz
        Airport source = airportRepository.findById(createRouteRequest.getSource()).orElseThrow();
        Airport destination = airportRepository.findById(createRouteRequest.getDestination()).orElseThrow();

        // Route nesnesini oluşturup kaydediyoruz
        Route route = new Route();
        route.setSource(source);
        route.setDestination(destination);
        route.setDistanceInMiles(createRouteRequest.getDistanceInMiles());

        routeRepository.save(route);
    }

    @Override
    public void update(UpdateRouteRequest updateRouteRequest) {
        Route existingRoute = routeRepository.findById(updateRouteRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Route bulunamadı."));

        // Güncelleme isteği ile gelen sourceId ve destinationId değerlerini kullanarak Airport nesnelerini alıyoruz
        Airport source = airportRepository.findById(updateRouteRequest.getSource()).orElseThrow();
        Airport destination = airportRepository.findById(updateRouteRequest.getDestination()).orElseThrow();

        // Route nesnesini güncelliyoruz
        existingRoute.setSource(source);
        existingRoute.setDestination(destination);
        existingRoute.setDistanceInMiles(updateRouteRequest.getDistanceInMiles());

        routeRepository.save(existingRoute);
    }

    @Override
    public void deleteById(int id) {
        this.routeRepository.deleteById(id);
    }
}
