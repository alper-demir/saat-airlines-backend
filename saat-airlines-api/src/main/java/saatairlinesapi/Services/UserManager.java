package saatairlinesapi.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import saatairlinesapi.Repositories.UserRepository;
import saatairlinesapi.Services.Requests.CreateUserRequest;
import saatairlinesapi.Services.Requests.UserLoginRequest;
import saatairlinesapi.core.utilities.mappers.ModelMapperService;
import saatairlinesapi.entities.User;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private ModelMapperService modelMapperService;
    private UserRepository userRepository;
    private JwtService jwtService;
    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = modelMapperService.forRequest().map(createUserRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginRequest userLoginRequest) {
        String email = userLoginRequest.getEmail();
        String password = userLoginRequest.getPassword();
        boolean isUserExists = userRepository.existsByEmailAndPassword(email, password);
        if(isUserExists){
            // Generate jwt token
            String token = jwtService.createJwtToken(email);
            System.out.println(token);
            System.out.println(jwtService.isJwtTokenValid(token,email));
        }
        return isUserExists;
    }

}
