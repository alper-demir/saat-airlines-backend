package saatairlinesapi.Controllers;

import org.springframework.web.bind.annotation.*;
import saatairlinesapi.Services.FlightService;
import saatairlinesapi.Services.Requests.CreateFlightRequest;
import saatairlinesapi.Services.Requests.UpdateFlightRequest;
import saatairlinesapi.Services.Responses.GetAllFlightsResponse;
import saatairlinesapi.Services.Responses.GetByIdFlightResponse;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightsController {
    private FlightService flightService;
    public FlightsController(FlightService flightService){
        this.flightService = flightService;
    }
    @GetMapping("/getall")
    public List<GetAllFlightsResponse> getAll(){
        return flightService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateFlightRequest createFlightRequest){
        this.flightService.add(createFlightRequest);
    }

    @GetMapping("/{id}")
    public GetByIdFlightResponse getById(@PathVariable int id){
        return this.flightService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateFlightRequest updateFlightRequest){
        this.flightService.update(updateFlightRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.flightService.deleteById(id);
    }

}
