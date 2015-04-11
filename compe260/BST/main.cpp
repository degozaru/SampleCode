#include <iostream>
#include <stdlib.h>
#include "BST.cpp"
using namespace std;

int main() {
  BST* tree = new BST();
  srand (time(NULL));
  cout << "Testing insert, and inOrder Traversal" << endl;
  for(int i=0; i<20; i++) {
    int j = rand()%100;
    if(!tree->insert(j))
      cout<<"Unsuccessful addition: duplicate of " << j << endl;
  }

  cout << "testing inOrder transverse" << endl;
  tree->travInOrder(cout);
  cout << "testing preOrder traverse" << endl;
  tree->travPreOrder(cout);
  cout << "testing postOrder transverse" << endl;
  tree->travPostOrder(cout);

  cout << "Searching..." << "Found:" << endl;
  for(int i=0; i<=100; i++) 
    if(tree->search(i)) cout << " "<< i;
  cout << endl;
  cout << "Deleting... Deleted: " <<endl;
  for(int i=0; i<=100; i++) 
    if(tree->remove(i)) cout << " " << i;
  cout << endl;

  return 1;
}
