#include <iostream>
#include "staQue.h"

void staQue::insert(int data) {
  (data%2)?addBack(data) : addFront(data);
} //End staQueue

void staQue::addFront(int data) {
  Node *newData = new Node;
  newData->data = data;
  newData->prev = newData->next = 0;
  if(size==0) head = tail = newData;
  else {
    head->prev = newData;
    newData->next = head;
    head = newData;
  }
  size++;
} //End addFront()

void staQue::addBack(int data) {
  Node *newData = new Node;
  newData->data = data;
  newData->prev = newData->next = 0;
  if(size==0) head = tail = newData;
  else {
    tail->next = newData;
    newData->prev = tail;
    tail = newData;
  }
  size++;
} //End addBack()

int staQue::popFront() {
  if(size==0) return 0;
  int temp = head->data;
  Node *toDel = head;
  head = head->next;
  head->prev = 0;
  size--;
  delete toDel;
  return temp;
} //End popFront()

int staQue::popBack() {
  if(size==0) return 0;
  int temp = tail->data;
  Node *toDel = tail;
  tail = tail->prev;
  tail->next = 0;
  size--;
  delete toDel;
  return temp;
} //End popBack()

void staQue::printQue() {
  staQue::print(staQue::head);
} //End printQue()

void staQue::print(Node* node) {
  if(node==0) {
    std::cout << std::endl;
    return;
  }
  int temp = node->data;
  std::cout << temp << " ";
  staQue::print(node->next);
} //End print()

  
  


