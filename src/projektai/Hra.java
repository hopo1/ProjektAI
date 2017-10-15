/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author david_5i3asud
 */
public class Hra {
    private Scanner scS=new Scanner(System.in);
    private Scanner scI=new Scanner(System.in);
    public ArrayList<Karta> balicek=new ArrayList<>();
    public ArrayList<Hrac> hraci=new ArrayList<>();
    ArrayList<Karta> odhBalicek=new ArrayList<>();
    public Hra(int pocet){
        boolean vyhra=false;
        int i=-1;
        Zacatek z=new Zacatek(balicek,hraci,pocet);
        while(!vyhra){
            i++;
            if(i==hraci.size()){i=0;}
            hraci.get(i).hraj(pocet, balicek, odhBalicek);
        }
    }
    private int zjistiI(){
        return scI.nextInt();
    }
    private String zjistiS(){
        return scS.nextLine();
    }
}
