package GUI;

import java.io.Serializable;

public class SizeofMap implements Serializable {

    private int columns;
    private int rows;
    private final int size = 10;

    public SizeofMap() {
        columns = 50;
        rows = 50;
    }

    public int getRows() {
        return rows;
    }

    public void set(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getSize() {
        return size;
    }

}
