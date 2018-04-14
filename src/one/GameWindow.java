package one;

import javax.swing.*;

public class GameWindow extends JFrame {
	private static final int POS_X = 600;
	private static final int POS_Y = 200;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameWindow();
			}
		});
	}

	private GameWindow(){
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(POS_X,POS_Y,WIDTH,HEIGHT);
		GameCanvas gameCanvas = new GameCanvas(this);
		add(gameCanvas);
		setVisible(true);
	}

	void onDrawFrame(GameCanvas gameCanvas, float deltaTime){
		System.out.println("FPS = " + 1f / deltaTime);
	}
}
