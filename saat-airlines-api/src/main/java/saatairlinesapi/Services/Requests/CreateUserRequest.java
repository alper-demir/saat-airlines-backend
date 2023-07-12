package saatairlinesapi.Services.Requests;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
