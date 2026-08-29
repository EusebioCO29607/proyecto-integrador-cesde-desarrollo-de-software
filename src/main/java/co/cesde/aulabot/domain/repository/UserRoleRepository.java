package co.cesde.aulabot.domain.repository;
import co.cesde.aulabot.domain.models.UserRole;
import java.util.List;
public interface UserRoleRepository {

        UserRole create(UserRole userRole);

        boolean delete(Long userId, Long roleId);

        boolean update(UserRole userRoleUpdate);

        UserRole findById(Long userId, Long roleId);

        List<UserRole> findByUserId(Long userId);

        List<UserRole> findByRoleId(Long roleId);

        List<UserRole> findAll();

        boolean existsByUserIdAndRoleId(Long userId, Long roleId);

        boolean exists(Long userId, Long roleId);
}
