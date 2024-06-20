import java.util.Stack;

public class BinarySearchTree {
	private Node root;
	 public BinarySearchTree()
	 {
		 root=null;
	 }
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	 
	 public boolean insert(int data)
	 {
		 Node newNode=new Node(data);
		 if(newNode==null)
		 {
			 return false;
		 }
		 if(root==null)
		 {
			 root=newNode;
			 return true;
		 }
		 Node temp=root;
		 while(true)
		 {
			if(data<temp.getData())
			{
				if(temp.getLeft()==null)
				{
					temp.setLeft(newNode);
					return true;
				}
				temp=temp.getLeft();
			}
			else
			{
				if(temp.getRight()==null)
				{
					temp.setRight(newNode);
					return true;
				}
				temp=temp.getRight();
			}
		 }
	 }
	 public void preOrder()
	 {
		 System.out.println("PreOrder: ");
		 Stack<Node> stack=new Stack<>();
		 Node temp=root;
		 while(temp!=null || !stack.empty())
		 {
			 while(temp!=null)
			 {
				 System.out.print(temp.getData()+" ");
				 stack.push(temp);
				 temp=temp.getLeft();
			 }
			 temp = stack.pop().getRight();
		 }
		 System.out.println();
	 }
	 
	 public void inOrder()
	 {
		 System.out.println("InOrder: ");
		 Stack<Node> stack=new Stack<>();
		 Node temp=root;
		 while(temp!=null || !stack.empty())
		 {
			 while(temp!=null)
			 {
				 stack.push(temp);
				 temp=temp.getLeft();
			 }
			 temp = stack.pop();
			 System.out.print(temp.getData()+" ");
			 temp=temp.getRight();
		 }
	 }
	 
	 public void postOrder()
	 {
		 System.out.println("PostOrder: ");
		 class Pair{
			 Node node;
			 char flag;
			 
			 public Pair(Node node,char flag)
			 {
				 this.node=node;
				 this.flag=flag;
			 }
		 }
		 
		 Stack<Pair> stack=new Stack<>();
		 Node temp=root;
		 
		 while(temp!=null || !stack.empty())
		 {
			 while(temp!=null)
			 {
				 stack.push(new Pair(temp,'l'));
				 temp=temp.getLeft();
			 }
			Pair pair=stack.pop();
			if(pair.flag== 'l')
			{
				temp=pair.node.getRight();
				pair.flag='r';
				stack.push(pair);
			}
			else
			{
				System.out.print(pair.node.getData()+" ");
			}
		 }
	 }

}
