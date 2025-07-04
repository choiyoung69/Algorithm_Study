#include<bits/stdc++.h>
using namespace std;
string s;

int main(){
    getline(cin, s);
    
    for(int i = 0; i < s.size(); i++){
        if(isupper(s[i])){
            s[i] = (s[i] + 13 - 'A') % 26 + 'A';
        } else if(islower(s[i])){
            s[i] = (s[i] + 13 - 'a') % 26 + 'a';
        }
    }
    
    cout << s;
}