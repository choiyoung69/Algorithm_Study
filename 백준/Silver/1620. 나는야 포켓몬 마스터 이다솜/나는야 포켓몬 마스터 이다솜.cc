#include<bits/stdc++.h>
using namespace std;
int N, M;
map<string, int> names;
map<int, string> namesNumber;
string temp, answer;
int ret;

int main(){
    cin >> N >> M;
    
    for(int i = 1; i <= N; i++){
        cin >> temp;
        names.insert({temp, i});
        namesNumber.insert({i, temp});
    }
    
    for(int i = 0; i < M; i++){
        cin >> temp;
        ret = atoi(temp.c_str());
        if(ret) answer += namesNumber[ret] + "\n";
        else answer += to_string(names[temp]) + "\n";
    }
    cout << answer;
}