package co.cesde.edu.notapp.ga.repository;
import co.cesde.edu.notapp.ga.models.User;
import java.util.List;
public interface UserRepository {

        User create(User user);

        boolean delete(Long userId);

        boolean update(User userUpdate);

        User findById(Long userId);

        List<User> findByStatus(String status);

        List<User> findAll();

        boolean existsByUsername(String username);

        boolean existsByEmail(String email);

    User findByUsername(String username);
}






