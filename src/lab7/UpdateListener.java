package lab7;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UpdateListener implements KeyListener {

	private ModelFor2048 _model;

	public UpdateListener(ModelFor2048 m) {
		_model = m;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			_model.moveRight();
			_model.addTR();
			_model.ran();

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			_model.moveLeft();
			_model.addTT();
			_model.ran();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			_model.moveUp();
			_model.addTU();
			_model.ran();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			_model.moveDown();
			_model.addTD();
			_model.ran();	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
