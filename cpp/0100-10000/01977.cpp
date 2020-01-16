#include <iostream>

using namespace std;

int main() {
    int N, M;
    int i, n, m;
    int min, sum = 0;
    
    cin >> N >> M;
    
    i = 1;
    while (i * i < N) i++;
    n = i, i = 1, min = n * n;
    
    while (i * i <= M) i++;
    m = i;
    
    for (i = n; i < m; i++) sum += i * i;
    
    if (sum) cout << sum << "\n" << min;        
    else cout << "-1";
    
    return 0;
}