// is used in multiple files so it cant be declared inside another class
public enum Direction{
    Up(new int[] {-1,0}), 
    Right(new int[] {0,1}), 
    Down(new int[] {1,0}),
    Left(new int[] {0,-1}),
    UpRight(new int[] {-1,1}),
    DownRight(new int[] {1,1}), 
    DownLeft(new int[] {1,-1}),
    UpLeft(new int[] {-1,-1});

    public int[] directionVector;

    Direction(int [] directionVector){
        this.directionVector = directionVector;
    }
} 
