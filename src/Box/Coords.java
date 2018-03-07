package Box;

import java.io.Serializable;

public class Coords implements Serializable {

    private final int x, y;
    
    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coords(Coords coords) {
        this.x = coords.x;
        this.y = coords.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coords)) {
            return false;
        }
        Coords that = (Coords) o;
        if (x != that.x) {
            return false;
        }
        return y == that.y;
    }

    @Override
    public int hashCode() {
        return 73 * x + y;
    }

}
