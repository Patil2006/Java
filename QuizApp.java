import java.util.*;

// Question class
class Question {
    String question;
    String[] options;
    int answer;

    Question(String q, String[] o, int a) {
        question = q;
        options = o;
        answer = a;
    }
}

// Quiz class
class Quiz {
    ArrayList<Question> list = new ArrayList<>();
    int score = 0;

    Quiz(String subject) {
        loadQuestions(subject);
    }

    void loadQuestions(String s) {

        // JAVA
        if(s.equals("java")) {
            list.add(new Question("Java is?", new String[]{"Dependent","Independent","OS","None"},2));
            list.add(new Question("Inheritance keyword?", new String[]{"this","super","extends","impl"},3));
            list.add(new Question("JVM?", new String[]{"Machine","Method","Memory","None"},1));
            list.add(new Question("Default int?", new String[]{"0","1","null","-1"},1));
            list.add(new Question("Loop?", new String[]{"if","for","int","class"},2));
            list.add(new Question("Scanner package?", new String[]{"util","io","lang","net"},1));
            list.add(new Question("String is?", new String[]{"class","primitive","none","loop"},1));
            list.add(new Question("Main return?", new String[]{"void","int","string","none"},1));
            list.add(new Question("End symbol?", new String[]{";","{}",".",":"},1));
            list.add(new Question("OOP concept?", new String[]{"Encapsulation","Loop","Array","None"},1));
        }

        // PYTHON
        else if(s.equals("python")) {
            list.add(new Question("Python is?", new String[]{"Compiled","Interpreted","Both","None"},2));
            list.add(new Question("Comment symbol?", new String[]{"#","//","--","/*"},1));
            list.add(new Question("List is?", new String[]{"mutable","fixed","none","tuple"},1));
            list.add(new Question("Function keyword?", new String[]{"def","func","fun","define"},1));
            list.add(new Question("Loop?", new String[]{"for","if","int","class"},1));
            list.add(new Question("Extension?", new String[]{".py",".java",".c",".html"},1));
            list.add(new Question("Indentation?", new String[]{"required","optional","none","ignore"},1));
            list.add(new Question("Tuple is?", new String[]{"immutable","mutable","both","none"},1));
            list.add(new Question("Input function?", new String[]{"input()","scan()","get()","read()"},1));
            list.add(new Question("len() is?", new String[]{"function","variable","class","none"},1));
        }

        // C
        else if(s.equals("c")) {
            list.add(new Question("C is?", new String[]{"OOP","Procedural","Both","None"},2));
            list.add(new Question("printf header?", new String[]{"stdio.h","math.h","conio.h","str.h"},1));
            list.add(new Question("Main type?", new String[]{"int","void","char","float"},1));
            list.add(new Question("Loop?", new String[]{"for","if","switch","int"},1));
            list.add(new Question("Index start?", new String[]{"0","1","-1","none"},1));
            list.add(new Question("End?", new String[]{";","{}",".",":"},1));
            list.add(new Question("Pointer?", new String[]{"*","&","#","@"},1));
            list.add(new Question("Extension?", new String[]{".c",".cpp",".java",".py"},1));
            list.add(new Question("Datatype?", new String[]{"int","loop","if","case"},1));
            list.add(new Question("Keyword?", new String[]{"int","loop","case","none"},1));
        }

        // C++
        else if(s.equals("cpp")) {
            list.add(new Question("C++ supports?", new String[]{"OOP","Procedural","Both","None"},3));
            list.add(new Question("cout header?", new String[]{"iostream","stdio","math","string"},1));
            list.add(new Question("Namespace?", new String[]{"namespace","name","space","std"},1));
            list.add(new Question("Constructor?", new String[]{"same name","main","init","none"},1));
            list.add(new Question("Destructor?", new String[]{"~","#","@","!"},1));
            list.add(new Question("Loop?", new String[]{"for","if","class","int"},1));
            list.add(new Question("Extension?", new String[]{".cpp",".c",".java",".py"},1));
            list.add(new Question("OOP?", new String[]{"Encapsulation","Loop","Array","None"},1));
            list.add(new Question("Operator?", new String[]{".","->","::","all"},4));
            list.add(new Question("Inheritance?", new String[]{":","extends","super","this"},1));
        }

        // HTML
        else {
            list.add(new Question("HTML is?", new String[]{"Markup","Language","OS","DB"},1));
            list.add(new Question("Link tag?", new String[]{"<a>","<p>","<div>","<h1>"},1));
            list.add(new Question("CSS stands for?", new String[]{"Style","Code","DB","None"},1));
            list.add(new Question("Image tag?", new String[]{"<img>","<pic>","<src>","<image>"},1));
            list.add(new Question("Paragraph tag?", new String[]{"<p>","<h1>","<span>","<div>"},1));
            list.add(new Question("Extension?", new String[]{".html",".css",".js",".java"},1));
            list.add(new Question("CSS used for?", new String[]{"style","logic","loop","db"},1));
            list.add(new Question("Syntax?", new String[]{"selector{}","()","[]","none"},1));
            list.add(new Question("Styling language?", new String[]{"CSS","HTML","C","Java"},1));
            list.add(new Question("HTML type?", new String[]{"Markup","Programming","DB","OS"},1));
        }
    }

    void start() {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < list.size(); i++) {
            Question q = list.get(i);

            System.out.println("\nQ" + (i+1) + ": " + q.question);

            for(int j = 0; j < 4; j++) {
                System.out.println((j+1) + ". " + q.options[j]);
            }

            System.out.print("Your answer: ");
            int ans = sc.nextInt();

            if(ans == q.answer) {
                score++;
            }
        }

        System.out.println("\n✅ Final Score: " + score + "/10");
    }
}

// Main class
public class QuizApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== QUIZ MENU =====");
        System.out.println("1. Java");
        System.out.println("2. Python");
        System.out.println("3. C");
        System.out.println("4. C++");
        System.out.println("5. HTML");

        System.out.print("Select language: ");
        int choice = sc.nextInt();

        String subject = "";

        switch(choice) {
            case 1: subject = "java"; break;
            case 2: subject = "python"; break;
            case 3: subject = "c"; break;
            case 4: subject = "cpp"; break;
            case 5: subject = "html"; break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        Quiz quiz = new Quiz(subject);
        quiz.start();

        System.out.println("\n🎉 Quiz Finished!");
    }
}