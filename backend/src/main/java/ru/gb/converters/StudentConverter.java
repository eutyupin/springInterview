package ru.gb.converters;

import org.springframework.stereotype.Component;
import ru.gb.dtos.StudentDto;
import ru.gb.entities.Student;

@Component
public class StudentConverter {

    public StudentDto convertStudentToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());

        return studentDto;
    }

    public Student convertStudentDtoToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        return student;
    }

}
