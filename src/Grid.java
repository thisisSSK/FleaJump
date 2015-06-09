import java.util.ArrayList;

/**
 * Created by thisisSSK on 6/8/2015.
 */
public class Grid {
    Flea list[];
    int bells;
    int emptySpaces = 0;
    char[][] grid;

    public Grid(int bells) {

        this.bells = bells;

        initGrid();
        initList();
        printGridAndCountSpaces();
        printNumEmptySpaces();

    }

    private void initGrid() {
        this.grid = new char[Consts.MAX_X][Consts.MAX_Y];
        for (int i = 0; i < Consts.MAX_X; i++) {
            for (int j = 0; j<Consts.MAX_Y; j++) {
                this.grid[i][j] ='#';
            }
        }
    }

    private void initList() {
        this.list = new Flea[Consts.MAX_X * Consts.MAX_Y];
        int counter = 0;
        for (int i = 0; i < Consts.MAX_X; i++) {
            for (int j = 0; j<Consts.MAX_Y; j++) {
                list[counter] = new Flea(i, j, isCorner(i, j));
                counter++;
            }
        }
    }

    public boolean isCorner(int x, int y) {
        // Top left corner
        return (x == 0 && y == 0) ||
                (x == 0 && y == Consts.MAX_Y - 1) ||
                (x == Consts.MAX_X - 1 && y == 0) ||
                (x == Consts.MAX_X - 1 && y == Consts.MAX_Y - 1);
    }

    public void ringBells() {
        while (bells > 0) {

            moveAllFleas();
            refreshGrid();
            printGridAndCountSpaces();
            printNumEmptySpaces();

            bells--;
        }
    }

    private void moveAllFleas() {
        for (int i = 0; i < Consts.MAX_X * Consts.MAX_Y; i++) {
            Flea curFlea = this.list[i];


            curFlea.move();
            curFlea.setAtCorner( isCorner(curFlea.getX(), curFlea.getY() ) );
        }
    }

    private void refreshGrid() {

        for(int i = 0; i < Consts.MAX_X; i++) {
            for (int j = 0; j < Consts.MAX_Y; j++) {
                grid[i][j] = '_';
            }
        }
        for (int i = 0; i < Consts.MAX_X * Consts.MAX_Y; i++) {
            Flea curFlea = this.list[i];

            grid[curFlea.getX()][curFlea.getY()] = '#';
        }
    }


    private void printGridAndCountSpaces() {
        System.out.println("==========================================================================================");
        int counter = 0;
        for(int i = 0; i < Consts.MAX_X; i++) {
            for (int j = 0; j < Consts.MAX_Y; j++) {
                System.out.print(" " +grid[i][j]+" ");
                if (grid[i][j] == '_') {
                    counter++;
                }
            }
            System.out.println("");
        }
        System.out.println("==========================================================================================");
        emptySpaces = counter;
    }

    public void printNumEmptySpaces() {
        System.out.printf("*** There are %d number of empty spaces on the grid! ***\n", emptySpaces);
    }

    public int getNumEmptySpaces() {
        return emptySpaces;
    }

}
