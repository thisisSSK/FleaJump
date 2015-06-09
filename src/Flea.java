/**
 * Created by thisisSSK on 6/8/2015.
 */
public class Flea {
    private int x;
    private int y;
    boolean atCorner;

    public Flea(int x, int y, boolean atCorner) {
        this.x = x;
        this.y = y;
        this.atCorner = atCorner;
        // System.out.println("New Flea at " +x +"," + y);
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setAtCorner(boolean atCorner) {
        this.atCorner = atCorner;
    }

    public void move() {

        if (atCorner) {
            moveFromCorner();
        }
        else {
            moveFromNonCorner();
        }
    }

    private void moveFromNonCorner() {
        // System.out.printf("moving from %d %d ->", this.x, this.y);
        // Top wall
        if ( this.x == 0 ) {
            int deltaY = Consts.RAND.nextInt(3) - 1;
            this.y += deltaY;
            if (deltaY == 0) {
                this.x++;
            }
        }
        // Left Wall
        else if (this.y == 0) {
            int deltaX = Consts.RAND.nextInt(3) - 1;
            this.x += deltaX;
            if (deltaX == 0) {
                this.y++;
            }
        }
        // Bottom Wall
        else if ( this.x == Consts.MAX_X - 1 ) {

            int deltaY = Consts.RAND.nextInt(3) - 1;
            this.y += deltaY;
            if (deltaY == 0) {
                this.x--;
            }
        }
            // Right Wall
        else if (this.y == Consts.MAX_Y - 1) {
                int deltaX = Consts.RAND.nextInt(3) - 1;
                this.x += deltaX;
                if (deltaX == 0) {
                    this.y--;
                }
            }
        else {
                int deltaX = Consts.RAND.nextInt(3) - 1;
                this.x += deltaX;
                if (deltaX == 0) {
                    int deltaY = 0;
                    while (deltaY == 0) {
                        deltaY = Consts.RAND.nextInt(3) - 1;
                    }
                    this.y += deltaY;
                }


        }
        //    System.out.printf(" %d, %d\n", this.x, this.y);

    }
    private void moveFromCorner() {
        int corner = findWhichCorner();
        // System.out.println("Moving from corner " + corner);
        switch(corner) {
            case Consts.TOP_LEFT:
                moveFromTopLeft();
                break;
            case Consts.TOP_RIGHT:
                moveFromTopRight();
                break;
            case Consts.BOTTOM_LEFT:
                moveFromBottomLeft();
                break;
            case Consts.BOTTOM_RIGHT:
                moveFromBottomRight();
                break;
        }
    }
    // Top Left -> add 0 or
    private void moveFromTopLeft() {
        int deltaY = Consts.RAND.nextInt(2);
        this.y += deltaY;
        if (deltaY == 0) {
            this.x++;
        }
    }
    private void moveFromTopRight() {
        int deltaY = Consts.RAND.nextInt(2) - 1;
        this.y += deltaY;
        if (deltaY == 0) {
            this.x++;
        }
    }
    private void moveFromBottomLeft(){
        int deltaY = Consts.RAND.nextInt(2);
        this.y += deltaY;
        if (deltaY == 0) {
            this.x--;
        }
    }
    private void moveFromBottomRight() {
        int deltaY = Consts.RAND.nextInt(2) - 1;
        this.y += deltaY;
        if (deltaY == 0) {
            this.x--;
        }
    }

    public int findWhichCorner() {
        // Top left corner
        if (x == 0 && y == 0) {
            return Consts.TOP_LEFT;
        }
        // Top right corner
        else if (x == 0 && y == Consts.MAX_Y - 1) {
            return Consts.TOP_RIGHT;
        }
        // Bottom left corner
        else if (x == Consts.MAX_X-1 && y == 0) {
            return Consts.BOTTOM_LEFT;
        }
        // Bottom right corner
        else if (x == Consts.MAX_X-1 && y == Consts.MAX_Y-1) {
            return Consts.BOTTOM_RIGHT;
        }
        else {
            return 0;
        }
    }

}
