package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
