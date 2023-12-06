package com.dp;

public class ExpressGetDesiredResult {
    public boolean isValid(char[] ch) {
        if (ch.length % 2 == 0) {
            return false;
        }
        for (int i = 0; i < ch.length; i++) {
            if (i % 2 == 0) {
                if (ch[i] != '1' && ch[i] != '0') {
                    return false;
                }
            } else {
                if (ch[i] != '^' && ch[i] != '|' && ch[i] != '&') {
                    return false;
                }
            }
        }
        return true;
    }

    public int num1(String s, boolean desire) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] ch = s.toCharArray();
        return process(ch, desire, 0, ch.length - 1);
    }

    public int process(char[] ch, boolean desired, int l, int r) {
        if (l == r) {
            if (desired) {
                return ch[l] == '1' ? 1 : 0;
            } else {
                return ch[l] == '1' ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (ch[i]) {
                    case '&':
                        res += process(ch, true, 1, l - 1) * process(ch, true, l + 1, r);
                        break;
                    case '|':
                        res += process(ch, true, 1, l - 1) * process(ch, true, l + 1, r);
                        res += process(ch, true, 1, l - 1) * process(ch, false, l + 1, r);
                        res += process(ch, false, 1, l - 1) * process(ch, true, l + 1, r);
                        break;
                    case '^':
                        res += process(ch, true, 1, l - 1) * process(ch, false, l + 1, r);
                        res += process(ch, false, 1, l - 1) * process(ch, true, l + 1, r);
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i += 2) {
                switch (ch[i]) {
                    case '&':
                        res += process(ch, false, 1, l - 1) * process(ch, false, l + 1, r);
                        res += process(ch, true, 1, l - 1) * process(ch, false, l + 1, r);
                        res += process(ch, false, 1, l - 1) * process(ch, true, l + 1, r);
                        break;
                    case '|':
                        res += process(ch, false, 1, l - 1) * process(ch, false, l + 1, r);
                        break;
                    case '^':
                        res += process(ch, true, 1, l - 1) * process(ch, true, l + 1, r);
                        res += process(ch, false, 1, l - 1) * process(ch, false, l + 1, r);
                        break;
                }
            }
        }
        return res;
    }

    public int num2(String s, boolean desire) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] ch = s.toCharArray();
        int[][] t = new int[ch.length][ch.length];
        int[][] f = new int[ch.length][ch.length];
        t[0][0] = ch[0] == '1' ? 1 : 0;
        f[0][0] = ch[0] == '0' ? 1 : 0;
        for (int i = 2; i < ch.length; i += 2) {
            t[i][i] = ch[i] == '1' ? 1 : 0;
            f[i][i] = ch[i] == '0' ? 1 : 0;
            for (int j = i - 2; j >= 0; j -= 2) {
                for (int k = j; k < i; k += 2) {
                    if (ch[k + 1] == '&') {
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (ch[k + 1] == '|') {
                        t[j][i] += (t[j][k] + f[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k+2][i];
                    } else if (ch[k + 1] == '^') {
                        t[j][i] = f[j][k] * t[k+2][i] + t[j][k] * f[k+2][i];
                        f[j][i] = f[j][k] * f[k+2][i] + t[j][k] * t[k+2][i];
                    }
                }
            }
        }
        return desire ? t[0][ch.length-1] : f[0][ch.length - 1];
    }

    public int num3(String s, boolean desire) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] ch = s.toCharArray();
        if (!isValid(ch)) {
            return 0;
        }
        int[][] t = new int[ch.length][ch.length];
        int[][] f = new int[ch.length][ch.length];
        t[0][0] = ch[0] == '1' ? 1 : 0;
        f[0][0] = ch[0] == '0' ? 1 : 0;
        for (int i = 2; i < ch.length; i+=2) {
            for (int j = i-2; j >= 0; j-=2) {
                for (int k = j; k < i; k+=2) {
                    switch (ch[k + 1]) {
                        case '&':
                            t[j][i] = t[j][k] * t[k+2][i];
                            f[i][j] = t[j][k] * f[k+2][i] + f[j][k] * t[k+2][i] + f[j][k] + f[k+2][i];
                            break;
                        case '|':
                            t[j][i] = t[j][k] * t[k+2][i] + t[j][k] * f[k+2][i] + f[j][k] * t[k+2][i];
                            f[j][i] = f[j][k] * f[k+2][i];
                            break;
                        case '^':
                            t[j][i] = t[j][k] * t[k+2][i] + f[j][k] * f[k+2][i];
                            f[j][i] = t[j][k] * f[k+2][i] + f[j][k] * t[k+2][i];
                            break;
                    }
                }
            }
        }
        return desire ? t[0][ch.length - 1] : f[0][ch.length - 1];
    }

}
