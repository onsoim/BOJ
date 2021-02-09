#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main() {
    int N;
    unsigned long long month[3] = {0,}, ac[2];
    double buf[4] = {0,}, res;

    // freopen("09307_02.in", "r", stdin); 
    cin >> buf[0];
    while ((int)buf[0] != -1) {
        cin >> buf[1] >> buf[2] >> N;
        for (int i = 0; i < 3; i++)
            month[i] = (int)(buf[i] * 100);
        if (N % 2) {
            ac[0] = month[2];
            ac[1] = month[0];
            res = month[2];
        }
        else {
            ac[0] = month[0];
            ac[1] = month[2];
            res = month[1];
        }
        // res = N % 2 ? buf[2] : buf[1];
        // buf[3] = buf[0] * buf[1] / buf[2];
        for (int i = 0; i < N / 2 - 1; i++) {
            // cout << "calc " << res << " " << ac[0] << " " << ac[1] << " " << res * ac[0] / ac[1] << endl;;
            res = round(res * ac[0] / ac[1]);
        }

        // for (int i = 0; i < N - 3; i++) {
        //     month[3] = month[0] * month[1] / month[2];
        //     // cout << buf[3] << endl;
        //     for (int j = 0; j < 3; j++) month[j] = month[j+1];
        // }
        cout << "Month " << N << " cost: $" << fixed << setprecision(2) << (N - 1 ? float(res) / 100 : buf[0]) << "\n";
        // cout << month[1] << " " << month[2] << " " << month[3] << endl;

        cin >> buf[0];
        // cin >> month[0] >> month[1] >> month[2] >> N;
        // cout << month[0] << month[1] << month[2] << N << endl;
    }

    return 0;
}