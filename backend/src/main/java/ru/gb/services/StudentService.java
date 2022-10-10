package ru.gb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.converters.StudentConverter;
import ru.gb.dtos.StudentDto;
import ru.gb.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentConverter studentConverter;
    private final StudentRepository studentRepository;

    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        studentRepository.findAll().forEach(s -> studentDtoList.add(studentConverter.convertStudentToDto(s)));
        return studentDtoList;
    }

    public StudentDto getStudent(Long id) {
        return studentConverter.convertStudentToDto(studentRepository.findById(id).get());
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public void createStudent(StudentDto studentDto) {
        studentRepository.save(studentConverter.convertStudentDtoToStudent(studentDto));
    }

}
