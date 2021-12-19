package hebergement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HebergementRepository extends JpaRepository<Hebergement, Integer> {
	
	@Query("select c from Hebergement c where c.id like :id")
	public Page<Hebergement> hebergementById(@Param("id") String n, Pageable pageable);

}
