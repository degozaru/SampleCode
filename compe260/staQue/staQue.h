#ifndef STAQUE_H
#define STAQUE_H
class staQue {
  private:
    class Node {
      public: 
        int data;
        Node *next, *prev;
    };
  
  public:
    Node *head;
    Node *tail;
    int size;

    //Constructor
    staQue() {
      size = 0;
    } //End constructor

    //Insert.
    void insert(int data);
    //Pop from the front
    int popFront();
    //Pop from the back
    int popBack();
    //Print the queue
    void printQue();

  private:
    //Insert front
    void addFront(int data);
    //Insert back
    void addBack(int data);
    //The printing function
    void print(Node*);
}; //End staQue
#endif
