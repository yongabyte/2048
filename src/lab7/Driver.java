package lab7;

public class Driver {
	
	public static void main (String[] args){
		ModelFor2048 m =new ModelFor2048();
		MyView v=new MyView(m);
		m.randomizePosition();
		v.update();
	}
}
