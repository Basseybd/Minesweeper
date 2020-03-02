import javax.swing.*;

public class App {
	public static void main(String[] agrs){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new MainFrame();
			}
		});
	}
}
