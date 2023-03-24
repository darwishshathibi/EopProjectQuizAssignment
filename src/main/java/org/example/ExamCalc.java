package org.example;
import java.util.*;
public class ExamCalc {
    static Scanner input = new Scanner(System.in);
    static String[] student_name;
    static int[] mark;
    static int num_student;
    static int minCount;

    public static void main(String[] args) {
        System.out.println("*******************************************************\nMARKS EXAM CALCULATOR\n*******************************************************");
        System.out.print("Enter number of students: ");
        num_student = input.nextInt();
        StudentDetails(num_student);
        MarkSummary(SpecificMark());
    }

    static void StudentDetails(int num){
        student_name = new String[num_student];
        mark = new int[num_student];
        for (int i = 0; i < num; i++) {
            System.out.print("Enter name: ");
            student_name[i] = input.next();
            System.out.print("Enter rounded mark: ");
            mark[i] = input.nextInt();
            System.out.println();
        }
    }
    static int SpecificMark(){
        System.out.print("\nSearch for specific mark: ");
        return input.nextInt();
    }
    static void MarkSummary(int mark){
        System.out.println("\nMARK SUMMARY\n");
        System.out.println("\nStudent/s who get "+mark+" marks is/are");
        MarkSearch(mark);

        System.out.println("\nStudents who get the highest mark "+MaxNumber()+" is/are");
        System.out.println("\nTotal student/s who get the highest mark = "+ MarkSearch(MaxNumber()));

        System.out.println("\nStudents who get the lowest mark "+MinNumber()+" is/are");
        MarkSearch(MinNumber());
        System.out.println("\nTotal student/s who get the lowest mark = "+ minCount);
    }
    static int MarkSearch(int find_mark){
        int k = 0;
        for (int i = 0; i < num_student; i++) {
            if (mark[i] == find_mark){
                System.out.println(++k +". Name "+student_name[i]+" Index location "+ i);
            }

        }
        return k;
    }
    static int MaxNumber(){
        int max = mark[0];
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] > max)
                max = mark[i];
        }
        return max;
//        for (int j : mark) {
//            if (j > max) {
//                max = j;
//            }
//        }
    }
    static int MinNumber() {
        int min = mark[0];
        //check how many lowest mark
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == min)
                minCount++;
        }
        //find the lowest mark
        for (int j : mark) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

}

