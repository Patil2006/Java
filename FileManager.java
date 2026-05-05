import java.io.*;

class FileManager {
    public static void saveScore(int score) {
        try {
            FileWriter fw = new FileWriter("score.txt", true);
            fw.write("Score: " + score + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("File error!");
        }
    }
}