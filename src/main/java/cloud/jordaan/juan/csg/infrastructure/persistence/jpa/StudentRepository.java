package cloud.jordaan.juan.csg.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Student;

@Transactional
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
