class TreeNode {
  friend class BST;

  public:
    TreeNode();
    TreeNode(int i, TreeNode*R, TreeNode*L);
    int getItem() const;

  private:
    int item;
    TreeNode *lChild;
    TreeNode *rChild;
};

TreeNode::TreeNode() {
  lChild = rChild = NULL;
}

TreeNode::TreeNode(int i, TreeNode *L=0, TreeNode *R=0)
  : item(i), lChild(L), rChild(R) { }

int TreeNode::getItem() const {
  return item;
}







