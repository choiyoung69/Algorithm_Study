//큐를 이용해서 풀었음(BFS)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode a = q.poll();
            if(a == null) continue;
            TreeNode tmp = a.left;
            if(a.right != null) {
                a.left = a.right;
                q.add(a.left);
            } 
            else a.left = null;
            
            if(tmp != null) {
                a.right = tmp;
                q.add(a.right);
            } else a.right = null;
            
        }
        
        return root;
    }
}

//같은 방식이긴 한데 재귀로 푸는 방법이 있죠. Queue 안쓰고 재귀로 풀기
//훨씬 직관적임
//but 깊어질수록 stack overflow 생길 수 있음(DFS)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
