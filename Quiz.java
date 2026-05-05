import java.util.*;

class Quiz implements QuizInterface {

    List<Question> questions = new ArrayList<>();
    int score = 0;

    public Quiz(String subject) {
        loadQuestions(subject);
    }

    void loadQuestions(String subject) {

        if(subject.equals("java")) {
            questions.add(new Question("Java is?", new String[]{"Compiled","Interpreted","Both","None"},3));
            questions.add(new Question("JVM stands for?", new String[]{"Java Virtual Machine","Java Variable","None","Machine"},1));
            // add total 10
        }

        else if(subject.equals("python")) {
            questions.add(new Question("Python is?", new String[]{"Compiled","Interpreted","Both","None"},2));
            questions.add(new Question("Creator of Python?", new String[]{"Guido","Dennis","James","Bjarne"},1));
        }

        else if(subject.equals("c")) {
            questions.add(new Question("C language developed by?", new String[]{"Dennis Ritchie","James","Guido","Bjarne"},1));
            questions.add(new Question("C is?", new String[]{"OOP","Procedural","Both","None"},2));
        }
    }

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);

        for(Question q : questions) {
            q.display();

            try {
                System.out.print("Answer: ");
                int ans = sc.nextInt();

                if(q.isCorrect(ans)) {
                    score++;
                }
            } catch(Exception e) {
                System.out.println("Invalid input!");
                sc.next();
            }
        }

        System.out.println("\nFinal Score: " + score + "/" + questions.size());
    }
}