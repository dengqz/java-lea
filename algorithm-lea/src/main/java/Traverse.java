import java.util.Stack;

public class Traverse {
	static class TreeNode{
		public TreeNode(int val){
			this.val=val;
		}
		private int val;
		private TreeNode left;
		private TreeNode right;
		public void setLeft(TreeNode node){
			this.left=node;
		}
		public void setRight(TreeNode node){
			this.right=node;
		}
	}

	public static void  preOrderTraverse(TreeNode root){
		if(root!=null){
			System.out.print(root.val+" ");
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);
		}
	}
	public static void preOrderTraverse1(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pNode=root;
		while(pNode!=null || !stack.isEmpty()){
			if(pNode!=null){
				System.out.print(pNode.val+" ");
				stack.push(pNode);
				pNode=pNode.left;
			}else {
				TreeNode node=stack.pop();
				pNode=node.right;
			}
		}
	}
	public static void inOrderTraverse(TreeNode root){
		if(root!=null){
			inOrderTraverse(root.left);
			System.out.print(root.val+" ");
			inOrderTraverse(root.right);
		}
	}
	public static void inOrderTraverse1(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pNode=root;
		while(pNode!=null||!stack.isEmpty()){
			if(pNode!=null){
				stack.push(pNode);
				pNode=pNode.left;
			}else{
				TreeNode node=stack.pop();
				System.out.print(node.val+" ");
				pNode=node.right;
			}
		}
	}
	public static void postOrderTraverse(TreeNode root){
		if(root!=null){
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
			System.out.print(root.val+ " ");
		}
	}
	public static void postOrderTraverse1(TreeNode root){
		if (root != null) {
			Stack<TreeNode> s1 = new Stack<>();
			Stack<TreeNode> s2 = new Stack<>();
			s1.push(root);
			while (!s1.isEmpty()) {
				root = s1.pop();
				s2.push(root);
				if (root.left != null) {
					s1.push(root.left);
				}
				if (root.right != null) {
					s1.push(root.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().val + " ");
			}
		}
	}

	public static void main(String[] args) {
		TreeNode a1 = new TreeNode(1);
		TreeNode a2= new TreeNode(2);
		TreeNode a3= new TreeNode(3);
		TreeNode a4= new TreeNode(4);
		TreeNode a5= new TreeNode(5);
		TreeNode a6= new TreeNode(6);
		TreeNode a7= new TreeNode(7);
		a1.setLeft(a2);
		a1.setRight(a3);
		a2.setLeft(a4);
		a2.setRight(a5);
		a3.setLeft(a6);
		a4.setRight(a7);

		preOrderTraverse(a1);
		System.out.println();
		inOrderTraverse(a1);
		System.out.println();
		postOrderTraverse(a1);
		System.out.println();
		preOrderTraverse1(a1);
		System.out.println();
		inOrderTraverse1(a1);
		System.out.println();
		postOrderTraverse1(a1);

	}
}
