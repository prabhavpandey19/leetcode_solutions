/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
 
    int minDepth(TreeNode* node) {
         if(node==NULL)
            return 0;
        else{
            int lh=minDepth(node->left);
            int rh=minDepth(node->right);
            
            if(lh==0||rh==0)
                return max(lh,rh)+1;
            else
                return min(lh,rh)+1;
        }
    }
};