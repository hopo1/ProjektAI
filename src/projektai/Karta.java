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
public class Karta {
    private int typ;
    private String typS;
    private int barva;
    private String barvaS;
    private int poradi;
   public Karta(int typ,int barva){
       this.typ=typ;
       this.barva=barva;
       urciBarva();
       urciTyp();
       
   } 
    private void urciTyp(){
       switch(typ){
           case 0:
               typS="Sedma";
              break;
           case 1:
               typS="Osmička";
              break;
           case 2:
               typS="Devítka";
              break;
           case 3:
               typS="Desítka";
              break;
           case 4:
               typS="Spodek";
              break;
           case 5:
               typS="Svršek";
              break;
           case 6:
               typS="Král";
              break;
           case 7:
               typS="Eso";
              break;    
       }
   }
   private void urciBarva(){
       switch(barva){
           case 0:
               barvaS="Srdce";
              break;
           case 1:
               barvaS="Listy";
              break;
           case 2:
               barvaS="Kule";
              break;
           case 3:
               barvaS="Žaludy";
       }
   }

    /**
     * @return the poradi
     */
    public int getPoradi() {
        return poradi;
    }

    /**
     * @param poradi the poradi to set
     */
    public void setPoradi(int poradi) {
        this.poradi = poradi;
    }
    @Override
    public String toString(){
        String s=typS+" "+barvaS;
        return s;
    }
}
