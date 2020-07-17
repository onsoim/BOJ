#include <iostream>
#include <queue>

using namespace std;

int main() {
    int N, K;
    queue<int> josephus;

    cin >> N >> K;
    for (int i = 0; i < N; i++) {
        josephus.push(i+1);
    }

    cout << "<";
    while (josephus.size() - 1) {
        for (int i = 0; i < K - 1; i++) {
            josephus.push(josephus.front());
            josephus.pop();
        }
        cout << josephus.front() << ", ";
        josephus.pop();
    }
    cout << josephus.front() << ">";
    return 0;
}