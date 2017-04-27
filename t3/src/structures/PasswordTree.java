package structures;

import java.util.ArrayList;
import presenter.LoginPresenter;

public class PasswordTree {
	private Node _root;
	private LoginPresenter _presenter;

	public PasswordTree(LoginPresenter presenter){
		_root = new Node("");
		_presenter = presenter;
	}

	public void populate(ArrayList<Pair<String, String>> values){
		insertValues(_root, values, 0);
	}
	
	private void insertValues(Node node, ArrayList<Pair<String, String>> values, int pos) {	
		if (node == null || pos == values.size())
			return;

		node.left = new Node(values.get(pos).first);
		node.right = new Node(values.get(pos).second);
		
		pos++;
		
		insertValues(node.left, values, pos);
		insertValues(node.right, values, pos);
	}

	public boolean passwordDepthSearch() {
		return passwordDepthSearch(_root, new String());
	}

	private boolean passwordDepthSearch(Node node, String auxString) {
		if (node == null)
			return false;

		auxString += node.data;

		if (node.left == null && node.right == null) {
			return _presenter.validatePassword(auxString);
		} else {
			return passwordDepthSearch(node.left, auxString) | passwordDepthSearch(node.right, auxString);
		}
	}
}