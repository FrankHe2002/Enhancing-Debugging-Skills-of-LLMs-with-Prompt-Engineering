class Solution {
    void colorFill(int[][] image, int sr, int sc, int sourceColor, int targetColor) {
        int m = image.length, n = image[0].length;

        if (sr >= 0 && sr < m && sc >= 0 && sc < n) {
            if ((sr > 0 && image[sr - 1][sc] != sourceColor) || (image[sr][sc] == targetColor))
                return;

            image[sr][sc] = targetColor;
            colorFill(image, sr, sc - 1, sourceColor, targetColor);
            colorFill(image, sr, sc + 1, sourceColor, targetColor);
            colorFill(image, sr - 1, sc, sourceColor, targetColor);
            colorFill(image, sr + 1, sc, sourceColor, targetColor);
        } else
            return;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length, cols = image[0].length;

        colorFill(image, sr, sc, image[sr][sc], color);
        return image;
    }
}