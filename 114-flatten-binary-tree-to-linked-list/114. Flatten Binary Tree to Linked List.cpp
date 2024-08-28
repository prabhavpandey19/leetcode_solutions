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
 void flatten(TreeNode* root) {
    if (!root) return;
    TreeNode* prev = getPrev(root);
    if (prev){
        prev->right = root->right;
        root->right = root->left;
        root->left = NULL;
    }
    flatten(root->right);
}
TreeNode* getPrev(TreeNode* node){
    if (!node->left) return NULL;
    node = node->left;
    while (node->right) node = node->right;
    return node;
}};