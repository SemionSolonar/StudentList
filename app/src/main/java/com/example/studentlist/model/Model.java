package com.example.studentlist.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public static final Model model = new Model();
    private final List<Student> studentList;

    private Model() {
        studentList = new ArrayList<>();
        studentList.add(new Student("Semion solonar","318554052"));
        studentList.add(new Student("Yan Levit","206088288"));
    }
    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void deleteStudent(Student student){
        studentList.remove(student);
    }

    public void editStudent(String uuid,String name,String id,String phone,String address,Boolean checked){
        Student student = studentList.stream()
                .filter(s->s.getUuid().equals(uuid))
                .findFirst()
                .orElse(null);
        if(student!=null){
            student.setId(id);
            student.setName(name);
            student.setAddress(address);
            student.setPhoneNumber(phone);
            student.setChecked(checked);
        }
    }
}

