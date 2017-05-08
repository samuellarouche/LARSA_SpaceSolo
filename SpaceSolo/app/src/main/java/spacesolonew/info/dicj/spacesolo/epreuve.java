package spacesolonew.info.dicj.spacesolo;
import java.util.Random;

import android.content.Context;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by utilisateur on 2017-03-28.
 */
public class epreuve {

    static public int choixEpreuve() {
        Random rndEpreuve = new Random();
        int rndEp = rndEpreuve.nextInt(5)+1;
        int epreuveChoisi = 0;

        switch (rndEp)
        {
            case 1: epreuveChoisi = 1;
                break;
            case 2: epreuveChoisi = 2;
                break;
            case 3: epreuveChoisi = 3;
                break;
            case 4: epreuveChoisi = 4;
                break;
            case 5: epreuveChoisi = 5;
        }
        return epreuveChoisi;
    }
}
