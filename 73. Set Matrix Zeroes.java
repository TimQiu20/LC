class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {return;}
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++) {
                if (used[i][j]) continue;
                if (!used[i][j] && matrix[i][j] == 0) {
                    for (int a = 0; a < matrix[0].length; a++) {
                        if (matrix[i][a] == 0 && !used[i][a]) {
                            used[i][a] = false;
                            continue;
                        }
                        matrix[i][a] = 0;
                        used[i][a] = true;
                    }
                    for (int b = 0; b < matrix.length; b++) {
                        if (matrix[b][j] == 0 && !used[b][j]) {
                            used[b][j] = false;
                            continue;
                        }
                        matrix[b][j] = 0;
                        used[b][j] = true;
                    }
                    used[i][j] = true;
                }
            }
        }
    }
}