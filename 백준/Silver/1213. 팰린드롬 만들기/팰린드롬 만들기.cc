#include<bits/stdc++.h>
using namespace std;
map<char, int> mp;
string temp, answer, middle = "", reverseStr;

int main() {
    cin >> temp;
    for(int i = 0; i < temp.size(); i++){
        mp[temp[i]]++;
    }
    
    bool flag = false;
    for(auto it : mp) {
        if(temp.size() % 2 == 0) { //짝수라면
            if(it.second % 2 == 1) {
                cout << "I'm Sorry Hansoo";
                exit(0);
            }
            for(int i = 0; i < it.second/2; i++) answer += it.first;
        }
        else { //홀수 라인
            if(it.second % 2 == 1 && flag) {
                cout << "I'm Sorry Hansoo";
                exit(0);                   
            } 
            else if(it.second % 2 == 1 && !flag){
                flag = true;
                middle = it.first;
            }
            for(int i = 0; i < it.second / 2; i++) answer += it.first;
        }
    }
    reverseStr = answer;
    reverse(answer.begin(), answer.end());
    reverseStr = reverseStr + middle + answer;
    cout << reverseStr;
}