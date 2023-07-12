package saatairlinesapi.Services;

import saatairlinesapi.Services.Requests.CreateUserRequest;
import saatairlinesapi.Services.Requests.UserLoginRequest;

public interface UserService {
    void add(CreateUserRequest createUserRequest);
    boolean login(UserLoginRequest userLoginRequest);
}
