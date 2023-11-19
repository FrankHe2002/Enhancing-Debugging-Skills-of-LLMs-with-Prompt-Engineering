class Solution {
	public long maxPoints(int[][] points) {
		long[] frame = new long[points[0].length];

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < frame.length; j ++) {
				frame[j] += points[i][j];
			}

			for (int j = 1; j < frame.length; j ++) {
				frame[j] = Math.max(frame[j], frame[j - 1] - 1);
			}

			for (int j = frame.length-2; j >= 0; j--) {
				frame[j] = Math.max(frame[j], frame[j + 1] - 1);
			}

			for (long k : frame) {
				System.out.println(k);
			}
		}


		long ans = 0;
		for (int i = 0; i < frame.length; i ++) {
			ans = Math.max(ans, frame[i]);
		}
		return ans;
	}
}