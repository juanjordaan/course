package cloud.jordaan.juan.csg.infrastructure.persistence.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	List<Attendance> findByCourseTermId(Long courseTermId);
}
