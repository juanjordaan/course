package cloud.jordaan.juan.csg.infrastructure.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.infrastructure.persistence.entity.CourseTerm;

@Transactional
@Repository
public interface CourseTermRepository extends JpaRepository<CourseTerm, Long>  {
	List<CourseTerm> findByCourseId(Long courseId);
}
