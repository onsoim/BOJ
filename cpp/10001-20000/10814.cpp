#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    vector<pair<int,pair<int,string>>> user;
    int N, age;
    string name;

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> age >> name;
        user.push_back({age, {i, name}});
    }
    sort(user.begin(), user.end());
    
    for (auto i:user) cout << i.first << " " << i.second.second << "\n";
    return 0;
}