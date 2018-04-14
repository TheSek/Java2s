package one;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

	private long lastFrameTime;
	private final GameWindow gameWindow;

	public GameCanvas(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
		lastFrameTime = System.nanoTime();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		long currentTime = System.nanoTime();
		float deltaTime = (currentTime - lastFrameTime) * 1e-9f;
		lastFrameTime = currentTime;

		gameWindow.onDrawFrame(this, deltaTime);

		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
	}

	public int getLeft() {
		return 0;
	}

	public int getRight() {
		return WIDTH - 1;
	}

	public int getTop() {
		return 0;
	}

	public int getBottom() {
		return HEIGHT - 1;
	}
}
