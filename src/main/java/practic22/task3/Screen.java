package practic22.task3;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class Screen extends JFrame {

    private final Document document;

    private final Showman showman;

    private final DocumentReader documentReader;

    private final DocumentWriter documentWriter;

    public Screen(DocumentAbstractFactory factory) {

        showman = factory.createShowman();
        document = factory.createNewDocument();
        documentReader = factory.createReader();
        documentWriter = factory.createWriter();

        initSettings();
        initUi();
    }

    private void initSettings() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    private void initUi() {
        JPanel showPanel = new JPanel(new BorderLayout());
        setContentPane(showPanel);
        showman.setPanel(showPanel);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        initFileMenuItem(fileMenu);
        initOpenMenuItem(fileMenu);
        initSaveMenuItem(fileMenu);
        initExitMenuItem(fileMenu);

        jMenuBar.add(fileMenu);
        setJMenuBar(jMenuBar);

        revalidate();
    }

    private void initFileMenuItem(JMenu menu) {
        JMenuItem newMenuItem = new JMenuItem("New");
        menu.add(newMenuItem);

        newMenuItem.addActionListener(e -> showman.clear());
    }

    private void initOpenMenuItem(JMenu menu) {
        JMenuItem openMenuItem = new JMenuItem("Open");
        menu.add(openMenuItem);

        openMenuItem.addActionListener(e -> selectFileFromContextMenu(path -> {
            Document openedDocument = documentReader.read(path);
            showman.show(openedDocument);
        }));
    }

    private void selectFileFromContextMenu(Consumer<String> callback) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            callback.accept(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void initSaveMenuItem(JMenu menu) {
        JMenuItem saveMenuItem = new JMenuItem("Save");
        menu.add(saveMenuItem);

        saveMenuItem.addActionListener(e -> saveFileFromContextMenu(path -> {
            document.setPath(path);
            document.setContent(showman.content());
            documentWriter.write(document);
        }));
    }

    private void saveFileFromContextMenu(Consumer<String> callback) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            callback.accept(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void initExitMenuItem(JMenu menu) {
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        menu.add(exitMenuItem);

        exitMenuItem.addActionListener(e -> System.exit(0));
    }
}
