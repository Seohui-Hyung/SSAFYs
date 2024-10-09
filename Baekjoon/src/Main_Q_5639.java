import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_Q_5639 {
	static class Node {
		int n;
		
		Node left, right;
		
		Node(int n) {
			this.n = n;
		}
		
		// 노드 추가
		void addNode(int n) {
			if(n < this.n) {
				// 자식 노드 없으면 새로 생성
				if(this.left == null) {
					this.left = new Node(n);
				} else {
					this.left.addNode(n);
				}
			} else {
				// 자식 노드 없으면 새로 생성
				if(this.right == null) {
					this.right = new Node(n);
				} else {
					this.right.addNode(n);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String num;
		while((num = br.readLine()) != null) {
			root.addNode(Integer.parseInt(num));
		}
		
		postOrder(root);
	}

	// 후위 순회
	private static void postOrder(Node node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.n);
	}
}
