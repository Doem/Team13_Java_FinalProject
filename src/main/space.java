/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Doem
 */
public class space {

    private final int color[] = {0, 0, 0, 0, 0};
    private String theColor = "D";
    
    public void setColor(int index, int val) {
        this.color[index] = val;
    }
    
    public void setTheColor(String theColor) {
        this.theColor = theColor;
    }

    public int[] getColor() {
        return color;
    }

    public String getTheColor() {
        return theColor;
    }
    

    public void detect() {
        int temp = 0;

        for (int i = 0; i < 5; i++) {
            if (color[i] > color[temp]) {
                temp = i;
            }
        }

        if (color[temp] >= 750) {
            switch (temp) {
                case 0:
                    theColor = "F";
                    break;
                case 1:
                    theColor = "R";
                    break;
                case 2:
                    theColor = "L";
                    break;
                case 3:
                    theColor = "U";
                    break;
                case 4:
                    theColor = "B";
                    break;
                default:
                    break;
            }
        }
    }
}