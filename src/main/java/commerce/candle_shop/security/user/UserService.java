package commerce.candle_shop.security.user;

import commerce.candle_shop.customer.Customer;
import commerce.candle_shop.customer.ICustomerJpaRepository;
import commerce.candle_shop.customer.ICustomerRepository;
import commerce.candle_shop.dto.RegistrationDTO;

import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ICustomerJpaRepository customerRepository;
    private final IRoleRepository roleRepository;

    public UserService(IUserRepository userRepository, BCryptPasswordEncoder passwordEncoder,
                       ICustomerJpaRepository customerRepository, IRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public RegistrationDTO registerUser(RegistrationDTO request) {

        Customer customer = new Customer();
            customer.setName(request.getName());
            customer.setEmail(request.getEmail());
            customer.setBirthday(request.getBirthDate());
            customer.setLastName(request.getLastName());
            customer.setCreatedAt(LocalDateTime.now());

        customerRepository.save(customer);


        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("ROLE_USER not found"));

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        User user = new User();
            user.setCustomer(customer);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setUsername(request.getLogin());
            user.setEnabled(true);
            user.setRoles(roles);

        userRepository.save(user);
        return request;
    }
}
