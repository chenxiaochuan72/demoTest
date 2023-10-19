package 面试;

import java.util.HashSet;
import java.util.Set;

public class SegmentCount {
    public static int parseSegmentCount( int N,int[][] matrix) {
        int totalSegments = 0;
        // 用于记录方格是否已被访问过。
        boolean[][] visited = new boolean[N][N];

        // 遍历整个方格
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    // 将满足条件的线段加入,并去重
                    Set<String> segments = new HashSet<>();
                    dfs(matrix, i, j, N, matrix[i][j], 1, visited, segments);
                    totalSegments += segments.size();
                }
            }
        }

        return totalSegments;
    }

    public static void dfs(int[][] grid, int row, int col, int N, int type, int length, boolean[][] visited, Set<String> segments) {
        // 判断是否超出方格范围或已访问过或方格类型不匹配，不满足条件则返回
        if (row < 0 || row >= N || col < 0 || col >= N || visited[row][col] || grid[row][col] != type) {
            return;
        }

        visited[row][col] = true; // 标记当前方格为已访问

        // 继续向下搜索，探索纵向和横向的方格
        dfs(grid, row + 1, col, N, type, length + 1, visited, segments); // 向下搜索（纵向）
        dfs(grid, row, col + 1, N, type, length + 1, visited, segments); // 向右搜索（横向）

        // 只有当线段长度大于等于类型值时，才将其加入集合（保证去重）
        if (length >= type) {
            segments.add(type + " " + length);
        }
    }

    public static void main(String[] args) {
        // 此为测试数据case, 测试通过不代表可通过所有case！提交前请充分测试!
        int[][] matrix = {
                {1, 2, 1},
                {2, 2, 3},
                {3, 2, 1}
        };
        System.out.println(parseSegmentCount(matrix.length, matrix));
    }
}
