public class GridWalker {
    public static int[][] walk(int row, int col, int size, Direction dir, int grid_size){
        int[][] coordsArr = new int[size][2];

        //test given direction and return an array with the coords that the word will occupy
        int endingrow = row + (size * dir.directionVector[0]);
        int endingcol = col + (size * dir.directionVector[1]);
        if (endingrow < -1 || endingrow > grid_size || endingcol < -1 || endingcol > grid_size) {
            return null;
        }
        for(int i = 0; i < size; i++){
            coordsArr[i][0] = row + (i * dir.directionVector[0]);
            coordsArr[i][1] = col + (i * dir.directionVector[1]);
        }

        return coordsArr;
    }
}
