package Gates;

import GUI.BoxColour;
import GUI.Map;

public final class Diode1 extends Gate implements Gates {
    private int con;
    
    public Diode1(BoxColour point, Map map, int rotate ) {
        super(point, map );
        setGate(rotate);
    }

    @Override
    public void setGate(int rotate) {
        con = 0;
        execute(rotate, 0, 5, con);
        execute(rotate, 7, 12, con);
        con = 1;
        execute(rotate, 5, 6, con);
        con = -1;
        execute(rotate, 5, 6, con);
    }   
}
