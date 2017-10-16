/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai;
/**
 *
 * @author david_5i3asud
 */
public class ProjektAI {
 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Komunikace k=new Komunikace();
        int moznost = k.moznosti();
        while(moznost==1){
            int hracu;
            hracu = k.pocetH();
            Hra h=new Hra(hracu);
            moznost=k.moznosti();
        }
        System.out.println("Diky za hru :)");
    }
    
}
