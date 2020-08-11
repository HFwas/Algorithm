package 数组;
/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * @author Administrator
 *[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。
 */
public class _240_搜索二维矩阵II {
	public boolean searchMatrix(int[][] matrix, int target) {
		//if(matrix == null || matrix[0].length == 0 || matrix.length == 0) return false;

		int row = matrix.length - 1, col = 0;
		while (row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] > target) {
				row--;
			}else if (matrix[row][col] < target) {
				col++;
			}else {
				return true;
			}
		}
		return false;
    }
}
