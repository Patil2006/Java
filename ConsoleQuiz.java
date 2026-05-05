import java.io.*;
import java.util.*;

// Interface
interface QuizOperations {
    void loadQuestions(String subject);
}

// Base Class
class Question {
    String question;
    String[] options;
    int correct;

    Question(String q, String[] opt, int c) {
        question = q;
        options = opt;
        correct = c;
    }
}

// Derived Class
class QuizConsole implements QuizOperations {

    ArrayList<Question> questions = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // File I/O
    public void loadQuestions(String subject) {
        questions.clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader("questions.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data[0].trim().equals(subject)) {
                    String[] opts = {data[2], data[3], data[4], data[5]};
                    questions.add(new Question(data[1], opts, Integer.parseInt(data[6])));
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File Error!");
        }
    }

    void startQuiz() {
        System.out.println("Select Subject:");
        System.out.println("1. Java");
        System.out.println("2. C++");
        System.out.println("3. C");
        System.out.println("4. OS");
        System.out.println("5. Data Structures");

        int choice = sc.nextInt();
        sc.nextLine();

        String subject = "";

        switch (choice) {
            case 1: subject = "Java"; break;
            case 2: subject = "C++"; break;
            case 3: subject = "C"; break;
            case 4: subject = "OS"; break;
            case 5: subject = "Data Structures"; break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        loadQuestions(subject);

        if (questions.size() == 0) {
            System.out.println("No questions found!");
            return;
        }

        int score = 0;

        // ⏱ Timer start
        long startTime = System.currentTimeMillis();
        long endTime = startTime + (10 * 60 * 1000); // 10 minutes

        for (int i = 0; i < questions.size(); i++) {

            if (System.currentTimeMillis() > endTime) {
                System.out.println("\nTime's up!");
                break;
            }

            Question q = questions.get(i);

            System.out.println("\nQ" + (i + 1) + ": " + q.question);
            for (int j = 0; j < 4; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.print("Your answer: ");

            int ans = 0;

            try {
                ans = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
                i--;
                continue;
            }

            if (ans == q.correct) {
                score++;
            }
        }

        System.out.println("\nFinal Score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizConsole q = new QuizConsole();
        q.startQuiz();
    }
}