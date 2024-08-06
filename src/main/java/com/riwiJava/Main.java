package com.riwiJava;

import com.riwiJava.controller.CourseController;
import com.riwiJava.controller.InscriptionController;
import com.riwiJava.controller.ScoreController;
import com.riwiJava.controller.StudentController;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        int optionManager = 0, optionCRUD = 0, optionSearch = 0;

        do {
            optionManager = Integer.parseInt(JOptionPane.showInputDialog("""
            1. Student Manager
            2. Course Manager
            3. Inscription Manager
            4. Score Manager
            5. Exit
            
            Enter your option:
            """));

            switch (optionManager) {
                case 1:
                    do {
                        optionCRUD = Integer.parseInt(JOptionPane.showInputDialog("""
                        1. Create Student
                        2. Search Student
                        3. Delete Student
                        4. Update Student
                        5. Exit
                        
                        Enter your option:
                        """));

                        switch (optionCRUD) {
                            case 1:
                                StudentController.create();
                                break;

                            case 2:

                                do {
                                    optionSearch = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1. Show All Student
                                    2. Filter Student
                                    3. Exit
                                    
                                    Enter your option:
                                    """));

                                    switch (optionSearch) {
                                        case 1:
                                            StudentController.showAll();
                                            break;

                                        case 2:
                                            StudentController.filter();
                                            break;
                                    }
                                } while (optionSearch != 3);
                                break;

                            case 3:
                                StudentController.delete();
                                break;

                            case 4:
                                StudentController.update();
                                break;
                        }
                    } while (optionCRUD != 5);
                    break;
                case 2:
                    do {
                        optionCRUD = Integer.parseInt(JOptionPane.showInputDialog("""
                        1. Create Course
                        2. Search Course
                        3. Delete Course
                        4. Update Course
                        5. Exit
                        
                        Enter your option:
                        """));

                        switch (optionCRUD) {
                            case 1:
                                CourseController.create();
                                break;

                            case 2:

                                do {
                                    optionSearch = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1. Show All Course
                                    2. Filter Course
                                    3. Exit
                                    
                                    Enter your option:
                                    """));

                                    switch (optionSearch) {
                                        case 1:
                                            CourseController.showAll();
                                            break;

                                        case 2:
                                            CourseController.filter();
                                            break;
                                    }
                                } while (optionSearch != 3);
                                break;

                            case 3:
                                CourseController.delete();
                                break;

                            case 4:
                                CourseController.update();
                                break;
                        }
                    } while (optionCRUD != 5);
                    break;
                case 3:
                    do {
                        optionCRUD = Integer.parseInt(JOptionPane.showInputDialog("""
                        1. Create Inscription
                        2. Search Inscription
                        3. Delete Inscription
                        4. Update Inscription
                        5. Exit
                        
                        Enter your option:
                        """));

                        switch (optionCRUD) {
                            case 1:
                                InscriptionController.create();
                                break;

                            case 2:

                                do {
                                    optionSearch = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1. Show All Inscription
                                    2. Filter Inscription
                                    3. Exit
                                    
                                    Enter your option:
                                    """));

                                    switch (optionSearch) {
                                        case 1:
                                            InscriptionController.showAll();
                                            break;

                                        case 2:
                                            InscriptionController.filter();
                                            break;
                                    }
                                } while (optionSearch != 3);
                                break;

                            case 3:
                                InscriptionController.delete();
                                break;

                            case 4:
                                InscriptionController.update();
                                break;
                        }
                    } while (optionCRUD != 5);
                    break;
                case 4:
                    do {
                        optionCRUD = Integer.parseInt(JOptionPane.showInputDialog("""
                        1. Create Score
                        2. Search Score
                        3. Delete Score
                        4. Update Score
                        5. Exit
                        
                        Enter your option:
                        """));

                        switch (optionCRUD) {
                            case 1:
                                ScoreController.create();
                                break;

                            case 2:

                                do {
                                    optionSearch = Integer.parseInt(JOptionPane.showInputDialog("""
                                    1. Show All Score
                                    2. Filter Score
                                    3. Exit
                                    
                                    Enter your option:
                                    """));

                                    switch (optionSearch) {
                                        case 1:
                                            ScoreController.showAll();
                                            break;

                                        case 2:
                                            ScoreController.filter();
                                            break;
                                    }
                                } while (optionSearch != 3);
                                break;

                            case 3:
                                ScoreController.delete();
                                break;

                            case 4:
                                ScoreController.update();
                                break;
                        }
                    } while (optionCRUD != 5);
                    break;
            }
        } while (optionManager != 5);

        JOptionPane.showMessageDialog(null, "Thank you for using our application!");


    }

}