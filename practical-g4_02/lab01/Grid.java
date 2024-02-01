public class Grid {
    private char[][] grid;
    private int size;

    public Grid(char[][] grid, int size) {
        this.grid = grid;
        this.size = size;
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }

    public char getElement(int row, int col){
        return grid[row][col];
    }

    // given the starting coord, size and direction, it returns the corresponding word
    public String getWord(int row, int col, int size, Direction dir){
        int[][] coordsArr = GridWalker.walk(row, col, size, dir, this.size);
        if (coordsArr == null) return null;
        String word = "";
        for (int[] coords : coordsArr) {
            word += grid[coords[0]][coords[1]];
        }
        return word;
    }
    
    // public static boolean gridValid(Grid unchecked_grid) {
    //     return true;
    // }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                s += this.grid[i][j];
            }
            s += "\n";
        }
        return s;
    }
}
