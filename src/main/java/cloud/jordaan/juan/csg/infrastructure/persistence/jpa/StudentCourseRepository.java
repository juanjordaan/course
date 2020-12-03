package cloud.jordaan.juan.csg.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.infrastructure.persistence.entity.StudentCourse;

@Transactional
@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
	// Somehow H2 jdbc driver not supporting this query, moved to repository using Spring JPA ... weird H2
	@Modifying
	@Query("delete from StudentCourse s where s.course.id = :courseId and s.student.id = :studentId")
	void deleteByCourseAndStudentId(Long courseId, Long studentId);
	public List<StudentCourse> findAllByCourseId(Long courseId);
	public Optional<StudentCourse> findByCourseAndStudentId(Long courseId, Long studentId);
}
