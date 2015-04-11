#include <iostream>
#include <iomanip>
#include "staQue.h"
using namespace std;

int main() {
 staQue list;
 list.insert(1);
 list.insert(3);
 list.insert(2);
 list.insert(4);
 list.insert(6);
 list.insert(8);
 list.insert(9);
 cout << setw(15);
 cout << "=====" << "Test1" << "====" << "\n";
 cout << setw(12);
 list.printQue();
 cout << "[+] First remove from FRONT: " << list.popFront() << "\n";
 cout << "[+] Second remove from FRONT: " << list.popFront() << "\n";
 cout << "[+] Third remove from BACK: " << list.popBack() << "\n";
 cout << endl;

 staQue list1;
 list1.insert(2);
 list1.insert(51);
 list1.insert(100);
 list1.insert(191);
 list1.insert(1337);
 cout << setw(15);
 cout << "=====" << "Test2" << "====" <<"\n";
 cout << setw(11);
 list1.printQue();
 cout << "[+] First remove from FRONT: " << list1.popFront() << "\n";
 cout << "[+] Second remove from BACK: " << list1.popBack() << "\n";
 cout << "[+] Third remove from BACK: " << list1.popBack() << "\n";
 cout << endl;
 
 staQue list2;
 list2.insert(20);
 list2.insert(49);
 list2.insert(30);
 list2.insert(93);
 cout << setw(15);
 cout << "=====" << "Test3" << "====" <<"\n";
 cout << setw(13);
 list2.printQue();
 cout << "[+] First remove from FRONT: " << list2.popFront() << "\n";
 cout << "[+] Second remove from FRONT: " << list2.popFront() << "\n";
 cout << "[+] Third remove from FRONT: " << list2.popFront() << "\n";
 cout << endl;
 
 staQue list3;
 list3.insert(80);
 list3.insert(9);
 list3.insert(343);
 list3.insert(23);
 cout << setw(15);
 cout << "=====" << "Test4" << "====" <<"\n";
 cout << setw(13);
 list3.printQue();
 cout << "[+] First remove from BACK: " << list3.popBack() << "\n";
 cout << "[+] Second remove from BACK: " << list3.popBack() << "\n";
 cout << "[+] Third remove from BACK: " << list3.popBack() << "\n";
 cout << endl;
 


 return 1;
}


