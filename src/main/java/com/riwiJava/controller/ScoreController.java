package com.riwiJava.controller;

import com.riwiJava.entity.Student;
import com.riwiJava.model.StudentModel;
import com.riwiJava.utils.utils;

import javax.swing.*;
import java.util.List;

public class ScoreController {

    StudentModel studentModel = new StudentModel();//no deja instanciar, se debe crear un metodo que instacie el modelo



    public static void create(){
        Student student = new Student();

        String name = JOptionPane.showInputDialog("Enter name's Student: ");
        String  email = JOptionPane.showInputDialog("Enter email Student: ");
        Boolean statu = Boolean.valueOf(JOptionPane.showInputDialog("Enter status Student "));
        String courseSigned = JOptionPane.showInputDialog("Enter cv (technology that the developer uses): ");

        student.setName(name);
        student.setEmail(email);
        student.setStatu(statu);
        student.setCourseSigned(courseSigned);

        instanceModel().createStudent(student);

    }

    public static void delete() {
        instanceModel().deleteStudent(utils.selectOption(instanceModel().findAll()));    }

    public static void update() {

        Student selectedStudent = (Student) utils.selectOption(instanceModel().findAll());

        selectedStudent.setName(JOptionPane.showInputDialog("Enter name's student: ", selectedStudent.getName()));
        selectedStudent.setEmail(JOptionPane.showInputDialog("Enter email student: ", selectedStudent.getEmail()));
        //selectedStudent.setStatu(JOptionPane.showInputDialog("Enter status student: ", selectedStudent.getStatu()));
        selectedStudent.setCourseSigned(JOptionPane.showInputDialog("Enter course student ", selectedStudent.getCourseSigned()));


        instanceModel().updateStudent(selectedStudent);
    }



    public static void filter() {
        String field = utils.selectOption(List.of(new String[]{"student.name", "student.email", "student.statu", "student.courseSigned"}));
        List<Student> filter = instanceModel().getByField(field, JOptionPane.showInputDialog("Search: "));

        String students = "List of Student filter for " + field + " : \n";

        for (Object temp : filter) {
            Student student = (Student) temp;
            students += student.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, students);

    }
    public static void showAll() {
        String students = "List of Student: \n";

        for (Object temp : instanceModel().findAll()) {
            Student  student = (Student)  temp;
            students += student.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, students);
    }


    public static StudentModel instanceModel() {
        return new StudentModel();
    }

}





