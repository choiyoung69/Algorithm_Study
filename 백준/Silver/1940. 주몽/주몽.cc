#include<bits/stdc++.h>
using namespace std;
int N, M, temp, answer;
int arr[100001];

int main(){
    cin >> N >> M;
    for(int i = 0; i < N; i++){
        cin >> temp;
        arr[temp]++;
    }
    
    if(M > 200000) cout << "0";
    else{
        for(int i = 0; i <= M/2; i++) {
            if(i == M - i) {
                answer += arr[i] * (arr[i] - 1)/2;
            }
            else {
                answer += arr[i] * arr[M - i];
            }
        }
        cout << answer;
    }
    
}