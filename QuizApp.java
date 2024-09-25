
/*Quiz Questions and Options: Store quiz questions along with multiple-choice options and correct
answers.
Timer: Implement a timer for each question to limit the time to answer.
Question Display: Present one question at a time with multiple-choice options.
Answer Submission: Allow users to select an option and submit their answer within the given
time.
Score Calculation: Keep track of the user's score based on correct answers.

Result Screen: Display the final score and a summary of correct/incorrect answers.*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApp {
    private static final int TIME_LIMIT = 10; // 10 seconds per question
    private static List<Question> questions = new ArrayList<>();
    private static int score = 0;
    private static List<Boolean> results = new ArrayList<>();

    public static void main(String[] args) {
        setupQuestions();
        playQuiz();
        displayResults();
    }

    private static void setupQuestions() {
        questions.add(new Question("W is the Prime Minister of India?",
                new String[] { "1.Amit Shah", "2. Narendra Modi", "3. Ramnath Kovind", "4. Mukesh Ambani" }, 2));
        questions.add(new Question("What is 2 + 2?", new String[] { "1. 3", "2. 4", "3. 5", "4. 6" }, 2));
        questions.add(new Question("What is the largest planet?",
                new String[] { "1. Earth", "2. Mars", "3. Jupiter", "4. Saturn" }, 3));

        // Add more questions as needed
    }

    private static void playQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println(q.question);
            for (String option : q.options) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.\n");
                }
            }, TIME_LIMIT * 1000);

            int answer = -1;
            while (answer < 0 || answer > 3) {
                System.out.print("Your answer (0-3): ");
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                    if (answer >= 0 && answer <= 3) {
                        timer.cancel();
                        if (answer == q.correctAnswer) {
                            score++;
                            results.add(true);
                        } else {
                            results.add(false);
                        }
                    } else {
                        System.out.println("Invalid option. Try again.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                }
            }
        }

        scanner.close();

    }

    private static void displayResults() {
        System.out.println("\nQuiz Finished!");
        System.out.println("Your score: " + score + "/" + questions.size());

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Question " + (i + 1) + ": " + (results.get(i) ? "Correct" : "Incorrect"));
        }
    }
}
