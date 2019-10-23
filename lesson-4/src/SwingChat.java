import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingChat {
    private JList list1;
    private JPanel panel1;
    private JTextField inPutText;
    private JButton myButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MySwingChat");
        frame.setBounds(500,300, 600, 300);
        frame.setContentPane(new SwingChat().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                System.out.println("CloseByMenu");
            }
        });
        frame.setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        fileMenu.add(exitMenuItem);
    }

    private SwingChat() {
        DefaultListModel listModel = new DefaultListModel();
        list1.setModel(listModel);

        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(inPutText.getText());
                inPutText.setText("");
            }
        });

        inPutText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(inPutText.getText());
                inPutText.setText("");
            }
        });

    }
}
