package saatairlinesapi.Services;

import saatairlinesapi.Services.Requests.CreateRouteRequest;
import saatairlinesapi.Services.Requests.UpdateRouteRequest;
import saatairlinesapi.Services.Responses.GetAllRoutesResponse;
import saatairlinesapi.Services.Responses.GetByIdRouteResponse;

import java.util.List;

public interface RouteService {
    List<GetAllRoutesResponse> getAll();
    GetByIdRouteResponse getById(int id);
    void add(CreateRouteRequest createRouteRequest);
    void update(UpdateRouteRequest updateRouteRequest);
    void deleteById(int id);

}
