package spacesolonew.info.dicj.spacesolo;

import android.widget.FrameLayout;

/**
 * Created by utilisateur on 2017-05-01.
 */
public class verifParti {
    int cptVie;
    boolean finParti;
    public verifParti(){
        cptVie = 5;
    }

    public void loseHP(){
        cptVie--;
        if(cptVie<=0)
            endGame();
    }

    public void endGame(){

    }

}
