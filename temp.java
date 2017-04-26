public class Node{
    String data;
    Node left, right;
  
    Node(String item) 
    {
        data = item;
        left = right = null;
    }
}
  
public class PasswordTree{
    private Node _root;
   	private User _user;

	public PasswordTree(Node root, User user){
		_root = root;
		_user = user;
	}
 
	public boolean passwordDepthSearch(){
		return passwordDepthSearch(_root, new String());
	}
 
	public boolean passwordDepthSearch(Node node, String auxString){
        if (node == null)
            return false;
  
        auxString += node.data;
  
        if(node.left == null && node.right == null){
			return user.validatePassword(auxString);
		}
        else{
            return passwordDepthSearch(node.left, auxString) | 
				   passwordDepthSearch(node.right, auxString);
        }
	}
}
