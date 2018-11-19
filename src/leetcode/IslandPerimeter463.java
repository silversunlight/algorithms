package leetcode;

/**
 * @author ：Lance Sun
 * @date ：Created in 21:22 2018/10/17
 */
public class IslandPerimeter463 {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result += gridPerimeter(grid, i, j);
            }
        }
        return result;
    }

    private int gridPerimeter(int[][] grid, int i, int j) {
        int perimeter = 0;
        if (grid[i][j] == 1) {
            //up
            if (isWallOrIsLake(i - 1, j, grid)) {
                perimeter++;
            }
            //down
            if (isWallOrIsLake(i + 1, j, grid)) {
                perimeter++;
            }
            //left
            if (isWallOrIsLake(i, j - 1, grid)) {
                perimeter++;
            }
            //right
            if (isWallOrIsLake(i, j + 1, grid)) {
                perimeter++;
            }
        }
        return perimeter;
    }

    private boolean isWallOrIsLake(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return true;
        }
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        int[][] grid2 = {
                {1, 0}
        };
        IslandPerimeter463 a = new IslandPerimeter463();
        System.out.println(a.islandPerimeter(grid2));
    }
}
