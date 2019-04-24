import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGui implements ActionListener {

	private int n;
	private int result;
	private int efficiency;

	public MainGui() {

	}

	public static void main(String[] args) {

	}

	public int calculateIteratively(int n) {
		// efficiency will be number of iterations. Use efficiency++
		return result;
	}

	public int calculateRecursively(int n) {
		// efficiency will be number of recursive calls. Use efficiency++
		return result;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	class WindowClosedClass extends WindowAdapter {
		public void windowClosed(WindowEvent e) {

		}
	}
}
