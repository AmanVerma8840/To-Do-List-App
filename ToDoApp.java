import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {
    private JFrame frame;
    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public ToDoApp() {
        frame = new JFrame("To-Do List App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        topPanel.add(taskField);
        topPanel.add(addButton);

        // Task List
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton deleteButton = new JButton("Delete Selected");
        bottomPanel.add(deleteButton);

        // Add Panels to Frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Action Listeners
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        // Show Frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}