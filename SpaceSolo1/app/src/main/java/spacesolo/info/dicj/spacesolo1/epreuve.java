package spacesolo.info.dicj.spacesolo1;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by utilisateur on 2017-03-28.
 */
public class epreuve {

    static public int choixEpreuve(int rndEpreuve) {

        int epreuveChoisi = 0;

        switch (rndEpreuve)
        {
            case 1: epreuveChoisi = 1;
                break;
            case 2: epreuveChoisi = 2;
                break;
            case 3: epreuveChoisi = 3;
                break;
            case 4: epreuveChoisi = 4;
        }
        return epreuveChoisi;
    }

    /*public boolean verifEpreuve(){

    }*/
}
