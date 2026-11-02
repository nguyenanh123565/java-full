package learn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class LearningSecurity {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService users(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("learner").password(encoder.encode(required("LEARNER_PASSWORD")))
                        .roles("USER").build(),
                User.withUsername("admin").password(encoder.encode(required("ADMIN_PASSWORD")))
                        .roles("USER", "ADMIN").build());
    }

    @Bean
    SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET, "/products", "/csrf", "/error").permitAll()
                .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
                .anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.logout(Customizer.withDefaults());
        // Giữ CSRF và session mặc định; form login cần trạng thái phiên.
        return http.build();
    }

    private String required(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Set learning environment variable " + name);
        }
        return value;
    }
}
