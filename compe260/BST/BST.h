#include <iostream>
#include "TreeNode.h"

#ifndef BST_H
#define BST_H
class BST {
  public:
    BST();
    bool insert(int i);
    bool remove(int i);
    bool search(int i);
    std::ostream& travInOrder(std::ostream &out) ;
    std::ostream& travPreOrder(std::ostream &out) ;
    std::ostream& travPostOrder(std::ostream &out) ;

  private:
    TreeNode* root;
    int findMin(TreeNode* toFind);
    std::ostream& preOrder(std::ostream &out, TreeNode* cur) ;
    std::ostream& inOrder(std::ostream &out, TreeNode* cur) ;
    std::ostream& postOrder(std::ostream &out, TreeNode* cur) ;
    bool searchNode(TreeNode* cur, int i);

};
#endif
