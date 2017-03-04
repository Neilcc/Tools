那个 clever 方法， 精髓在于用递归栈的形参保存了易失性的递归path，不用像我那样，自己维护一个array
Given a binary tree, return all root-to-leaf paths.


For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]


solve:

mine :

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ArrayList<Integer> checked = new ArrayList<>();
    List<String> output = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null ){
            return output;
        }
        checked.add(root.val);
        if(root.left == null && root.right == null){
            print();
            checked.remove(checked.size()-1);
            return output;
        }
        if(root.left != null) binaryTreePaths(root.left);
        if(root.right != null) binaryTreePaths(root.right);
        checked.remove(checked.size()-1);
        return output;
    }
    
    
    public void print(){
        String aa="";
        for(int i = 0 ; i < checked.size(); i ++){
            if(i == 0){
                aa += checked.get(i);
            }else{
                aa+="->" + checked.get(i);
            }
        }
        output.add(aa);
    }
}


```

clever one :

```java
public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) searchBT(root, "", answer);
    return answer;
}
private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null) answer.add(path + root.val);
    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
}
```
