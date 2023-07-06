package saatairlinesapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import saatairlinesapi.Services.Requests.CreateRouteRequest;
import saatairlinesapi.Services.Requests.UpdateRouteRequest;
import saatairlinesapi.Services.Responses.GetAllRoutesResponse;
import saatairlinesapi.Services.Responses.GetByIdRouteResponse;
import saatairlinesapi.Services.RouteService;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "http://localhost:4200")
public class RoutesController {
    private RouteService routeService;

    public RoutesController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping("/getall")
    public List<GetAllRoutesResponse> getAll(){
        return routeService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdRouteResponse getById(@PathVariable int id){
        return routeService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateRouteRequest createRouteRequest){
        this.routeService.add(createRouteRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRouteRequest updateRouteRequest){
        this.routeService.update(updateRouteRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.routeService.deleteById(id);
    }

}
