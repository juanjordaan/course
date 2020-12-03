package cloud.jordaan.juan.csg.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Course;

@Transactional
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
