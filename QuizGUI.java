import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class QuizGUI extends JFrame implements ActionListener {

    List<Question> questions = new ArrayList<>();
    int index = 0, score = 0;

    JLabel questionLabel;
    JRadioButton[] options = new JRadioButton[4];
    ButtonGroup bg;
    JButton nextBtn;

    public QuizGUI() {
        setTitle("Quiz App");
        setSize(400, 300);
        setLayout(new FlowLayout());

        questionLabel = new JLabel();
        add(questionLabel);

        bg = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            bg.add(options[i]);
            add(options[i]);
        }

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(this);
        add(nextBtn);

        loadQuestions();
        displayQuestion();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void loadQuestions() {
        questions.add(new Question("Java is?",
                new String[]{"Lang", "Animal", "Car", "Food"}, 1));

        questions.add(new Question("5*5=?",
                new String[]{"10", "20", "25", "30"}, 3));
    }

    void displayQuestion() {
        Question q = questions.get(index);
        questionLabel.setText(q.question);

        for (int i = 0; i < 4; i++) {
            options[i].setText(q.options[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selected = -1;

        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                selected = i + 1;
            }
        }

        if (selected == questions.get(index).correctAnswer) {
            score++;
        }

        index++;
        bg.clearSelection();

        if (index < questions.size()) {
            displayQuestion();
        } else {
            JOptionPane.showMessageDialog(this, "Score: " + score);
            DBManager.saveScoreToDB(score);
        }
    }

    public static void main(String[] args) {
        new QuizGUI();
    }
}