#include <bits/stdc++.h>
using namespace std;
int N, K, maxValue, preValue;

int main(){
    cin >> N;
    cin >> K;
    
    int arr[N];
    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }
    
    for(int i = 0; i < K; i++){
        preValue += arr[i];
    }

    maxValue = preValue;
    
    for(int i = 0; i < N - K; i++){
        int currentValue = preValue - arr[i] + arr[K + i];
        if(maxValue < currentValue) maxValue = currentValue;
        preValue = currentValue;
    }
    
    cout << maxValue;
}