#include<bits/stdc++.h>
using namespace std;

int main() {
    int length[9];
    int temp;
    for(int i = 0; i < 9; i++){
        cin >> temp;
        length[i] = temp;
    }
    
    sort(length, length + 9);
    
    for(int i = 0; i < 3; i++){
        for(int j = 1; j < 4; j++){
            for(int k = 2; k < 5; k++){
                for(int l = 3; l < 6; l++){
                    for(int a = 4; a < 7; a++){
                        for(int b = 5; b < 8; b++){
                            for(int c = 6; c < 9; c++){
                                if(length[i] + length[j] + length[k] + length[l] + length[a] + length[b] + length[c] == 100){
                                    cout << length[i] << "\n" << length[j] << "\n"  << length[k] << "\n"  << length[l] << "\n" << length[a] << "\n" << length[b]  << "\n"  << length[c] << "\n";
                                    return 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}