import javax.swing.*;
import java.awt.*;

public class FormatMenu {

    public static void bold() {
        Font currentFont = Frame.textArea.getFont();

        if (currentFont.isBold()) {
            Font normalFont = currentFont.deriveFont(Font.PLAIN);
            Frame.textArea.setFont(normalFont);
        }
        else {
            Font boldFont = currentFont.deriveFont(Font.BOLD);
            Frame.textArea.setFont(boldFont);
        }
    }
    public static void italic() {
        Font currentFont = Frame.textArea.getFont();

        if (currentFont.isItalic()) {
            Font normalFont = currentFont.deriveFont(Font.PLAIN);
            Frame.textArea.setFont(normalFont);
        }
        else {
            Font italicFont = currentFont.deriveFont(Font.ITALIC);
            Frame.textArea.setFont(italicFont);
        }
    }
    public static void fontColor() {
        Color selectedColor = JColorChooser.showDialog(null, "Select a Color", Color.BLACK);
        if (selectedColor != null) {
            Frame.textArea.setForeground(selectedColor);
        }
    }
}
