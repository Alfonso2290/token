package security.token.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.token.model.entity.UserAccess;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {

	Optional<List<UserAccess>> findByUserAndPassword(String user, String password);
}
