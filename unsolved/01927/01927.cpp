#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> heap = {};
    int N, x;

    make_heap(heap.begin(), heap.end());

    cin >> N;
    while (N--) {
        cin >> x;
        if (x) {
            heap.push_back(x);
            push_heap(heap.begin(), heap.end());
        }
        else if (heap.empty()) cout << "0\n";
        else {
            cout << heap.back() << "\n";
            heap.pop_back();
        }
    }
    return 0;
}