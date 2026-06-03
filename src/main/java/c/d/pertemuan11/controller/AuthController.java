package c.d.pertemuan11.controller;

import c.d.pertemuan11.model.User;
import c.d.pertemuan11.model.Profile;
import c.d.pertemuan11.repository.UserRepository;
import c.d.pertemuan11.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String nama,
                           @RequestParam String alamat) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);

        Profile profile = new Profile();
        profile.setNama(nama);
        profile.setAlamat(alamat);
        profile.setUser(user);
        profileRepository.save(profile);

        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}