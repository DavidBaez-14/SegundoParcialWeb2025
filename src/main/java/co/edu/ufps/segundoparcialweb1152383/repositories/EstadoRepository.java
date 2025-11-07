package co.edu.ufps.segundoparcialweb1152383.repositories;

import co.edu.ufps.segundoparcialweb1152383.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}