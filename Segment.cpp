/*
	nxhuy564@gmail.com, 0903203800
	phanthanh.trang200@gmail.com
	Name: SEGMENT.CPP
	Copyright: 2020
	Author: Cppfan or others 	
	Description:
	Given n positive numbers a[0..n-1].
	Find a shorted segment (i,j) with the sum a[i..j] = k
*/
#include <iostream>
#include <string.h>
#include <cmath>
using namespace std;

const int MN = 200;
int a[MN+1] = {10, 1, 2, 7, 10, 5, 2, 3, 9, 1, 10};
int n = 12;
int k = 10;
int s[MN+1]; // s[0] = 0, s[1] = s[0]+a[0], ... s[i] = s[i-1]+a[i]

void Go() {
  cout << " ? " ;
  fflush(stdin);
  if (cin.get() == '.') exit(0);
} // Go

void Print(int x[], int n, const char * msg = "") {
	cout << msg;
	for (int i = 0; i < n; ++i) {
		cout << " " << i << ":" << x[i];
	} // for
} // Print

void Ver2() { // Using Sliding Window O(N)
  Print(a, n, "\n Sliding Window a: ");
  int L, R;
  int sum;
  L = R = 0;
  sum = a[0];
  while (1) {
  	if (sum == k) { // enought
  		cout << "\n ** Found a segment " << L << " .. " << R; 
  		// Nha phan tu trai
  		sum -= a[L]; 
  		if (L < n) ++L;
  	}
  	else if (sum < k) { // doi
  	  if (R < n) sum += a[++R];
  	  else break; // thoat
	}
  	else { // no
	  sum -= a[L];
	  if (L < n) ++L;
	  else break;  // thoat
	}
  } // while
} // Ver2

int Search(int x, int n) {
  int d = 0, c = n;
  while (d < c) {
     int m = (d+c) / 2;
     if (s[m] < x) d = m+1;
     else c = m;
  }
  return (s[d] == x) ? d : -1;
} // earch

void Ver1() { // Version 1: Using s
	// s ?
  s[0] = 0;
  for (int i = 0; i < n; ++i) {
  		s[i+1] = s[i] + a[i];
  } 
  Print(a, n, "\n Ver.1: Using s,  a: ");
  Print(s, n+1, "\n s: ");
  for (int i = 0; i <= n; ++i) {
     int j = Search(s[i]+k, n);
     if (j >= 0) {
     	cout << "\n * Found a segment " << i << " .. " << j-1; 
     }
  } // for
} // Ver1


void Run() {
  Ver1();
  cout << "\n -----------------------"; 
  Ver2();
} // Run

main() {
	Run();
	cout << "\n T h e   E n d";
	return 0;
}



