package co.cesde.aulabot.application.service;
import co.cesde.aulabot.domain.models.User;
import java.util.List;

public interface UserService {

        User create(User user);

        boolean update(User userUpdate);

        boolean delete(Long userId);

        User findById(Long userId);

        User findByUsername(String username);

        List<User> findAll();


}
