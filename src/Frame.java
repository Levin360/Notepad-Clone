import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Frame {

    public static JFrame frame;
    public static JTextArea textArea;

    public static void main(String[] args) {

        createFrame();
        createTextArea();
        createMenu();

        frame.setVisible(true);
    }

    public static void createFrame() {

        frame = new JFrame("Notepad");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setIconImage(new ImageIcon("E:/Downloads/NB_ICON.png").getImage());
    }
    public static void createTextArea() {

        textArea = new JTextArea();
        JScrollPane scrollBar = new JScrollPane(textArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollBar);
    }
    public static void createMenu() {
        // create Menu bar
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);

        // Create a Menu list
        JMenu fileMenu = new JMenu("File");
        menu.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        menu.add(editMenu);
        JMenu formatMenu = new JMenu("Format");
        menu.add(formatMenu);

        // create a File item
        JMenuItem New = new JMenuItem("New");
        fileMenu.add(New);
        New.addActionListener(e -> FileMenu.newFile());
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem open = new JMenuItem("Open");
        fileMenu.add(open);
        open.addActionListener(e -> FileMenu.openFile());
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem save = new JMenuItem("Save");
        fileMenu.add(save);
        save.addActionListener(e -> FileMenu.saveFile());
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem saveAs = new JMenuItem("SaveAs");
        fileMenu.add(saveAs);
        saveAs.addActionListener(e -> FileMenu.saveAsFile());
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));

        // create a Edit item
        JMenuItem cut = new JMenuItem("Cut");
        editMenu.add(cut);
        cut.addActionListener(e -> EditMenu.cut());
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem copy = new JMenuItem("Copy");
        editMenu.add(copy);
        copy.addActionListener(e -> EditMenu.copy());
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem paste = new JMenuItem("Paste");
        editMenu.add(paste);
        paste.addActionListener(e -> EditMenu.paste());
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem select = new JMenuItem("Select");
        editMenu.add(select);
        select.addActionListener(e -> EditMenu.selectAll());
        select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));

        //create a Format item
        JMenuItem bold = new JMenuItem("Bold");
        formatMenu.add(bold);
        bold.addActionListener(e -> FormatMenu.bold());
        bold.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem italic = new JMenuItem("Italic");
        formatMenu.add(italic);
        italic.addActionListener(e -> FormatMenu.italic());
        italic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem fontColor = new JMenuItem("Font Color");
        formatMenu.add(fontColor);
        fontColor.addActionListener(e -> FormatMenu.fontColor());
    }
}
