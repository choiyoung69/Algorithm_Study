#include<bits/stdc++.h>
using namespace std;
int T, N, sum;
map<string, int> mp;
string name, type;

int main(){
    cin >> T;
    for(int i = 0; i < T; i++){
        cin >> N;
        for(int j = 0; j < N; j++){
            cin >> name >> type;
            mp[type]++;
        }
        sum = 1;
        for(auto it : mp){
            sum *= (it.second + 1);
        }
        mp.clear();
        cout << sum - 1 << "\n";
    }
}