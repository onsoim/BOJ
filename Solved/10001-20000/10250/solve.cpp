#include <iostream>

using namespace std;

int main() {
    int T, H, W, N;
    int h, w;
    
    cin >> T;
    while (T--) {
        cin >> H >> W >> N;
        
        w = N / H;
        N % H ? h = N % H, w += 1 : h = H;
        
        cout << h;
        if (w < 10) cout << "0";
        cout << w << "\n";
    }
    
    return 0;
}