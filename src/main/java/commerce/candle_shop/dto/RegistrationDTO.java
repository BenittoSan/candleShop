package commerce.candle_shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDate;

    private String login;
    private String password;

}
