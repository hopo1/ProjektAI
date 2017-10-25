/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author david_5i3asud
 */
public class BalicekA {
    private ArrayList<Karta> bal;
    private String path="Karty_seznam.txt";
    private String slozka="Karty_prsi";
    
    public void Balicek(){
        nacti();
    }
    
    private void nacti(){
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String s;
            int i=0;
        while (((s = br.readLine()) != null)){  /*pro vsechny radky*/
            i++;
            String[] split=s.split(" ");
            int a=Integer.parseInt(split[0]);
            int b=Integer.parseInt(split[1]);
            String pathI;
                pathI = "file:"+slozka+"\\image_part_"+String.format("%03d", i)+".jpg";
            Image img=new Image(pathI);
            Karta k=new Karta(a,b,img);
            bal.add(k);
        }
        
        }
catch (Exception e)
{
        System.err.println("Chyba při četení ze souboru.");
}
    }
}
