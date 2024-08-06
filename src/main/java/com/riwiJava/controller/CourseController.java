package com.riwiJava.controller;

import com.riwiJava.entity.Course;
import com.riwiJava.entity.Student;
import com.riwiJava.model.CourseModel;
import com.riwiJava.model.StudentModel;
import com.riwiJava.utils.utils;

import javax.swing.*;
import java.util.List;

public class CourseController {

    StudentModel studentModel = new StudentModel();//no deja instanciar, se debe crear un metodo que instacie el modelo



    public static void create(){
        Course course= new Course();


        String name = JOptionPane.showInputDialog("Enter name course: ");
        int studentId = Integer.parseInt(JOptionPane.showInputDialog("Enter StudentId:  "));

        course.setName(name);
        course.setStudentId(studentId);

        instanceModel().createCourse(course);




    }

    public static void delete() {
        instanceModel().deleteCourse(utils.selectOption(instanceModel().findAll()));    }

    public static void update() {

        Course selectedStudent = (Course) utils.selectOption(instanceModel().findAll());

        selectedStudent.setName(JOptionPane.showInputDialog("Enter name's Course: ", selectedStudent.getName()));
        selectedStudent.setStudentId(Integer.parseInt(JOptionPane.showInputDialog("Enter id Student: ", selectedStudent.getStudentId())));



        instanceModel().updateCourse(selectedStudent);
    }



    public static void filter() {
        String field = utils.selectOption(List.of(new String[]{"course.name", "course.studentId"}));
        List<Course> filter = instanceModel().getByField(field, JOptionPane.showInputDialog("Search: "));

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


    public static CourseModel instanceModel() {
        return new CourseModel();
    }

}





