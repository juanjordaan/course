package cloud.jordaan.juan.csg.infrastructure.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Grade;

@Transactional
@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
	List<Grade> findAllByCourseTermId(Long courseTermId);
}
