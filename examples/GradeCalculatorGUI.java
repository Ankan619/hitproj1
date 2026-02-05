import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalculatorGUI extends JFrame implements ActionListener {

    JTextField m1, m2, m3;
    JLabel result;

    public GradeCalculatorGUI() {
        setTitle("Student Grade Calculator");
        setSize(350, 250);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Marks Subject 1:"));
        m1 = new JTextField();
        add(m1);

        add(new JLabel("Marks Subject 2:"));
        m2 = new JTextField();
        add(m2);

        add(new JLabel("Marks Subject 3:"));
        m3 = new JTextField();
        add(m3);

        JButton btn = new JButton("Calculate");
        btn.addActionListener(this);
        add(btn);

        result = new JLabel("");
        add(result);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int a = Integer.parseInt(m1.getText());
            int b = Integer.parseInt(m2.getText());
            int c = Integer.parseInt(m3.getText());

            int total = a + b + c;
            double percent = total / 3.0;

            String grade = percent >= 75 ? "A"
                         : percent >= 60 ? "B"
                         : percent >= 40 ? "C"
                         : "Fail";

            result.setText("Total: " + total + " | Grade: " + grade);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid marks");
        }
    }

    public static void main(String[] args) {
        new GradeCalculatorGUI();
    }
}
