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
public class Hra {
    public ArrayList<Karta> balicek=new ArrayList<>();
    public ArrayList<Hrac> hraci=new ArrayList<>();
    public ArrayList<Karta> odhBalicek=new ArrayList<>();
    public int f;
    public int[] dalsiKarta=new int[3];
    public Hra(int pocet){
        f=1;
        int i=-1;
        Zacatek z=new Zacatek(balicek,hraci,pocet,odhBalicek,dalsiKarta);
        while(f!=0){
            i++;
            if(i==hraci.size()){i=0;}
            f=hraci.get(i).hraj(balicek, odhBalicek,dalsiKarta,i);
        }
    }
}
