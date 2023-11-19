class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> usersMap = new HashMap<>();

        for (int[] log : logs) {
            int user = log[0];
            int min = log[1];
            usersMap.putIfAbsent(user, new HashSet<>());
            usersMap.get(user).add(min);
        }

        int[] result = new int[k];
        for (int user : usersMap.keySet()) {
            int uam = usersMap.get(user).size();
            if (uam <= k) {
                result[uam - 1]++;
            }
        }

        return result;
    }
}