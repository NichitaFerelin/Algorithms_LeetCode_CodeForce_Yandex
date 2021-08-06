package problems.easy;

public class LeetCode_1315 {

    public int countNegatives(int[][] grid) {
        int negativeCounter = 0;

        var endColumnBorder = grid[0].length;

        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < endColumnBorder; columnIndex++) {
                if(grid[rowIndex][columnIndex] < 0) {
                    int remainderByRow = (endColumnBorder - columnIndex - 1) * (grid.length - rowIndex);
                    negativeCounter += grid.length - rowIndex + remainderByRow;
                    endColumnBorder = columnIndex;
                }
            }
        }

        return negativeCounter;
    }
}
