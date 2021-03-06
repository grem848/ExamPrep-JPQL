/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Student;
import facade.Facade;
import javax.persistence.Persistence;
import mappers.StudentInfo;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Main
{

    public static void main(String[] args)
    {
        Facade facade = new Facade(Persistence.createEntityManagerFactory("pu"));
        
        System.out.println("Find all Students in the system: \n" + facade.getAllStudents());
        
        System.out.println("---");

        System.out.println("Find all Students in the System with the first name Anders: \n" + facade.getAllStudentsFromName("Anders"));
        
        System.out.println("---");

        Student st = new Student("Anders", "Andersson");
        System.out.println("Insert a new Student into the system: " + facade.createStudent(st) + facade.StudentAssignSemester(st.getId(), 1));
        
        System.out.println("---");
        long sem1 = 1;
        long stu1 = 7;
        System.out.println("Assign a new student to a semester: " + facade.StudentAssignSemester(stu1, sem1) + ", assigned to semester: " + sem1);

        System.out.println("---");
        
        System.out.println("Find (using JPQL) all Students in the system with the last name And: \n" + facade.getAllStudentsFromLastName("And"));

        System.out.println("---");

        System.out.println("Find (using JPQL) the total number of students, for a semester given the semester name as parameter: \n" + facade.getAllStudentsFromSemester("CLcos-v14e"));
        
        System.out.println("---");
        
        System.out.println("Find (using JPQL) the total number of students in all semesters: \n" + facade.getAllStudentsFromAllSemesters());

        System.out.println("---");
        
        System.out.println("Find (using JPQL) the teacher who teaches the most semesters: ");
        
        System.out.println("---");
//        use to create studentInfo first time, how to stop it from adding same things?

//        System.out.println("Create StudentInfo: \n" + facade.createStudentInfo());
//        System.out.println("\n");
        
        System.out.println("Return a list of all Students, encapsulated as StudentInfo’s: \n" + facade.getStudentInfo());
        
        System.out.println("---");
        
        System.out.println("Create a method, which returns a single StudentInfo, given a students id as sketched below: \n" + facade.getStudentInfo(1));
        
        System.out.println("---");
        
    }

}
