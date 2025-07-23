package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    double input, result;
    String cal;

    JFrame frame;
    JLabel label = new JLabel();
    JTextField textview = new JTextField();

    JButton symCLr = new JButton("CLR");
    JButton symDel = new JButton("DEL");
    JButton symMul = new JButton("*");
    JButton symDiv = new JButton("/");

    JButton num7 = new JButton("7");
    JButton num8 = new JButton("8");
    JButton num9 = new JButton("9");
    JButton symMinus = new JButton("-");

    JButton num4 = new JButton("4");
    JButton num5 = new JButton("5");
    JButton num6 = new JButton("6");
    JButton symPlus = new JButton("+");

    JButton num1 = new JButton("1");
    JButton num2 = new JButton("2");
    JButton num3 = new JButton("3");
    JButton symEqual = new JButton("=");		

    JButton num0 = new JButton("0");
    JButton symDot = new JButton(".");

    Calculator() {
        CreateInterface();
        InterfaceComponents();
        AddInterfaceEventListener();
    }

    public void CreateInterface() {
        frame = new JFrame();
        frame.setTitle("Java Calculator");
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(305, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void InterfaceComponents() {
        label.setBounds(240, 0, 40, 40);
        frame.add(label);
        textview.setBounds(10, 50, 270, 60);
        textview.setEditable(false);
        textview.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textview);

        symCLr.setBounds(10, 120, 60, 40);
        frame.add(symCLr);
        symDel.setBounds(80, 120, 60, 40);
        frame.add(symDel);
        symMul.setBounds(150, 120, 60, 40);
        frame.add(symMul);
        symDiv.setBounds(220, 120, 60, 40);
        frame.add(symDiv);

        num7.setBounds(10, 165, 60, 40);
        frame.add(num7);
        num8.setBounds(80, 165, 60, 40);
        frame.add(num8);
        num9.setBounds(150, 165, 60, 40);
        frame.add(num9);
        symMinus.setBounds(220, 165, 60, 40);
        frame.add(symMinus);

        num4.setBounds(10, 210, 60, 40);
        frame.add(num4);
        num5.setBounds(80, 210, 60, 40);
        frame.add(num5);
        num6.setBounds(150, 210, 60, 40);
        frame.add(num6);
        symPlus.setBounds(220, 210, 60, 40);
        frame.add(symPlus);

        num1.setBounds(10, 260, 60, 40);
        frame.add(num1);
        num2.setBounds(80, 260, 60, 40);
        frame.add(num2);
        num3.setBounds(150, 260, 60, 40);
        frame.add(num3);
        symEqual.setBounds(220, 260, 60, 90);
        frame.add(symEqual);

        num0.setBounds(10, 310, 130, 40);
        frame.add(num0);
        symDot.setBounds(150, 310, 60, 40);
        frame.add(symDot);
    }

    public void AddInterfaceEventListener() {
        symCLr.addActionListener(this);
        symDel.addActionListener(this);
        symMul.addActionListener(this);
        symDiv.addActionListener(this);

        num7.addActionListener(this);
        num8.addActionListener(this);
        num9.addActionListener(this);
        symMinus.addActionListener(this);

        num4.addActionListener(this);
        num5.addActionListener(this);
        num6.addActionListener(this);
        symPlus.addActionListener(this);

        num1.addActionListener(this);
        num2.addActionListener(this);
        num3.addActionListener(this);
        symEqual.addActionListener(this);

        num0.addActionListener(this);
        symDot.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();

        if (event == num0 || event == num1 || event == num2 || event == num3 || event == num4 || event == num5 || event == num6 || event == num7 || event == num8 || event == num9) {
            JButton btn = (JButton) event;
            String currentText = textview.getText();
            if (currentText.equals("0")) {
                textview.setText(btn.getText());
            } else {
                textview.setText(currentText + btn.getText());
            }
        } else if (event == symDot) {
            String currentText = textview.getText();
            if (!currentText.contains(".")) {
                textview.setText(currentText + ".");
            }
        } else if (event == symCLr) {
            label.setText("");
            textview.setText("");
        } else if (event == symDel) {
            String currentText = textview.getText();
            if (!currentText.isEmpty()) {
                textview.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else if (event == symMul || event == symDiv || event == symMinus || event == symPlus) {
            JButton btn = (JButton) event;
            String currentText = textview.getText();
            input = Double.parseDouble(currentText);
            cal = btn.getText();
            label.setText(currentText + " " + cal + " ");
            textview.setText("");
        } else if (event == symEqual) {
            String currentText = textview.getText();
            if (!currentText.isEmpty() && cal != null) {
                double secondOperand = Double.parseDouble(currentText);
                switch (cal) {
                    case "*":
                        result = input * secondOperand;
                        break;
                    case "/":
                        if (secondOperand != 0) {
                            result = input / secondOperand;
                        } else {
                            label.setText("Error: Division by zero");
                            return;
                        }
                        break;
                    case "-":
                        result = input - secondOperand;
                        break;
                    case "+":
                        result = input + secondOperand;
                        break;
                }
                if (result % 1 == 0) {
                    textview.setText(String.valueOf((int) result));
                } else {
                    textview.setText(String.valueOf(result));
                }
                label.setText("");
                cal = null;
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
