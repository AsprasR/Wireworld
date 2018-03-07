package Gates;

import GUI.BoxColour;
import GUI.Map;

public final class GateAN extends Gate implements Gates {
    private int con;

    public GateAN(BoxColour point, Map map, int rotate) {
        super(point, map );
        setGate(rotate);
    }

    @Override
    public void setGate( int rotate ) {
        con = 0;
        execute(rotate, 0, 7, con);
        execute(rotate, 9, 9, con);
        con = 1;
        execute(rotate, 10, 10, con);
        con = 2;
        execute(rotate, 11, 16, con);
        con = -1;
        execute(rotate, 8, 8, con);
        con = -2;
        execute(rotate, 7, 9, con);
        con = -3;
        execute(rotate, 8, 8, con);
        con = -4;
        execute(rotate, 9, 16, con); 
    }
}
