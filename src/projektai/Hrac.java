/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai;

import java.util.ArrayList;

/**
 *
 * @author david_5i3asud
 */
public class Hrac {
    private ArrayList<Karta> ruka;
    Komunikace k=new Komunikace();
    public Hrac(ArrayList<Karta> balicek){
        for(int i=0;i<7;i++){
            lizniSi(balicek);
        }
    }
    
    public int hraj(ArrayList<Karta> balicek,ArrayList<Karta> odhBalicek){
        int vyber=k.getI();
        if(vyber<ruka.size()){
            zahraj(vyber,odhBalicek);}
        else{
            lizniSi(balicek);}
        return pocetKaret();
    
    }
    /**
     * Hrac si lizne kartu a da si ji do ruky
     * @param balicek lizaci balicek
     */
    private void lizniSi(ArrayList<Karta> balicek){
        ruka.add(balicek.get(0));        
        balicek.remove(0);
    }

    /**
     * Hrac zahraje kartu s indexem i ze sve ruky
     * @param i pozice karty na ruce
     * @param odhBalicek odhayovaci balicek
     */
    private void zahraj(int i,ArrayList<Karta> odhBalicek){
        odhBalicek.add(ruka.get(i));
        ruka.remove(i);
    }
    private int pocetKaret(){
        return ruka.size();
    }
}
