package saatairlinesapi.Services.Requests;

import lombok.Data;

@Data
public class UserLoginRequest {
    String email;
    String password;
}
