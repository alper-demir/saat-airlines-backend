package saatairlinesapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import saatairlinesapi.Services.AirportService;
import saatairlinesapi.Services.Requests.CreateAirportRequest;
import saatairlinesapi.Services.Requests.UpdateAirportRequest;
import saatairlinesapi.Services.Responses.GetAllAirportsResponse;
import saatairlinesapi.Services.Responses.GetByIdAirportResponse;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@CrossOrigin(origins = "http://localhost:4200")
public class AirportsController {

    private AirportService airportService;

    public AirportsController(AirportService flightService) {
        this.airportService = flightService;
    }

    @GetMapping("/getall")
    public List<GetAllAirportsResponse> getAll() {
        return airportService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateAirportRequest createAirportRequest){
        this.airportService.add(createAirportRequest);
    }

    @GetMapping("/{id}")
    public GetByIdAirportResponse getById(@PathVariable int id){
        return airportService.getById(id);
    }
    @PutMapping
    public void update(@RequestBody UpdateAirportRequest updateAirportRequest){
        this.airportService.update(updateAirportRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.airportService.deleteById(id);
    }

}
