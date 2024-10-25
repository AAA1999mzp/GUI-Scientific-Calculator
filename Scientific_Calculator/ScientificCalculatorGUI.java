import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

public class ScientificCalculatorGUI extends JFrame implements ActionListener {

    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public ScientificCalculatorGUI() {
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating a display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Creating a panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 10, 10));

        // Adding buttons to the panel
        String[] buttons = {
                "7", "8", "9", "/", 
                "4", "5", "6", "*", 
                "1", "2", "3", "-", 
                "0", ".", "=", "+", 
                "sin", "cos", "tan", "sqrt",
                "log", "x^y", "C", "Exit"
        };

        for (String button : buttons) {
            JButton b = new JButton(button);
            b.setFont(new Font("Arial", Font.PLAIN, 18));
            b.addActionListener(this);
            panel.add(b);
        }

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
                // Number input or decimal point
                display.setText(display.getText() + command);
            } else if (command.equals("C")) {
                // Clear the display
                display.setText("");
            } else if (command.equals("Exit")) {
                // Close the calculator
                System.exit(0);
            } else if (command.equals("=")) {
                // Perform the operation
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '^':
                        result = Math.pow(num1, num2);
                        break;
                }
                display.setText(Double.toString(result));
            } else if (command.equals("sin")) {
                // Sine operation
                num1 = Double.parseDouble(display.getText());
                display.setText(Double.toString(Math.sin(Math.toRadians(num1))));
            } else if (command.equals("cos")) {
                // Cosine operation
                num1 = Double.parseDouble(display.getText());
                display.setText(Double.toString(Math.cos(Math.toRadians(num1))));
            } else if (command.equals("tan")) {
                // Tangent operation
                num1 = Double.parseDouble(display.getText());
                display.setText(Double.toString(Math.tan(Math.toRadians(num1))));
            } else if (command.equals("sqrt")) {
                // Square root
                num1 = Double.parseDouble(display.getText());
                display.setText(Double.toString(Math.sqrt(num1)));
            } else if (command.equals("log")) {
                // Logarithm base 10
                num1 = Double.parseDouble(display.getText());
                display.setText(Double.toString(Math.log10(num1)));
            } else if (command.equals("x^y")) {
                // Power operation
                num1 = Double.parseDouble(display.getText());
                display.setText("");
                operator = '^';
            } else {
                // Operator input (+, -, *, /)
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculatorGUI();
    }
}
