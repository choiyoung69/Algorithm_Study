#include<bits/stdc++.h>
using namespace std;

int main(){
    int alpha[26] = {0, };
    string S;
    
    cin >> S;
    for(char ch : S){
        alpha[ch - 'a']++;
    }
    
    for(int i : alpha){
        cout << i << ' ';
    }
}