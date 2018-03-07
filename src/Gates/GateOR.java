package Gates;

import GUI.BoxColour;
import GUI.Map;

public final class GateOR extends Gate implements Gates {

    private int con;

    public GateOR(BoxColour point, Map map, int rotate) {
        super(point, map );
        setGate(rotate);
    }

    @Override
    public void setGate( int rotate ) {
        con = 0;
        execute(rotate, 0, 7, con);
        con = 1;
        execute(rotate, 6, 6, con);
        con = 2;
        execute(rotate, 7, 14, con);
        con = -1;
        execute(rotate, 6, 6, con);
        con = -2;
        execute(rotate, 7, 14, con);
    }
}
