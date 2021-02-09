// #ifndef ONLINE_JUDGE
// #define _CRT_SECURE_NO_WARNINGS
// #endif

#include <iostream>
#include <string>

using namespace std;

// #define swap(a,b) {int t=a;a=b;b=t;};


int main() {
    #ifndef ONLINE_JUDGE
	freopen("tc.in", "r", stdin);
    freopen("tc.out", "w", stdout);
    #endif

    int T;

    cin >> T;
    while (T--) {
        char cube[6][9] = {
            {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}, // U
            {'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y', 'y'}, // D
            {'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r', 'r'}, // F
            {'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'}, // B
            {'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g'}, // L
            {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, // R
        };
        int n;
        string cmd;

        cin >> n;
        while (n--) {
            cin >> cmd;
            switch(cmd[0]) {
                case 'U':
                    // cout << "Up ";
                    if (cmd[1] == '+') {
                        // cout << "to the right\n";
                        char buf[3] = {cube[0][0], };
                        cube[0][0] = cube[0][6];
                        cube[0][6] = cube[0][8];
                        cube[0][8] = cube[0][2];
                        cube[0][2] = buf[0];

                        buf[0] = cube[0][1];
                        cube[0][1] = cube[0][3];
                        cube[0][3] = cube[0][7];
                        cube[0][7] = cube[0][5];
                        cube[0][5] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[2][i];
                            cube[2][i] = cube[5][i];
                            cube[5][i] = cube[3][i];
                            cube[3][i] = cube[4][i];
                            cube[4][i] = buf[i];
                        }
                    } else {
                        // cout << "to the left\n";
                        char buf[3] = {cube[0][0], };
                        cube[0][0] = cube[0][2];
                        cube[0][2] = cube[0][8];
                        cube[0][8] = cube[0][6];
                        cube[0][6] = buf[0];

                        buf[0] = cube[0][1];
                        cube[0][1] = cube[0][5];
                        cube[0][5] = cube[0][7];
                        cube[0][7] = cube[0][3];
                        cube[0][3] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[2][i];
                            cube[2][i] = cube[4][i];
                            cube[4][i] = cube[3][i];
                            cube[3][i] = cube[5][i];
                            cube[5][i] = buf[i];
                        }
                    }
                    break;
                case 'D':
                    // cout << "Down ";
                    if (cmd[1] == '+') {
                        // cout << "to the right\n";
                        char buf[3] = {cube[1][0], };
                        cube[1][0] = cube[1][6];
                        cube[1][6] = cube[1][8];
                        cube[1][8] = cube[1][2];
                        cube[1][2] = buf[0];

                        buf[0] = cube[1][1];
                        cube[1][1] = cube[1][3];
                        cube[1][3] = cube[1][7];
                        cube[1][7] = cube[1][5];
                        cube[1][5] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[3][i+6];
                            cube[3][i+6] = cube[5][i+6];
                            cube[5][i+6] = cube[2][i+6];
                            cube[2][i+6] = cube[4][i+6];
                            cube[4][i+6] = buf[i];
                        }
                    } else {
                        // cout << "to the left\n";
                        char buf[3] = {cube[1][0], };
                        cube[1][0] = cube[1][2];
                        cube[1][2] = cube[1][8];
                        cube[1][8] = cube[1][6];
                        cube[1][6] = buf[0];

                        buf[0] = cube[1][1];
                        cube[1][1] = cube[1][5];
                        cube[1][5] = cube[1][7];
                        cube[1][7] = cube[1][3];
                        cube[1][3] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[3][i+6];
                            cube[3][i+6] = cube[4][i+6];
                            cube[4][i+6] = cube[2][i+6];
                            cube[2][i+6] = cube[5][i+6];
                            cube[5][i+6] = buf[i];
                        }
                    }
                    break;
                case 'F':
                    // cout << "Front ";
                    if (cmd[1] == '+') {
                        // cout << "to the right\n";
                        char buf[3] = {cube[2][0], };
                        cube[2][0] = cube[2][6];
                        cube[2][6] = cube[2][8];
                        cube[2][8] = cube[2][2];
                        cube[2][2] = buf[0];

                        buf[0] = cube[2][1];
                        cube[2][1] = cube[2][3];
                        cube[2][3] = cube[2][7];
                        cube[2][7] = cube[2][5];
                        cube[2][5] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[0][i+6];
                            cube[0][i+6] = cube[4][8-i*3];
                            cube[4][8-i*3] = cube[1][2-i];
                            cube[1][2-i] = cube[5][i*3];
                            cube[5][i*3] = buf[i];
                        }
                    } else {
                        // cout << "to the left\n";
                        char buf[3] = {cube[2][0], };
                        cube[2][0] = cube[2][2];
                        cube[2][2] = cube[2][8];
                        cube[2][8] = cube[2][6];
                        cube[2][6] = buf[0];

                        buf[0] = cube[2][1];
                        cube[2][1] = cube[2][5];
                        cube[2][5] = cube[2][7];
                        cube[2][7] = cube[2][3];
                        cube[2][3] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[0][i+6];
                            cube[0][i+6] = cube[5][i*3];
                            cube[5][i*3] = cube[1][2-i];
                            cube[1][2-i] = cube[4][8-i*3];
                            cube[4][8-i*3] = buf[i];
                        }
                    }
                    break;
                case 'B':
                    // cout << "Back ";
                    if (cmd[1] == '+') {
                        // cout << "to the right\n";
                        char buf[3] = {cube[3][0], };
                        cube[3][0] = cube[3][6];
                        cube[3][6] = cube[3][8];
                        cube[3][8] = cube[3][2];
                        cube[3][2] = buf[0];

                        buf[0] = cube[3][1];
                        cube[3][1] = cube[3][3];
                        cube[3][3] = cube[3][7];
                        cube[3][7] = cube[3][5];
                        cube[3][5] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[0][2-i];
                            cube[0][2-i] = cube[5][8-i*3];
                            cube[5][8-i*3] = cube[1][i+6];
                            cube[1][i+6] = cube[4][i*3];
                            cube[4][i*3] = buf[i];
                        }
                    } else {
                        // cout << "to the left\n";
                        char buf[3] = {cube[3][0], };
                        cube[3][0] = cube[3][2];
                        cube[3][2] = cube[3][8];
                        cube[3][8] = cube[3][6];
                        cube[3][6] = buf[0];

                        buf[0] = cube[3][1];
                        cube[3][1] = cube[3][5];
                        cube[3][5] = cube[3][7];
                        cube[3][7] = cube[3][3];
                        cube[3][3] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[0][2-i];
                            cube[0][2-i] = cube[4][i*3];
                            cube[4][i*3] = cube[1][i+6];
                            cube[1][i+6] = cube[5][8-i*3];
                            cube[5][i*3+2] = buf[i];
                        }
                    }
                    break;
                case 'L':
                    // cout << "Left ";
                    if (cmd[1] == '+') {
                        // cout << "to the right\n";
                        char buf[3] = {cube[4][0], };
                        cube[4][0] = cube[4][6];
                        cube[4][6] = cube[4][8];
                        cube[4][8] = cube[4][2];
                        cube[4][2] = buf[0];

                        buf[0] = cube[4][1];
                        cube[4][1] = cube[4][3];
                        cube[4][3] = cube[4][7];
                        cube[4][7] = cube[4][5];
                        cube[4][5] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[0][i*3];
                            cube[0][i*3] = cube[3][8-i*3];
                            cube[3][8-i*3] = cube[1][i*3];
                            cube[1][i*3] = cube[2][i*3];
                            cube[2][i*3] = buf[i];
                        }
                    } else {
                        // cout << "to the left\n";
                        char buf[3] = {cube[4][0], };
                        cube[4][0] = cube[4][2];
                        cube[4][2] = cube[4][8];
                        cube[4][8] = cube[4][6];
                        cube[4][6] = buf[0];

                        buf[0] = cube[4][1];
                        cube[4][1] = cube[4][5];
                        cube[4][5] = cube[4][7];
                        cube[4][7] = cube[4][3];
                        cube[4][3] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[0][i*3];
                            cube[0][i*3] = cube[2][i*3];
                            cube[2][i*3] = cube[1][i*3];
                            cube[1][i*3] = cube[3][8-i*3];
                            cube[3][8-i*3] = buf[i];
                        }
                    }
                    break;
                case 'R':
                    // cout << "Right ";
                    if (cmd[1] == '+') {
                        // cout << "to the right\n";
                        char buf[3] = {cube[5][0], };
                        cube[5][0] = cube[5][6];
                        cube[5][6] = cube[5][8];
                        cube[5][8] = cube[5][2];
                        cube[5][2] = buf[0];

                        buf[0] = cube[5][1];
                        cube[5][1] = cube[5][3];
                        cube[5][3] = cube[5][7];
                        cube[5][7] = cube[5][5];
                        cube[5][5] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[0][8-i*3];
                            cube[0][8-i*3] = cube[2][8-i*3];
                            cube[2][8-i*3] = cube[1][8-i*3];
                            cube[1][8-i*3] = cube[3][i*3];
                            cube[3][i*3] = buf[i];
                        }
                    } else {
                        // cout << "to the left\n";
                        char buf[3] = {cube[5][0], };
                        cube[5][0] = cube[5][2];
                        cube[5][2] = cube[5][8];
                        cube[5][8] = cube[5][6];
                        cube[5][6] = buf[0];

                        buf[0] = cube[5][1];
                        cube[5][1] = cube[5][5];
                        cube[5][5] = cube[5][7];
                        cube[5][7] = cube[5][3];
                        cube[5][3] = buf[0];

                        for (int i = 0; i < 3; i++) {
                            buf[i] = cube[0][8-i*3];
                            cube[0][8-i*3] = cube[3][i*3];
                            cube[3][i*3] = cube[1][8-i*3];
                            cube[1][8-i*3] = cube[2][8-i*3];
                            cube[2][8-i*3] = buf[i];
                        }
                    }
                    break;
            }

            for (int i = 0; i < 9; i++) {
                if (!(i % 3)) cout << "\n";
                cout << cube[0][i];
            }
            cout << "\n";
        }
        cout << "\n";
        for (int i = 0; i < 9; i++) {
            if (i && !(i % 3)) cout << "\n";
            cout << cube[0][i];
        }
        cout << "\n";
        // cout << "============================================\n";
    }
        
    return 0;
}