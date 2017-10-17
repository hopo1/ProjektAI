/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;    
import java.util.Random;

/**
 *
 * @author david_5i3asud
 */
public final class Zacatek {
    Random r=new Random();
    public ArrayList<Karta> balicek;
    
    public Zacatek(ArrayList<Karta> balicek,ArrayList<Hrac> hraci,int pocet,ArrayList<Karta> odhBalicek,int[] dalsiKarta){
        this.balicek=balicek;
        vyrobB();
        michej();
        vyrobH(pocet,hraci);
        prvniKarta(odhBalicek,dalsiKarta);
    }
    private void prvniKarta(ArrayList<Karta> odhBalicek,int[] dalsiKarta){
        odhBalicek.add(balicek.get(0));
        dalsiKarta[1]=odhBalicek.get(0).getTyp();
        switch (odhBalicek.get(0).getTyp()) {
            case 0:
                dalsiKarta[2]=3;
                dalsiKarta[0]=-1;
                break;
            case 5:
                dalsiKarta[2]=1;
                dalsiKarta[0]=-1;
                break;
            case 7:
                dalsiKarta[2]=2;
                dalsiKarta[0]=-1;
                break;
            default:
                dalsiKarta[2]=0;
                dalsiKarta[0]=odhBalicek.get(0).getBarva();
           
        balicek.remove(0);
        
    }
    }

    /**
     * vytvori hraci balicek
     */
    private void vyrobB(){
        for(int i=0;i<4;i++){
            for(int y=0;y<8;y++){
                Karta k=new Karta(y,i);
                balicek.add(k);
            }
        }
    }

    /**
     * Nahodne zamicha karty v balicku (Podle Poradi)
     */
    public final void michej(){
        for(Karta k:balicek){
            k.setPoradi(r.nextInt());
        }
      Collections.sort(balicek,new Comparator<Karta>()
        {
            @Override
            public int compare(Karta k1,Karta k2){
                return Integer.valueOf(k1.getPoradi()).compareTo(k2.getPoradi());
                        
            }  
    });
    }
    public ArrayList<Hrac> vyrobH(int pocet, ArrayList<Hrac> hraci){
      for(int i=0;i<pocet;i++){
          Hrac h=new Hrac(balicek);
          hraci.add(h);
      }
      return hraci;
    }
}