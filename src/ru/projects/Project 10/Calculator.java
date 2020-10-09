import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
        int width = 350;
        int height = 400;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);
    }
}
class CalculatorPanel extends JPanel {
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        result = 0;
        lastCommand = "=";
        start=true;

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton2("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton2("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton2("-", command);

        addButton1(".", insert);
        addButton("0", insert);
        addButton1("=", command);
        addButton2("+", command);

        add(panel, BorderLayout.CENTER);
    }
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(Color.BLACK);
        button.addActionListener(listener);
        panel.add(button);
    }
    private void addButton1(String label, ActionListener listener) {
        JButton button1 = new JButton(label);
        button1.setBackground(Color.DARK_GRAY);
        button1.setForeground(Color.CYAN);
        button1.addActionListener(listener);
        panel.add(button1);
    }
    private void addButton2(String label, ActionListener listener) {
        JButton button2 = new JButton(label);
        button2.setBackground(Color.GRAY);
        button2.setForeground(Color.CYAN);
        button2.addActionListener(listener);
        panel.add(button2);
    }
    private class InsertAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String input = event.getActionCommand();
            if(start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }
    private class CommandAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            if(start)
            {
                if(command.equals("-"))
                {
                    display.setText(command);
                    start = false;
                }
                else lastCommand = command;
            }
            else
            {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start=true;
            }
        }
    }
    public void calculate(double x)
    {
        if(lastCommand.equals("+")) result += x;
        else if(lastCommand.equals("-")) result -= x;
        else if(lastCommand.equals("*")) result *= x;
        else if(lastCommand.equals("/")) result /= x;
        else if(lastCommand.equals("=")) result = x;
        String outputD = new DecimalFormat("#0.0000").format(result);
        display.setText("" + outputD);
    }
}

public class Calculator
{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
