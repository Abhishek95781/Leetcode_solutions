/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result ;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ans = new ArrayList<>(Collections.nCopies(size,0));

            for(int i = 0;i<size ;i++){
                
                TreeNode node = q.poll();
                // 3
                int index = leftToRight ? i : size - i -1;
                ans.set(index , node.val);

                if(node.left != null){
                    q.offer(node.left);

                }
                if(node.right != null){
                    q.offer(node.right);
                }
                

            }
            result.add(ans);
                leftToRight = !leftToRight;
            

        }
        return result;
    }
}





// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();

//         if (root == null) return result;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);

//         boolean leftToRight = true;

//         while (!q.isEmpty()) {
//             int size = q.size();
//             List<Integer> list = new ArrayList<>(Collections.nCopies(size, 0));

//             for (int i = 0; i < size; i++) {
//                 TreeNode node = q.poll();

//                 int index = leftToRight ? i : size - 1 - i;
//                 list.set(index, node.val);

//                 // Use node, not root
//                 if (node.left != null) {
//                     q.offer(node.left);
//                 }

//                 if (node.right != null) {
//                     q.offer(node.right);
//                 }
//             }

//             result.add(list);
//             leftToRight = !leftToRight;
//         }

//         return result;
//     }
// }



