import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MinimumCost {
    int cost;

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        cost = 0;
        makeCuts(0, 0, m, n);
        return cost;
    }

    private void makeCuts(int rowStart, int colStart, int row, int col, int[] horizontalCut, int[] verticalCut) {
        if (row == 1 && col == 1) {
            return;
        }
        if (row == 1) {
            for (int i = colStart; i < colStart + col - 1; i++) {
                cost += verticalCut[i];
            }
            return;
        } else if (col == 1) {
            for (int i = rowStart; i < rowStart + row - 1; i++) {
                cost += horizontalCut[i];
            }
            return;
        } else {
            int rowMax = 0, rowIndex = 0, colMax = 0, colIndex = 0;
            for (int i = rowStart; i < rowStart + row - 1; i++) {
                if (horizontalCut[i] > rowMax) {
                    rowMax = horizontalCut[i];
                    rowIndex = i;
                }
            }
            for (int i = colStart; i < colStart + col - 1; i++) {
                if (verticalCut[i] > colMax) {
                    colMax = verticalCut[i];
                    colIndex = i;
                }
            }
            if (rowMax * col < colMax * row) {
                cost += rowMax;
                makeCuts(rowStart, colStart, rowIndex - rowStart + 1, col, horizontalCut, verticalCut);
                makeCuts(rowIndex, colStart, row - rowIndex + rowStart, col, horizontalCut, verticalCut);
            } else {
                cost += colMax;
                makeCuts(rowStart, colStart, row, colIndex - colStart + 1, horizontalCut, verticalCut);
                makeCuts(rowStart, colIndex, col, col - colIndex + colStart, horizontalCut, verticalCut);
            }
        }

    }
}
