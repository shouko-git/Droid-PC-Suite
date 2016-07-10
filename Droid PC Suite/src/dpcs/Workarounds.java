package dpcs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class Workarounds extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Workarounds frame = new Workarounds();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Workarounds() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Common Workarounds");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Workarounds.class.getResource("/graphics/Icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 210);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcommonworkaround4 = new JLabel("Connect only one android device at a time!");
		lblcommonworkaround4.setForeground(Color.BLACK);
		lblcommonworkaround4.setBounds(12, 132, 506, 38);
		contentPane.add(lblcommonworkaround4);
		
		JLabel lblcommonworkaround3_2 = new JLabel("and fastboot files with their newer or older versions.");
		lblcommonworkaround3_2.setForeground(Color.BLACK);
		lblcommonworkaround3_2.setBounds(12, 100, 506, 38);
		contentPane.add(lblcommonworkaround3_2);
		
		JLabel lblcommonworkaround3 = new JLabel("If some operations do not work on windows, please replace adb");
		lblcommonworkaround3.setForeground(Color.BLACK);
		lblcommonworkaround3.setBounds(12, 82, 506, 38);
		contentPane.add(lblcommonworkaround3);

		JLabel lblcommonworkaround1 = new JLabel("Use USB 2.0 to connect android device to system instead of USB 3.0.");
		lblcommonworkaround1.setForeground(Color.BLACK);
		lblcommonworkaround1.setBounds(12, 12, 506, 38);
		contentPane.add(lblcommonworkaround1);

		JLabel lblcommonworkaround2 = new JLabel("You may also need to install your android device usb drivers.");
		lblcommonworkaround2.setForeground(Color.BLACK);
		lblcommonworkaround2.setBounds(12, 46, 506, 38);
		contentPane.add(lblcommonworkaround2);
	}
}
