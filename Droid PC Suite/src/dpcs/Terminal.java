package dpcs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Terminal extends JFrame {
	JTextArea TerminalEmulatorScreen;
	private JPanel contentPane;
	private JTextField commandinput;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terminal frame = new Terminal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Terminal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Terminal.class.getResource("/graphics/Icon.png")));
		setTitle("ADB Terminal Emulator (EXPERIMENTAL)");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 343);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 0, 426, 218);
		contentPane.add(scrollPane);

		TerminalEmulatorScreen = new JTextArea();
		TerminalEmulatorScreen.setText("ADB terminal emulator is highly experimental! Expect bugs!");
		TerminalEmulatorScreen.setBackground(Color.BLACK);
		TerminalEmulatorScreen.setEditable(false);
		TerminalEmulatorScreen.setForeground(Color.WHITE);
		scrollPane.setViewportView(TerminalEmulatorScreen);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 227, 357, 34);
		contentPane.add(scrollPane_1);

		commandinput = new JTextField();
		scrollPane_1.setViewportView(commandinput);
		commandinput.setColumns(10);
		commandinput.setText("Start typing command here...");
		
		JButton Sendcommandbutton = new JButton("Go");
		Sendcommandbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Process p1 = Runtime.getRuntime().exec(commandinput.getText());
					p1.waitFor();
					commandinput.setText("");
					BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
					String line = reader.readLine();
					while (line != null) {
						Terminal.this.TerminalEmulatorScreen.append("\n" + line);
						line = reader.readLine();
					}
				} catch (Exception e1) {
					Terminal.this.TerminalEmulatorScreen.append("" + e1);
				}
			}
		});
		Sendcommandbutton.setBounds(379, 230, 57, 25);
		contentPane.add(Sendcommandbutton);

		JButton ADBbutton = new JButton("$ adb");
		ADBbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandinput.setText("adb ");
			}
		});
		ADBbutton.setBounds(12, 273, 117, 25);
		contentPane.add(ADBbutton);

		JButton Fastbootbutton = new JButton("$ fastboot");
		Fastbootbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandinput.setText("fastboot ");
			}
		});
		Fastbootbutton.setBounds(165, 273, 117, 25);
		contentPane.add(Fastbootbutton);

		JButton clearbutton = new JButton("Clear");
		clearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TerminalEmulatorScreen.setText("");
			}
		});
		clearbutton.setBounds(319, 273, 117, 25);
		contentPane.add(clearbutton);
	}
}