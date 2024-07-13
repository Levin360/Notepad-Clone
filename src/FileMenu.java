import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FileMenu {

    public static JFrame frame;
    public static String directory;
    public static String fileName;
    public static String filePath;

    public static void newFile() {
        Frame.textArea.setText("");
        Frame.frame.setTitle("New File");
    }
    public static void openFile() {
        FileDialog fileDialog = new FileDialog(frame, "Open File", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            directory = fileDialog.getDirectory();
            fileName = fileDialog.getFile();
            filePath = directory + fileName;
            Frame.frame.setTitle(fileName);

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
                String Line;
                Frame.textArea.setText("");
                while ((Line = reader.readLine()) != null) {
                    Frame.textArea.append(Line + "\n");
                }
            } catch (IOException e) {
                System.out.println("File not opened");
            }
        }
    }
    public static void saveAsFile() {
        FileDialog fileDialog = new FileDialog(frame, "Save File", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            directory = fileDialog.getDirectory();
            fileName = fileDialog.getFile();
            filePath = directory + fileName;
            Frame.frame.setTitle(fileName);

            try {
                FileWriter writer = new FileWriter(filePath);
                writer.write(Frame.textArea.getText());
                writer.close();
            }
            catch (IOException e) {
                System.out.println("File cannot be saved");
            }
        }
    }
    public static void saveFile() {
        if (fileName == null) {
            saveAsFile();
        }
        else {
            try {
                FileWriter writer = new FileWriter(filePath);
                writer.write(Frame.textArea.getText());
                writer.close();
            }
            catch (IOException e) {
                System.out.println("File cannot be saved");
            }
        }
    }
}
