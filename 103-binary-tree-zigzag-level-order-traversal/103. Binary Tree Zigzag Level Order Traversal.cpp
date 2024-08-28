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
    int height(TreeNode* node){
        if(node==NULL)
            return 0;
        else{
            int lh=height(node->left);
            int rh=height(node->right);
            
            if(lh>rh)
                return lh+1;
            else
                return rh+1;
        }
    }
    void level(TreeNode* root,int l,vector<int>&v){
        if(root==NULL)
            return;
        if(l==1)
            v.push_back(root->val);
        else if(l>1){
            
                level(root->left,l-1,v);
                level(root->right,l-1,v);
            
        }
        
    }
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> t;
        int h=height(root);
        for(int i=1;i<=h;i++){
            vector<int> x;
            level(root,i,x);
            t.push_back(x);
        }
        for(int i=1;i<t.size();i=i+2){
            reverse(t[i].begin(),t[i].end());
       }
        return t;
    }
};