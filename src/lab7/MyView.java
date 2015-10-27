package lab7;

import java.util.ArrayList;

import javax.swing.*;

public class MyView {

	private JFrame _window;
	private JButton _scoreboard;
	private ModelFor2048 _model;
	private ArrayList<JButton> _JBList;

	public MyView(ModelFor2048 m) {
		_model = m;
		_model.addView(this);
		_window = new JFrame("2048");
		_JBList = new ArrayList<JButton>();
		this.iHave16Buttons();
		
		JPanel everythingpanel = new JPanel();
		
		_scoreboard = new JButton();
		JButton newGame = new JButton("New Game");
		everythingpanel.add(_scoreboard);
		everythingpanel.add(newGame);
		newGame.addActionListener(new Click(_model));
		_scoreboard.addKeyListener(new UpdateListener(_model));
		newGame.addKeyListener(new UpdateListener(_model));
		
		_window.add(everythingpanel);
		BoxLayout bx = new BoxLayout(everythingpanel,BoxLayout.X_AXIS);
		everythingpanel.setLayout(bx);
		
		JPanel panel = new JPanel(); 
		everythingpanel.add(panel);

		for (int i = 0; i < _JBList.size(); i++) {
			panel.add(_JBList.get(i));
			_JBList.get(i).addKeyListener(new UpdateListener(_model));
		}
		java.awt.GridLayout gl = new java.awt.GridLayout(4, 4);
		panel.setLayout(gl);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.pack();
		_window.setVisible(true);

		this.update();
	}

	public void update() {
		int i = 0;
		int x = 0;
		int y = 0;
		while (i < _JBList.size()) {
			if (x < 4) {
				_JBList.get(i).setText(_model.getData(x, y));
				x++;
				i++;
			}
			if (x >= 4 && y < 3) {
				y++;
				x = 0;
			}
		}
		_scoreboard.setText("Score: "+_model.getScore());
		_window.pack();

	}

	public void iHave16Buttons() {
		int b = 0;
		while (b < 16) {
			_JBList.add(new JButton());
			b++;
		}
	}

}
