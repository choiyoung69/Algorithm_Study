#include<bits/stdc++.h>
using namespace std;
int cars[101];

int main(){
    int a,b,c;
    cin >> a >> b >> c;
    
    int start, end;
    for(int i = 0; i < 3; i++){
        cin >> start >> end;
        for(int j = start; j < end; j++){
            cars[j]++;
        }
    }
    
    int sum = 0;
    for(int i : cars){
        if(i == 1) {
            sum += a;
        }
        else if(i == 2) {
            sum += b * 2;
        }
        else if(i == 3) {
            sum += c * 3;
        }
    }
    
    cout << sum;
}