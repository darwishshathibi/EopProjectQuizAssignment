package org.example;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Collections;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GeniusQuiz {
    static ArrayList<String> question1 = new ArrayList<>();
    static ArrayList<String> answer_q1 = new ArrayList<>();
    static ArrayList<String> question2 = new ArrayList<>();
    static ArrayList<String> answer_q2 = new ArrayList<>();
    static ArrayList<String> question3 = new ArrayList<>();
    static ArrayList<String> answer_q3 = new ArrayList<>();
    static ArrayList<String> question4 = new ArrayList<>();
    static ArrayList<String> answer_q4 = new ArrayList<>();
    static ArrayList<String> question5 = new ArrayList<>();
    static ArrayList<String> answer_q5 = new ArrayList<>();
    static ArrayList<String> mcq = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static String name;
    static boolean validate;
    static int round;
    public static void main(String[] args) throws FileNotFoundException, InterruptedException{
        boolean check = validate;
        game_rules();
        student_name();
        for (round = 1; round <= 5; round++) {
            System.out.println("\nQuestion "+round);
            int random = (int) (Math.random()*3);
            check = display_question(round, random);
            if (!check)
                break;
        }
        if (!check)
            System.out.println("\n"+name+", You failed");
        else
            end_quiz();
    }
    static boolean display_question(int turn, int random) throws FileNotFoundException, InterruptedException {
        switch (turn) {
            case 1 -> {
                q1(random);
                return validate;
            }
            case 2 -> {
                q2(random);
                return validate;
            }
            case 3 -> {
                q3(random);
                return validate;
            }
            case 4 -> {
                q4(random);
                return validate;
            }
            case 5 -> {
                q5(random);
                return validate;
            }
        }
        return !validate;
    }
    static void q1(int random) throws FileNotFoundException, InterruptedException {
        read_file_question_q1();
        show_question(question1, random);
        generate_answer(random);
    }
    static void q2(int random) throws FileNotFoundException, InterruptedException{
        read_file_question_q2();
        show_question(question2, random);
        generate_answer(random);
    }
    static void q3(int random) throws FileNotFoundException, InterruptedException{
        read_file_question_q3();
        show_question(question3, random);
        generate_answer(random);
    }
    static void q4(int random) throws FileNotFoundException, InterruptedException{
        read_file_question_q4();
        show_question(question4, random);
        generate_answer(random);
    }
    static void q5(int random) throws FileNotFoundException, InterruptedException{
        read_file_question_q5();
        show_question(question5, random);
        generate_answer(random);
    }
    static void show_question(ArrayList<String> question, int random){System.out.println(question.get(random));} //display question
    static void generate_answer(int turn) throws FileNotFoundException, InterruptedException { //subList will separate arraylist
        if (round == 1){
            read_file_ans_q1();
            switch (turn) {
                case 0 -> check_answer(answer_q1.subList(0, 4),"Magnitude and direction");
                case 1 -> check_answer(answer_q1.subList(4, 8),"Dilation of arterioles near the surface of the skin");
                case 2 -> check_answer(answer_q1.subList(8, 12),"Calcium chloride");
            }
        } else if (round == 2) {
            read_file_ans_q2();
            switch (turn) {
                case 0 -> check_answer(answer_q2.subList(0, 4),"The rate of change of energy 800 joules.");
                case 1 -> check_answer(answer_q2.subList(4, 8),"both involve proton gradients");
                case 2 -> check_answer(answer_q2.subList(8, 12),"Fermentation of glucose");
            }
        } else if (round == 3) {
            read_file_ans_q3();
            switch (turn) {
                case 0 -> check_answer(answer_q3.subList(0, 4),"Doped with pentavalent atom");
                case 1 -> check_answer(answer_q3.subList(4, 8),"The hormone insulin being removed from the blood by the glomerulus.");
                case 2 -> check_answer(answer_q3.subList(8, 12),"Bromine molecule gains electron");
            }
        } else if (round == 4) {
            read_file_ans_q4();
            switch (turn) {
                case 0 -> check_answer(answer_q4.subList(0, 4), "Carbon - 14");
                case 1 -> check_answer(answer_q4.subList(4, 8),"Roots grow downwards");
                case 2 -> check_answer(answer_q4.subList(8, 12),"Soda lime glass");
            }
        } else if (round == 5) {
            read_file_ans_q5();
            switch (turn) {
                case 0 -> check_answer(answer_q5.subList(0, 4),"3.5 MW");
                case 1 -> check_answer(answer_q5.subList(4, 8),"hCG has a molecular mass of less than 69,000");
                case 2 -> check_answer(answer_q5.subList(8, 12),"+7");
            }
        }
    }
    static void check_answer(List<String> answer, String correct_answer) throws InterruptedException { //check answer whether is true or false
        mcq_choices();
        Collections.shuffle(answer);
        String correct_choices = null, user_answer ;
        for (int i = 0; i < answer.size(); i++) {
            System.out.println("\t"+mcq.get(i)+" "+answer.get(i));
            System.out.println(answer.get(i).contains(correct_answer)); //comment to not reveal true or false for every answer
            if (answer.get(i).contains(correct_answer))
                correct_choices = mcq.get(i);
        }
        user_answer = input_answer();
        TimeUnit.MILLISECONDS.sleep(500); // delay for 0.5 second
        validate = user_answer.equals(correct_choices);
        System.out.println("The answer is "+validate);
        TimeUnit.MILLISECONDS.sleep(1000); // delay for a second
    }
    static void read_file_question_q1() throws FileNotFoundException{
        File file = new File("question1collections.txt"); //read file question 1
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            question1.add(input.nextLine());
    }
    static void read_file_question_q2() throws FileNotFoundException{
        File file = new File("question2collections.txt"); //read file question 2
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            question2.add(input.nextLine());
    }
    static void read_file_question_q3() throws FileNotFoundException{
        File file = new File("question3collections.txt"); //read file question 3
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            question3.add(input.nextLine());
    }
    static void read_file_question_q4() throws FileNotFoundException{
        File file = new File("question4collections.txt"); //read file question 4
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            question4.add(input.nextLine());
    }
    static void read_file_question_q5() throws FileNotFoundException{
        File file = new File("question5collections.txt"); //read file question 5
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            question5.add(input.nextLine());
    }
    static void read_file_ans_q1()throws FileNotFoundException{
        File file = new File("ansq1.txt"); //read file answer question 1
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            answer_q1.add(input.nextLine());
    }
    static void read_file_ans_q2()throws FileNotFoundException{
        File file = new File("ansq2.txt"); //read file answer question 2
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            answer_q2.add(input.nextLine());
    }
    static void read_file_ans_q3()throws FileNotFoundException{
        File file = new File("ansq3.txt"); //read file answer question 3
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            answer_q3.add(input.nextLine());
    }
    static void read_file_ans_q4()throws FileNotFoundException{
        File file = new File("ansq4.txt"); //read file answer question 4
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            answer_q4.add(input.nextLine());
    }
    static void read_file_ans_q5()throws FileNotFoundException{
        File file = new File("ansq5.txt"); //read file answer question 5
        Scanner input = new Scanner(file);
        while (input.hasNextLine())
            answer_q5.add(input.nextLine());
    }
    static String input_answer(){
        System.out.print("Enter your answer: ");
        return input.next().toUpperCase();
    }
    static void mcq_choices(){ //choices of mcq
        mcq.add("A");
        mcq.add("B");
        mcq.add("C");
        mcq.add("D");
    }
    static void game_rules(){ //games rules
        System.out.println("WELCOME TO QUIZ");
        System.out.println("This question consist of 3 subjects which was Physics, Biology and Chemistry");
        System.out.println("There will be 5 questions, if you answer all questions without any failure, you will gain title 'GENIUS'.");
        System.out.println("The difficulty will be increased after you answer correctly.\n");
    }
    static void student_name(){ //student name
        System.out.print("Enter your name: ");
        name = input.nextLine();
    }
    static void end_quiz(){
        System.out.println("\n"+name+" is a GENIUS");
    }
}