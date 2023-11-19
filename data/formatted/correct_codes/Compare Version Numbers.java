class Solution {
    public int compareVersion(String version1, String version2) {
        version1 = version1.replace('.', '#');
        version2 = version2.replace('.', '#');

        String v1[] = version1.split("#");
        String v2[] = version2.split("#");

        int i = 0;


        while (i < v1.length || i < v2.length) {
            Integer i1 = 0;
            Integer i2 = 0;
            if (i < v1.length) {
                i1 = Integer.valueOf(removezero(v1[i]));
            }
            if (i < v2.length) {
                i2 = Integer.valueOf(removezero(v2[i]));
            }
            if (i1 < i2) {
                return - 1;
            } else if (i1 > i2) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    String removezero(String s) {
        String result = "";
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '0') {
                result = s.substring(i, s.length());
                break;
            }
            i++;
        }
        return result != "" ? result : "0";
    }
}
