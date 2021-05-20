#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> height;
    int buf = 0, sum = 0;

    for (int i = 0; i < 9; i++) {
        cin >> buf;
        height.push_back(buf);
    }

    for (int i = 0; i < 8; i++)
        for (int j = i + 1; j < 9; j++) {
            sum = 0;
            for (int k = 0; k < 9; k++)
                if (k != i && k != j) sum += height[k];
                
            if (sum == 100) {
                height.erase(height.begin() + j);
                height.erase(height.begin() + i);
                sort(height.begin(), height.end());

                for (auto h : height) cout << h << "\n";
                return 0;
            }
        }

    return 0;
}