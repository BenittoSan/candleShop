package commerce.candle_shop.security.user;

import commerce.candle_shop.dto.RegistrationDTO;
import commerce.candle_shop.dto.UserAuthDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    @Operation
    public ResponseEntity<RegistrationDTO> registerUser(@RequestBody RegistrationDTO request) {
        try {
            // Rejestracja użytkownika
            RegistrationDTO user = userService.registerUser(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(request);
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody UserAuthDto request) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String token = jwtTokenProvider.generateToken(authentication);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }

}
