class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = 1;
                }
            }
        }

        for (int[] puddle : puddles) {
           if (puddle.length == 2) {
                int x = puddle[0];
                int y = puddle[1];
                map[y-1][x-1] = -1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int up = map[i - 1][j];
                int left = map[i][j - 1];
                int cur = map[i][j];

                if (cur >= 0) {
                    if (up < 0 && left < 0) {
                        map[i][j] = -1;
                    } else if (up < 0) {
                        map[i][j] = left;
                    } else if (left < 0) {
                        map[i][j] = up; 
                    } else {
                        map[i][j] = (left + up) % 1000000007;
                    }
                }
            }
        }
        return map[n - 1][m - 1] % 1000000007;
    }
}
