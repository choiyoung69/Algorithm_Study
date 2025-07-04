#include <bits/stdc++.h>
using namespace std;
int N;
string in, s, e, line;
string st, ed;

int main(){
    cin >> N;
    cin >> in;
    
    int split = in.find("*");
    st = in.substr(0, split);
    ed = in.substr(split + 1);
    
    string answer;
    for(int i = 0; i < N; i++){
        cin >> line;
        if(line.size() < st.size() + ed.size()){
            answer += "NE\n";
            continue;
        }
        if(st != line.substr(0, st.size())) {
            answer += "NE\n";
            continue;
        }
        if(ed != line.substr(line.size() - ed.size())) {
            answer += "NE\n";
            continue;
        }
        answer += "DA\n";
    }
    cout << answer;
}