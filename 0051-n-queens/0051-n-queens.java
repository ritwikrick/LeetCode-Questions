import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        // these arrays help us check safety in O(1)
        boolean[] cols = new boolean[n];        // column check
        boolean[] diag1 = new boolean[2 * n];   // row + col
        boolean[] diag2 = new boolean[2 * n];   // row - col + n

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(ans, board, 0, n, cols, diag1, diag2);
        return ans;
    }

    private void backtrack(List<List<String>> ans,
                           char[][] board,
                           int row,
                           int n,
                           boolean[] cols,
                           boolean[] diag1,
                           boolean[] diag2) {

        // BASE CASE — placed queens in all rows
        if (row == n) {
            ans.add(construct(board));
            return;
        }

        // try placing queen in each column of this row
        for (int col = 0; col < n; col++) {

            // check if safe
            if (cols[col] || diag1[row + col] || diag2[row - col + n]) {
                continue;
            }

            // PLACE QUEEN
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[row + col] = true;
            diag2[row - col + n] = true;

            // move to next row
            backtrack(ans, board, row + 1, n, cols, diag1, diag2);

            // BACKTRACK
            board[row][col] = '.';
            cols[col] = false;
            diag1[row + col] = false;
            diag2[row - col + n] = false;
        }
    }

    // convert board to List<String>
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}
