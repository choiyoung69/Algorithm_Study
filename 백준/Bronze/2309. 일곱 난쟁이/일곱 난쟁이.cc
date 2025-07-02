#include<bits/stdc++.h>
using namespace std;
int tall[9];

int main() {
    int temp;
    for(int i = 0; i < 9; i++){
        cin >> temp;
        tall[i] = temp;
    }
    
    sort(tall, tall + 9);
    int sum;
    do{
        sum = 0;
        for(int i = 0; i < 7; i++){
            sum += tall[i];
        }
        if(sum == 100){
            for(int i = 0; i < 7; i++){
                cout << tall[i] << '\n';
            }
            break;
        }
    }while(next_permutation(tall, tall + 9));
}