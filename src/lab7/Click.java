package lab7;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Click implements ActionListener  {
	private ModelFor2048 _model;
	public Click (ModelFor2048 m){
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_model.reset();
	}
	
}
