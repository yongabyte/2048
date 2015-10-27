package lab7;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ModelFor2048 {

	private HashMap<Point, Integer> _map;
	private MyView _view;
	private boolean _isChanged;
	private int _score;

	public ModelFor2048() {

		_map = new HashMap<>();
		_isChanged = false;
		_score = 0;

		int x = 0;
		int xBound = 4;
		int y = 0;
		int yBound = 4;
		boolean keepGoing = true;
		while (keepGoing) {
			if (x < xBound) {
				new Point(x, y);
				x++;
			} else if (y < yBound) {
				y++;
				x = 0;
			} else {
				keepGoing = false;
			}
		}
	}

	public void moveRight() {
		int x = 3;
		int y = 0;
		for (int t = 0; t < 4; t++) {
			for (int j = 0; j < 4; j++) {
				// move one row tile toward right
				for (x = 3; x > 0; x = x - 1) {
					if (!_map.containsKey(new Point(x, y))
							&& _map.containsKey(new Point(x - 1, y))) {
						_map.put(new Point(x, y), _map.get(new Point(x - 1, y)));
						_map.remove(new Point(x - 1, y));
						_isChanged = true;
					}
				}
			}
			if (x <= 0 && y < 3) {
				x = 3;
				y++;
			}
		}
		_view.update();
	}

	public void moveLeft() {
		int x = 0;
		int y = 0;
		for (int t = 0; t < 4; t++) {
			for (int j = 0; j < 4; j++) {
				for (x = 0; x < 3; x++) {
					if (!_map.containsKey(new Point(x, y))
							&& _map.containsKey(new Point(x + 1, y))) {
						_map.put(new Point(x, y), _map.get(new Point(x + 1, y)));
						_map.remove(new Point(x + 1, y));
						_isChanged = true;
					}

				}

			}
			if (x >= 3 && y < 3) {
				x = 0;
				y++;
			}

		}
		_view.update();
	}

	public void moveDown() {
		int y = 3;
		int x = 0;
		for (int t = 0; t < 4; t++) {
			for (int j = 0; j < 4; j++) {
				for (y = 3; y > 0; y--) {
					if (!_map.containsKey(new Point(x, y))
							&& _map.containsKey(new Point(x, y - 1))) {
						_map.put(new Point(x, y), _map.get(new Point(x, y - 1)));
						_map.remove(new Point(x, y - 1));
						_isChanged = true;
					}
				}
			}
			if (y <= 0 && x < 3) {
				y = 3;
				x++;
			}
		}
		_view.update();
	}

	public void moveUp() {
		int y = 0;
		int x = 0;
		for (int t = 0; t < 4; t++) {
			for (int j = 0; j < 4; j++) {
				for (y = 0; y < 3; y++) {
					if (!_map.containsKey(new Point(x, y))
							&& _map.containsKey(new Point(x, y + 1))) {
						_map.put(new Point(x, y), _map.get(new Point(x, y + 1)));
						_map.remove(new Point(x, y + 1));
						_isChanged = true;
					}
				}
			}
			if (x < 3 && y >= 3) {
				x++;
				y = 0;
			}
		}
		_view.update();
	}

	public void addTR() {
		// add them together AND move it to the right
		int x = 3;
		int y = 0;
		while (x > 0) {
			if (_map.containsKey(new Point(x, y))
					&& _map.containsKey(new Point(x - 1, y))
					&& _map.get(new Point(x, y)).equals(
							_map.get(new Point(x - 1, y)))) {
				int value = _map.get(new Point(x, y)) * 2;
				_map.put(new Point(x, y), value);
				_score = _score + value;
				// System.out.println("remove(" + t + ",0)");
				_map.remove(new Point(x - 1, y));
				_isChanged = true;

			}
			x--;
			if (x <= 0 && y < 3) {
				x = 3;
				y++;
			}
		}
		this.moveRight();
		_view.update();
	}

	public void addTT() {
		// add them together AND move it to the right
		int x = 0;
		int y = 0;
		while (x < 3) {
			if (_map.containsKey(new Point(x, y))
					&& _map.containsKey(new Point(x + 1, y))
					&& _map.get(new Point(x, y)).equals(
							_map.get(new Point(x + 1, y)))) {
				int value = _map.get(new Point(x, y)) * 2;
				_map.put(new Point(x, y), value);
				_score = _score + value;

				// System.out.println("remove(" + a + ",0)");
				_map.remove(new Point(x + 1, y));
				_isChanged = true;
			}
			x++;
			if (x >= 3 && y < 3) {
				x = 0;
				y++;
			}
		}
		this.moveLeft();
		_view.update();
	}

	public void addTU() {
		int x = 0;
		int y = 0;
		while (y < 3) {
			if (_map.containsKey(new Point(x, y))
					&& _map.containsKey(new Point(x, y + 1))
					&& _map.get(new Point(x, y)).equals(
							_map.get(new Point(x, y + 1)))) {
				int value = _map.get(new Point(x, y)) * 2;
				_score = _score + value;

				_map.put(new Point(x, y), value);
				_map.remove(new Point(x, y + 1));
				_isChanged = true;
			}
			y++;
			if (y >= 3 && x < 3) {
				y = 0;
				x++;
			}

		}
		this.moveUp();
		_view.update();
	}

	public void addTD() {
		int x = 0;
		int y = 3;
		while (y > 0) {
			if (_map.containsKey(new Point(x, y))
					&& _map.containsKey(new Point(x, y - 1))
					&& _map.get(new Point(x, y)).equals(
							_map.get(new Point(x, y - 1)))) {
				int value = _map.get(new Point(x, y)) * 2;
				_score = _score + value;

				_map.put(new Point(x, y), value);
				_map.remove(new Point(x, y - 1));
				_isChanged = true;
			}
			y--;
			if (y <= 0 && x < 3) {
				y = 3;
				x++;
			}
		}
		this.moveDown();
		_view.update();
	}

	public void randomizePosition() {
		// add 2 to a random tile
		int x = 0;
		int y = 0;
		ArrayList<Point> list = new ArrayList<Point>();

		while (x < 4) {
			System.out.println("** _map is " + _map);
			if (!_map.containsKey(new Point(x, y))) {
				list.add(new Point(x, y));
			}
			x++;
			if (x >= 4 && y < 3) {
				x = 0;
				y++;
			}
		}
		System.out.println("the list has " + list.size() + " items is it");
		if (list.size() == 0) {
			System.out.println(" Game Over! ");
		} else {
			Collections.shuffle(list);
			_map.put(list.get(0), 2);
		}
		_view.update();
		list.clear();
	}

	public void ran() {
		if (_isChanged) {
			this.randomizePosition();
		}
	}
	public void reset(){
			_map.clear();
			_score =0;
			this.ran();	
	}
	public String getData(int x, int y) {
		if (_map.containsKey(new Point(x, y))) {
			return _map.get(new Point(x, y)) + "";
		} else {
			return "";
		}
	}

	public String getScore() {
		return _score + "";

	}

	public void addView(MyView view) {
		_view = view;
	}

}