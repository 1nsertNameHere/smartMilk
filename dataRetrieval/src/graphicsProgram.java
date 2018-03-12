import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class graphicsProgram extends JFrame {

	private static final int SCREEN_WIDTH = 480;
	private static final int SCREEN_HEIGHT = 854;

	private int volume, quality, ohms, oldQuality, oldVolume;

	static graphicsProgram g;
	static dataRetrieval d = new dataRetrieval();

	public static void main(String[] args) {
		g = new graphicsProgram();
	}

	public graphicsProgram() {
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (true) {
			volume = d.getVolume();
			quality = d.getQuality();
			ohms = d.getOhms();
			repaint();
			System.out.println("v=" + volume + " o=" + ohms + " q=" + quality);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.setColor(Color.white);
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		g.setColor(Color.black);
		updateVolume(g);
		g.drawString("Quality: " + quality + "%", 100, 200);

	}

	private void updateVolume(Graphics g) {
		if (volume == 0) {
			g.drawString("Milk Empty!", 100, 100);
		} else if (volume == 1) {
			g.drawString("Milk under 50% full", 100, 100);
		} else if (volume == 2) {
			g.drawString("Milk over 50% full", 100, 100);
		} else // (volume == 3) {
			g.drawString("Milk Full", 100, 100);
	}

}
