#include<bits/stdc++.h>
using namespace std;
int alpha[26];
string answer;
int members;

int main(){
    cin >> members;
    string temp;
    for(int i = 0; i < members; i++){
        cin >> temp;
        alpha[temp[0] - 'a']++;
    }
    
    for(int i = 0; i < 26; i++){
        if(alpha[i] >= 5) answer += (char)(i + 'a');
    }
    
    if(answer.size() == 0) cout << "PREDAJA";
    else cout << answer;
}