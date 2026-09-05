package security.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.token.model.entity.UserAccess;

import java.util.Optional;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {

	Optional<UserAccess> findByUserAndPassword(String user, String password);
}
