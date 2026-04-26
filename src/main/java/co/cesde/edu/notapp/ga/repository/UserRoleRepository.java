package co.cesde.edu.notapp.ga.repository;
import co.cesde.edu.notapp.ga.models.UserRole;
import java.util.List;
public interface UserRoleRepository {

        UserRole create(UserRole userRole);

        boolean delete(Long userId, Long roleId);

        boolean update(UserRole userRoleUpdate);

        List<UserRole> findByUserId(Long userId);

        List<UserRole> findByRoleId(Long roleId);

        List<UserRole> findAll();

        boolean existsByUserIdAndRoleId(Long userId, Long roleId);


}
