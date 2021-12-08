#include <iostream>
#include <set>

using namespace std;

int main() {
    int T, num;
    set<int> nums;

    cin >> T;
    while (T--) {
        cin >> num;
        nums.insert(num);
    }

    for(auto num : nums) cout << num << " ";

    return 0;
}