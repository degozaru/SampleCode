class TreeNode {
  friend BST;
  public:
    TreeNode();
    TreeNode(int value, TreeNode* leftNode, TreeNode* rightNode);
    int getItem() const;

  private:
    int i;
    TreeNode *left, *right;
}; //End TreeNode

TreeNode::TreeNode() {
  i = 0;
  left = 0;
  right = 0;
} //End Constructor
TreeNode::TreeNode(int value, TreeNode* leftNode, TreeNode* rightNode) {
  i = value;
  left = leftNode;
  right = rightNode;
} //End Constructor

int TreeNode::getItem() const {
  return i;
} //End getItem

