package hexlet.code.util;

import hexlet.code.model.User;
import hexlet.code.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    /**
     * @param args
     */
    @Override
    public void run(ApplicationArguments args) {
        createUser();
    }

    private void createUser() {
        if (userRepository.findByFirstName("Tom").isEmpty()) {
            User userData = new User();
            userData.setFirstName("Tom");
            userRepository.save(userData);
        }
    }

}
