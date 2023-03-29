package MaailmaObjektid;

import java.util.ArrayList;



//ei ole kasutuses, oleksid olnud mängu sisesed kasutatavad objektid (mõõk, eliksiirid jne)
public class Ese {

    String tüüp;
    int tugevus;
    int väärtus;
    boolean kasTarvitatav;

    public Ese(String tüüp, int tugevus, int väärtus, boolean kasTarvitatav) {
        this.tüüp = tüüp;
        this.tugevus = tugevus;
        this.väärtus = väärtus;
        this.kasTarvitatav = kasTarvitatav;
    }

}
