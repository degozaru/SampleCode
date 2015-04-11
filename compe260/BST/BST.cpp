#include <iostream>
#include "BST.h"

/**Constructor**/
BST::BST() :
  root(0)
{}
/**End constructor**/

//Inserts a node into the bst
bool BST::insert(int i) {
  if(root==0) {
    root = new TreeNode(i,0,0);
    return true;
  }
  TreeNode* current = root;
  TreeNode* previous = 0;
  while(current!=0) {
    if(i==current->getItem()) return false; 
    previous = current;
    if(i>current->getItem()) current = current->rChild;
    else current = current->lChild;
  }
  if(i>previous->getItem()) previous->rChild = new TreeNode(i,0,0);
  else previous->lChild = new TreeNode(i,0,0);
  return true;
} //End insert()

bool BST::remove(int i) {
  if(!search(i)) return false;
  TreeNode* previous = 0;
  TreeNode* current = root;
  while(current->getItem()!=i) {
    previous = current;
    current = (current->getItem()>i)?current->lChild : current->rChild;
  }
  //Case 1: leaf node
  if(current->lChild==0 && current->rChild==0) {
    if(previous==0) root = 0;
    else if (i<previous->getItem())
      previous->lChild=0;
    else previous->rChild=0;
    delete current;
  }
  //Case 2: one child
  else if(current->lChild==0) {
    if(previous==0) root = current->rChild;
    else if (i<previous->getItem())
      previous->lChild=current->rChild;
    else previous->rChild=current->rChild;
    delete current;
  }
  else if(current->rChild==0) {
    if(previous==0) root = current->lChild;
    else if (i<previous->getItem())
      previous->lChild=current->lChild;
    else previous->rChild=current->rChild;
    delete current;
  }
  else {
    int min = BST::findMin(current);
    BST::remove(min);
    current->item = min;
  }
  return true;
} //End remove()

//aux function for remove()
int BST::findMin(TreeNode* toFind) {
  TreeNode* current = toFind->rChild;
  while(current->lChild!=0) current = current->lChild;
  return current->getItem();
} //End findMin()

//Returns true if the object is in the tree
bool BST::search(int i) {
  return BST::searchNode(root, i);
} //End search()
bool BST::searchNode(TreeNode* cur, int i) {
  if(cur==0) return false;
  if(cur->getItem()==i) return true;
  if(cur->getItem()>i) 
    return BST::searchNode(cur->lChild, i);
  else return BST::searchNode(cur->rChild, i);
}
  

std::ostream& BST::travInOrder(std::ostream &out) {
  return BST::inOrder(out, root) << std::endl;
}
std::ostream& BST::travPreOrder(std::ostream &out) {
  return BST::preOrder(out, root) << std::endl;
}
std::ostream& BST::travPostOrder(std::ostream &out) {
  return BST::postOrder(out, root) << std::endl;
}

std::ostream& BST::preOrder(std::ostream &out, TreeNode* cur) {
  if(cur==0) return out;
  out << " " << cur->getItem();
  BST::preOrder(out, cur->lChild);
  BST::preOrder(out, cur->rChild);
  return out;
}
std::ostream& BST::inOrder(std::ostream &out, TreeNode* cur) {
  if(cur==0) return out;
  BST::inOrder(out, cur->lChild);
  out << " " << cur->getItem();
  BST::inOrder(out, cur->rChild);
  return out;
}
std::ostream& BST::postOrder(std::ostream &out, TreeNode* cur) {
  if(cur==0) return out;
  BST::postOrder(out, cur->lChild);
  BST::postOrder(out, cur->rChild);
  out << " " << cur->getItem();
  return out;
}
