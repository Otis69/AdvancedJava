import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {
	
	JTextArea area;
	JTextField input;
	Calculator calc;

	public static void main(String[] args) {
		new CalculatorView();
	}
	public CalculatorView() {
		super("Calculator");
		setSize(new Dimension(400, 400));
		setLayout(new BorderLayout());
		initializeComponents();
		setVisible(true);
	}
	
	private void initializeComponents() {
		calc = new Calculator();
		area = new JTextArea(20, 15);
		area.setEditable(false);
		area.setLineWrap(true);
		input = new JTextField(15);
		add(area, BorderLayout.NORTH);
		add(input, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input) {
			area.setText("" + calc.calculate(input.getText()));
		}
	}
	
}
