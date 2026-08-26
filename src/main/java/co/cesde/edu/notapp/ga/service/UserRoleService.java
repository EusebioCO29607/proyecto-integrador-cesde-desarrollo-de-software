package co.cesde.edu.notapp.ga.service;
import co.cesde.edu.notapp.ga.models.UserRole;
import java.util.List;
public interface UserRoleService {


        UserRole create(UserRole userRole);

        boolean update(UserRole userRoleUpdate);

        boolean delete(Long userId, Long roleId);

        List<UserRole> findByUserId(Long userId);

        List<UserRole> findByRoleId(Long roleId);

        List<UserRole> findAll();

        boolean existsByUserIdAndRoleId(Long userId, Long roleId);

    }

