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

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginRequest userLoginRequest) {
        String email = userLoginRequest.getEmail();
        String password = userLoginRequest.getPassword();
        if (userRepository.existsByEmailAndPassword(email, password)) {
            return true; // Kullanıcı veritabanında mevcut.
        }
        return false; // Kullanıcı veri tabanında yok.

    }

}
