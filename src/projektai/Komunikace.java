/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai;

import java.util.Scanner;

/**
 *
 * @author david_5i3asud
 */
public class Komunikace {
    private Scanner scS=new Scanner(System.in);
    private Scanner scI=new Scanner(System.in);
    public int getI(){
        return scI.nextInt();
    }
    public String getS(){
        return scS.nextLine();
    }
}
