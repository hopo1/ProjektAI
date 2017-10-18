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
    private ArrayList<Karta> ruka=new ArrayList<>();
    Komunikace k=new Komunikace();
    public Hrac(ArrayList<Karta> balicek){
        for(int i=0;i<5;i++){
            lizniSi(balicek);
        }
    }
    
    public int hraj(ArrayList<Karta> balicek,ArrayList<Karta> odhBalicek,int[] dalsiKarta,int o){
        System.out.println(zprava(odhBalicek,o));
        int vyber=k.getI();
        if(vyber<ruka.size()){
            if(pravidla(vyber,odhBalicek,dalsiKarta)){
            zahraj(vyber,odhBalicek,dalsiKarta);
            }
            else hraj(balicek,odhBalicek,dalsiKarta,o);
        
        }
        else {
            switch(dalsiKarta[2]){
                case 0:
                    lizniSi(balicek);
                    
                 break;
                case 1:
                    //svrsek(dalsiKarta);
                    lizniSi(balicek);
                 break;
                case 2: //eso
                    dalsiKarta[0]=odhBalicek.get(odhBalicek.size()-1).getBarva();
                 break;
                default: //sedmicka
                    for(int i=0;i<((dalsiKarta[2]-2)*2);i++){
                        lizniSi(balicek);
                    }
                    dalsiKarta[0]=odhBalicek.get(odhBalicek.size()-1).getBarva();
                    break;
            }
            dalsiKarta[2]=0;
        }
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
    private void specEfekt(Karta karta,int[] dalsiKarta){
        dalsiKarta[1]=karta.getTyp();
        switch (karta.getTyp()) {
            case 0: //sedmicka
                if(dalsiKarta[2]==3)dalsiKarta[2]+=1;
                else dalsiKarta[2]=3;
                dalsiKarta[0]=-1;
                break;
            case 5: //svrsek
                svrsek(dalsiKarta);
                break;
            case 7: //eso 
                dalsiKarta[2]=2;
                dalsiKarta[0]=-1;
                break;
            default: //vsechny karty
                dalsiKarta[2]=0;
                dalsiKarta[0]=karta.getBarva();
                break;
        }
        System.err.println("specEfekt");
    }

    /**
     * Hrac zahraje kartu s indexem i ze sve ruky
     * @param i pozice karty na ruce
     * @param odhBalicek odhayovaci balicek
     */
    private void zahraj(int i,ArrayList<Karta> odhBalicek,int[] dalsiKarta){
        odhBalicek.add(ruka.get(i));
        specEfekt(ruka.get(i),dalsiKarta);
        ruka.remove(i);
    }
    private boolean pravidla(int i,ArrayList<Karta> odhBalicek,int[] dalsiKarta){
        boolean b=((ruka.get(i).getBarva()==dalsiKarta[0])||(ruka.get(i).getTyp()==dalsiKarta[1]));
        if(b){
            return true;
        }
        else{
            System.out.println("Nelze zahrat");
            return false;
        }
    }
    private int pocetKaret(){
        return ruka.size();
    }

    private String zprava(ArrayList<Karta> odhBalicek,int o) {
        System.out.println("Hraje hrac ciso: "+o+"\nZahraj kartu (Napis jeji cislo)\nPokud si chces liznout napis libovolne vysi cislo\nhorni karta je: "+odhBalicek.get(odhBalicek.size()-1));
        String s="";
        for(int i=0;i<ruka.size();i++){
            s+="Cislo karty: "+i+" "+ruka.get(i)+"\n";
        }
        return s;
    }

    private void svrsek(int[] dalsiKarta) {
        System.out.println("Vyber cislo barvy");
        String[] s={"Srdce","Listy","Kule","Žaludy"};
        for(int i=0;i<4;i++){
        System.out.println(i+" "+s[i]);}
        dalsiKarta[2]=0;
        dalsiKarta[0]=k.getI();
        System.out.print("");
        }
    
}
