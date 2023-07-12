package saatairlinesapi.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import saatairlinesapi.Services.AirportService;
import saatairlinesapi.Services.Requests.CreateUserRequest;
import saatairlinesapi.Services.Requests.UserLoginRequest;
import saatairlinesapi.Services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllers {

    UserService userService;
    public UserControllers(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateUserRequest createUserRequest){
        this.userService.add(createUserRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public boolean login(@RequestBody UserLoginRequest userLoginRequest){
       return this.userService.login(userLoginRequest);
    }

}
