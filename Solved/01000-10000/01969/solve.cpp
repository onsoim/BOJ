#include <iostream>
#include <string>

using namespace std;

int main() {
    int N, M;
    string dna;
    int s[5][1000] = {0, }, hamming = 0;

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> dna;
        for (int j = 0; j < M; j++)
            switch(dna[j]) {
                case 'A':
                    s[0][j]++;
                    s[4][j] = s[s[4][j]][j] > s[0][j] ? s[4][j] : 0;
                    break;
                case 'C':
                    s[1][j]++;
                    if (s[s[4][j]][j] == s[1][j] && s[4][j] > 1) s[4][j] = 1;
                    else s[4][j] = s[s[4][j]][j] >= s[1][j] ? s[4][j] : 1;
                    break;
                case 'G':
                    s[2][j]++;
                    if (s[s[4][j]][j] == s[2][j] && s[4][j] > 2) s[4][j] = 2;
                    else s[4][j] = s[s[4][j]][j] >= s[2][j] ? s[4][j] : 2;
                    break;
                case 'T':
                    s[3][j]++;
                    s[4][j] = s[s[4][j]][j] >= s[3][j] ? s[4][j] : 3;
                    break;
            }
    }

    for (int i = 0; i < M; i++) {
        hamming += N - s[s[4][i]][i];
        switch(s[4][i]) {
            case 0:
                cout << 'A';
                break;
            case 1:
                cout << 'C';
                break;
            case 2:
                cout << 'G';
                break;
            case 3:
                cout << 'T';
                break;
        }
    }
    cout << "\n" << hamming;

    return 0;
}