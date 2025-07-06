#include<bits/stdc++.h>
using namespace std;
int N, cnt;
string s;

int main(){
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> s;
        stack<char> stk;
        for(char ch : s) {
            if(!stk.empty() && stk.top() == ch) stk.pop();
            else stk.push(ch);
        }
        if(stk.size() == 0) cnt++;
    }
    cout << cnt;
}