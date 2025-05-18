import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<int[]> validStates = new ArrayList<>();
        generateValidStates(m, new int[m], 0, validStates);

        // Map from state to list of compatible next states
        Map<String, List<String>> transitions = new HashMap<>();
        for (int[] a : validStates) {
            String sa = Arrays.toString(a);
            transitions.putIfAbsent(sa, new ArrayList<>());
            for (int[] b : validStates) {
                if (isCompatible(a, b)) {
                    transitions.get(sa).add(Arrays.toString(b));
                }
            }
        }

        // DP initialization
        Map<String, Integer> dp = new HashMap<>();
        for (int[] state : validStates) {
            dp.put(Arrays.toString(state), 1);
        }

        // DP transitions
        for (int col = 1; col < n; col++) {
            Map<String, Integer> newDp = new HashMap<>();
            for (Map.Entry<String, Integer> entry : dp.entrySet()) {
                String prev = entry.getKey();
                int count = entry.getValue();
                for (String next : transitions.get(prev)) {
                    newDp.put(next, (newDp.getOrDefault(next, 0) + count) % MOD);
                }
            }
            dp = newDp;
        }

        // Sum up all final counts
        int result = 0;
        for (int val : dp.values()) {
            result = (result + val) % MOD;
        }
        return result;
    }

    private void generateValidStates(int m, int[] curr, int i, List<int[]> res) {
        if (i == m) {
            res.add(Arrays.copyOf(curr, m));
            return;
        }
        for (int c = 0; c < 3; c++) {
            if (i == 0 || curr[i - 1] != c) {
                curr[i] = c;
                generateValidStates(m, curr, i + 1, res);
            }
        }
    }

    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}