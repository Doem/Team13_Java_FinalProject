/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kociemba.twophase.*;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static java.lang.Double.max;
import static java.lang.Double.min;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static main.mainForm.facelet;

import static org.opencv.core.Core.inRange;
import static org.opencv.core.CvType.CV_8U;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.*;

import static org.opencv.imgproc.Imgproc.COLOR_BGR2HSV;
import static org.opencv.imgproc.Imgproc.cvtColor;
import org.opencv.core.*;

import main.space;

import main.WebCam_Form;

/**
 *
 * @author Doem
 */
public class mainForm extends javax.swing.JFrame {

    static String facelet = "";
    static String Solve = "";
    static Color cubeColors[] = {Color.YELLOW, Color.GREEN, Color.RED, Color.WHITE, Color.BLUE, Color.ORANGE};

    private int Convert(char ch) {
        if (ch == 'U') {
            return 0;
        }
        if (ch == 'L') {
            return 4;
        }
        if (ch == 'F') {
            return 2;
        }
        if (ch == 'R') {
            return 1;
        }
        if (ch == 'B') {
            return 5;
        }
        if (ch == 'D') {
            return 3;
        }
        return -1;
    }

    public void setColor() {
        jLabel1.setBackground(cubeColors[Convert(facelet.charAt(0))]);
        jLabel2.setBackground(cubeColors[Convert(facelet.charAt(1))]);
        jLabel3.setBackground(cubeColors[Convert(facelet.charAt(2))]);
        jLabel4.setBackground(cubeColors[Convert(facelet.charAt(3))]);
        jLabel5.setBackground(cubeColors[Convert(facelet.charAt(4))]);
        jLabel6.setBackground(cubeColors[Convert(facelet.charAt(5))]);
        jLabel7.setBackground(cubeColors[Convert(facelet.charAt(6))]);
        jLabel8.setBackground(cubeColors[Convert(facelet.charAt(7))]);
        jLabel9.setBackground(cubeColors[Convert(facelet.charAt(8))]);

        jLabel10.setBackground(cubeColors[Convert(facelet.charAt(9))]);
        jLabel11.setBackground(cubeColors[Convert(facelet.charAt(10))]);
        jLabel12.setBackground(cubeColors[Convert(facelet.charAt(11))]);
        jLabel13.setBackground(cubeColors[Convert(facelet.charAt(12))]);
        jLabel14.setBackground(cubeColors[Convert(facelet.charAt(13))]);
        jLabel15.setBackground(cubeColors[Convert(facelet.charAt(14))]);
        jLabel16.setBackground(cubeColors[Convert(facelet.charAt(15))]);
        jLabel17.setBackground(cubeColors[Convert(facelet.charAt(16))]);
        jLabel18.setBackground(cubeColors[Convert(facelet.charAt(17))]);

        jLabel19.setBackground(cubeColors[Convert(facelet.charAt(18))]);
        jLabel20.setBackground(cubeColors[Convert(facelet.charAt(19))]);
        jLabel21.setBackground(cubeColors[Convert(facelet.charAt(20))]);
        jLabel22.setBackground(cubeColors[Convert(facelet.charAt(21))]);
        jLabel23.setBackground(cubeColors[Convert(facelet.charAt(22))]);
        jLabel24.setBackground(cubeColors[Convert(facelet.charAt(23))]);
        jLabel25.setBackground(cubeColors[Convert(facelet.charAt(24))]);
        jLabel26.setBackground(cubeColors[Convert(facelet.charAt(25))]);
        jLabel27.setBackground(cubeColors[Convert(facelet.charAt(26))]);

        jLabel28.setBackground(cubeColors[Convert(facelet.charAt(27))]);
        jLabel29.setBackground(cubeColors[Convert(facelet.charAt(28))]);
        jLabel30.setBackground(cubeColors[Convert(facelet.charAt(29))]);
        jLabel31.setBackground(cubeColors[Convert(facelet.charAt(30))]);
        jLabel32.setBackground(cubeColors[Convert(facelet.charAt(31))]);
        jLabel33.setBackground(cubeColors[Convert(facelet.charAt(32))]);
        jLabel34.setBackground(cubeColors[Convert(facelet.charAt(33))]);
        jLabel35.setBackground(cubeColors[Convert(facelet.charAt(34))]);
        jLabel36.setBackground(cubeColors[Convert(facelet.charAt(35))]);

        jLabel37.setBackground(cubeColors[Convert(facelet.charAt(36))]);
        jLabel38.setBackground(cubeColors[Convert(facelet.charAt(37))]);
        jLabel39.setBackground(cubeColors[Convert(facelet.charAt(38))]);
        jLabel40.setBackground(cubeColors[Convert(facelet.charAt(39))]);
        jLabel41.setBackground(cubeColors[Convert(facelet.charAt(40))]);
        jLabel42.setBackground(cubeColors[Convert(facelet.charAt(41))]);
        jLabel43.setBackground(cubeColors[Convert(facelet.charAt(42))]);
        jLabel44.setBackground(cubeColors[Convert(facelet.charAt(43))]);
        jLabel45.setBackground(cubeColors[Convert(facelet.charAt(44))]);

        jLabel46.setBackground(cubeColors[Convert(facelet.charAt(45))]);
        jLabel47.setBackground(cubeColors[Convert(facelet.charAt(46))]);
        jLabel48.setBackground(cubeColors[Convert(facelet.charAt(47))]);
        jLabel49.setBackground(cubeColors[Convert(facelet.charAt(48))]);
        jLabel50.setBackground(cubeColors[Convert(facelet.charAt(49))]);
        jLabel51.setBackground(cubeColors[Convert(facelet.charAt(50))]);
        jLabel52.setBackground(cubeColors[Convert(facelet.charAt(51))]);
        jLabel53.setBackground(cubeColors[Convert(facelet.charAt(52))]);
        jLabel54.setBackground(cubeColors[Convert(facelet.charAt(53))]);
    }

    private void U() {
        StringBuilder tempfacelet = new StringBuilder(facelet);

        tempfacelet.setCharAt(0, facelet.charAt(6));
        tempfacelet.setCharAt(1, facelet.charAt(3));
        tempfacelet.setCharAt(2, facelet.charAt(0));
        tempfacelet.setCharAt(3, facelet.charAt(7));
        tempfacelet.setCharAt(4, facelet.charAt(4));
        tempfacelet.setCharAt(5, facelet.charAt(1));
        tempfacelet.setCharAt(6, facelet.charAt(8));
        tempfacelet.setCharAt(7, facelet.charAt(5));
        tempfacelet.setCharAt(8, facelet.charAt(2));

        tempfacelet.setCharAt(18, facelet.charAt(9));
        tempfacelet.setCharAt(19, facelet.charAt(10));
        tempfacelet.setCharAt(20, facelet.charAt(11));

        tempfacelet.setCharAt(9, facelet.charAt(45));
        tempfacelet.setCharAt(10, facelet.charAt(46));
        tempfacelet.setCharAt(11, facelet.charAt(47));

        tempfacelet.setCharAt(45, facelet.charAt(36));
        tempfacelet.setCharAt(46, facelet.charAt(37));
        tempfacelet.setCharAt(47, facelet.charAt(38));

        tempfacelet.setCharAt(36, facelet.charAt(18));
        tempfacelet.setCharAt(37, facelet.charAt(19));
        tempfacelet.setCharAt(38, facelet.charAt(20));
        facelet = tempfacelet.toString();
    }

    private void D() {
        StringBuilder tempfacelet = new StringBuilder(facelet);

        tempfacelet.setCharAt(27, facelet.charAt(33));
        tempfacelet.setCharAt(28, facelet.charAt(30));
        tempfacelet.setCharAt(29, facelet.charAt(27));
        tempfacelet.setCharAt(30, facelet.charAt(34));
        tempfacelet.setCharAt(31, facelet.charAt(31));
        tempfacelet.setCharAt(32, facelet.charAt(28));
        tempfacelet.setCharAt(33, facelet.charAt(35));
        tempfacelet.setCharAt(34, facelet.charAt(32));
        tempfacelet.setCharAt(35, facelet.charAt(29));

        tempfacelet.setCharAt(24, facelet.charAt(42));
        tempfacelet.setCharAt(25, facelet.charAt(43));
        tempfacelet.setCharAt(26, facelet.charAt(44));

        tempfacelet.setCharAt(15, facelet.charAt(24));
        tempfacelet.setCharAt(16, facelet.charAt(25));
        tempfacelet.setCharAt(17, facelet.charAt(26));

        tempfacelet.setCharAt(51, facelet.charAt(15));
        tempfacelet.setCharAt(52, facelet.charAt(16));
        tempfacelet.setCharAt(53, facelet.charAt(17));

        tempfacelet.setCharAt(42, facelet.charAt(51));
        tempfacelet.setCharAt(43, facelet.charAt(52));
        tempfacelet.setCharAt(44, facelet.charAt(53));
        facelet = tempfacelet.toString();
    }

    private void R() {
        StringBuilder tempfacelet = new StringBuilder(facelet);

        tempfacelet.setCharAt(9, facelet.charAt(15));
        tempfacelet.setCharAt(10, facelet.charAt(12));
        tempfacelet.setCharAt(11, facelet.charAt(9));
        tempfacelet.setCharAt(12, facelet.charAt(16));
        tempfacelet.setCharAt(13, facelet.charAt(13));
        tempfacelet.setCharAt(14, facelet.charAt(10));
        tempfacelet.setCharAt(15, facelet.charAt(17));
        tempfacelet.setCharAt(16, facelet.charAt(14));
        tempfacelet.setCharAt(17, facelet.charAt(11));

        tempfacelet.setCharAt(20, facelet.charAt(29));
        tempfacelet.setCharAt(23, facelet.charAt(32));
        tempfacelet.setCharAt(26, facelet.charAt(35));

        tempfacelet.setCharAt(29, facelet.charAt(51));
        tempfacelet.setCharAt(32, facelet.charAt(48));
        tempfacelet.setCharAt(35, facelet.charAt(45));

        tempfacelet.setCharAt(45, facelet.charAt(8));
        tempfacelet.setCharAt(48, facelet.charAt(5));
        tempfacelet.setCharAt(51, facelet.charAt(2));

        tempfacelet.setCharAt(2, facelet.charAt(20));
        tempfacelet.setCharAt(5, facelet.charAt(23));
        tempfacelet.setCharAt(8, facelet.charAt(26));
        facelet = tempfacelet.toString();
    }

    private void L() {
        StringBuilder tempfacelet = new StringBuilder(facelet);

        tempfacelet.setCharAt(36, facelet.charAt(42));
        tempfacelet.setCharAt(37, facelet.charAt(39));
        tempfacelet.setCharAt(38, facelet.charAt(36));
        tempfacelet.setCharAt(39, facelet.charAt(43));
        tempfacelet.setCharAt(40, facelet.charAt(40));
        tempfacelet.setCharAt(41, facelet.charAt(37));
        tempfacelet.setCharAt(42, facelet.charAt(44));
        tempfacelet.setCharAt(43, facelet.charAt(41));
        tempfacelet.setCharAt(44, facelet.charAt(38));

        tempfacelet.setCharAt(18, facelet.charAt(0));
        tempfacelet.setCharAt(21, facelet.charAt(3));
        tempfacelet.setCharAt(24, facelet.charAt(6));

        tempfacelet.setCharAt(27, facelet.charAt(18));
        tempfacelet.setCharAt(30, facelet.charAt(21));
        tempfacelet.setCharAt(33, facelet.charAt(24));

        tempfacelet.setCharAt(47, facelet.charAt(33));
        tempfacelet.setCharAt(50, facelet.charAt(30));
        tempfacelet.setCharAt(53, facelet.charAt(27));

        tempfacelet.setCharAt(0, facelet.charAt(53));
        tempfacelet.setCharAt(3, facelet.charAt(50));
        tempfacelet.setCharAt(6, facelet.charAt(47));
        facelet = tempfacelet.toString();
    }

    private void F() {
        StringBuilder tempfacelet = new StringBuilder(facelet);

        tempfacelet.setCharAt(18, facelet.charAt(24));
        tempfacelet.setCharAt(19, facelet.charAt(21));
        tempfacelet.setCharAt(20, facelet.charAt(18));
        tempfacelet.setCharAt(21, facelet.charAt(25));
        tempfacelet.setCharAt(22, facelet.charAt(22));
        tempfacelet.setCharAt(23, facelet.charAt(19));
        tempfacelet.setCharAt(24, facelet.charAt(26));
        tempfacelet.setCharAt(25, facelet.charAt(23));
        tempfacelet.setCharAt(26, facelet.charAt(20));

        tempfacelet.setCharAt(38, facelet.charAt(27));
        tempfacelet.setCharAt(41, facelet.charAt(28));
        tempfacelet.setCharAt(44, facelet.charAt(29));

        tempfacelet.setCharAt(27, facelet.charAt(15));
        tempfacelet.setCharAt(28, facelet.charAt(12));
        tempfacelet.setCharAt(29, facelet.charAt(9));

        tempfacelet.setCharAt(9, facelet.charAt(6));
        tempfacelet.setCharAt(12, facelet.charAt(7));
        tempfacelet.setCharAt(15, facelet.charAt(8));

        tempfacelet.setCharAt(6, facelet.charAt(44));
        tempfacelet.setCharAt(7, facelet.charAt(41));
        tempfacelet.setCharAt(8, facelet.charAt(38));
        facelet = tempfacelet.toString();
    }

    private void B() {
        StringBuilder tempfacelet = new StringBuilder(facelet);

        tempfacelet.setCharAt(45, facelet.charAt(51));
        tempfacelet.setCharAt(46, facelet.charAt(48));
        tempfacelet.setCharAt(47, facelet.charAt(45));
        tempfacelet.setCharAt(48, facelet.charAt(52));
        tempfacelet.setCharAt(49, facelet.charAt(49));
        tempfacelet.setCharAt(50, facelet.charAt(46));
        tempfacelet.setCharAt(51, facelet.charAt(53));
        tempfacelet.setCharAt(52, facelet.charAt(50));
        tempfacelet.setCharAt(53, facelet.charAt(47));

        tempfacelet.setCharAt(36, facelet.charAt(2));
        tempfacelet.setCharAt(39, facelet.charAt(1));
        tempfacelet.setCharAt(42, facelet.charAt(0));

        tempfacelet.setCharAt(33, facelet.charAt(36));
        tempfacelet.setCharAt(34, facelet.charAt(39));
        tempfacelet.setCharAt(35, facelet.charAt(42));

        tempfacelet.setCharAt(11, facelet.charAt(35));
        tempfacelet.setCharAt(14, facelet.charAt(34));
        tempfacelet.setCharAt(17, facelet.charAt(33));

        tempfacelet.setCharAt(0, facelet.charAt(11));
        tempfacelet.setCharAt(1, facelet.charAt(14));
        tempfacelet.setCharAt(2, facelet.charAt(17));
        facelet = tempfacelet.toString();
    }

    private void doFormula(String command) {
        switch (command) {
            case "U":
                U();
                break;
            case "U2":
                U();
                U();
                break;
            case "U'":
                U();
                U();
                U();
                break;
            case "D":
                D();
                break;
            case "D2":
                D();
                D();
                break;
            case "D'":
                D();
                D();
                D();
                break;
            case "R":
                R();
                break;
            case "R2":
                R();
                R();
                break;
            case "R'":
                R();
                R();
                R();
                break;
            case "L":
                L();
                break;
            case "L2":
                L();
                L();
                break;
            case "L'":
                L();
                L();
                L();
                break;
            case "F":
                F();
                break;
            case "F2":
                F();
                F();
                break;
            case "F'":
                F();
                F();
                F();
                break;
            case "B":
                B();
                break;
            case "B2":
                B();
                B();
                break;
            case "B'":
                B();
                B();
                B();
                break;
            default:
                break;
        }
    }

    /**
     * Creates new form mainForm
     */
    public mainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rubik's Cube Solver");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(255, 255, 0));
        jLabel5.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("U");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(0, 255, 0));
        jLabel14.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("R");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel14.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel15.setOpaque(true);

        jLabel16.setBackground(new java.awt.Color(204, 204, 204));
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setOpaque(true);

        jLabel19.setBackground(new java.awt.Color(204, 204, 204));
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel19.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel20.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(204, 204, 204));
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel21.setOpaque(true);

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel22.setOpaque(true);

        jLabel23.setBackground(new java.awt.Color(255, 0, 0));
        jLabel23.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("F");
        jLabel23.setToolTipText("");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel23.setOpaque(true);

        jLabel24.setBackground(new java.awt.Color(204, 204, 204));
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel24.setOpaque(true);

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel25.setOpaque(true);

        jLabel26.setBackground(new java.awt.Color(204, 204, 204));
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel26.setOpaque(true);

        jLabel27.setBackground(new java.awt.Color(204, 204, 204));
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel27.setOpaque(true);

        jLabel28.setBackground(new java.awt.Color(204, 204, 204));
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel28.setOpaque(true);

        jLabel29.setBackground(new java.awt.Color(204, 204, 204));
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel29.setOpaque(true);

        jLabel30.setBackground(new java.awt.Color(204, 204, 204));
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel30.setOpaque(true);

        jLabel31.setBackground(new java.awt.Color(204, 204, 204));
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel31.setOpaque(true);

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("D");
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel32.setOpaque(true);

        jLabel33.setBackground(new java.awt.Color(204, 204, 204));
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel33.setOpaque(true);

        jLabel34.setBackground(new java.awt.Color(204, 204, 204));
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel34.setOpaque(true);

        jLabel35.setBackground(new java.awt.Color(204, 204, 204));
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel35.setOpaque(true);

        jLabel36.setBackground(new java.awt.Color(204, 204, 204));
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel36.setOpaque(true);

        jLabel37.setBackground(new java.awt.Color(204, 204, 204));
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setOpaque(true);

        jLabel38.setBackground(new java.awt.Color(204, 204, 204));
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel38.setOpaque(true);

        jLabel39.setBackground(new java.awt.Color(204, 204, 204));
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel39.setOpaque(true);

        jLabel40.setBackground(new java.awt.Color(204, 204, 204));
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel40.setOpaque(true);

        jLabel41.setBackground(new java.awt.Color(0, 0, 255));
        jLabel41.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("L");
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel41.setOpaque(true);

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel42.setOpaque(true);

        jLabel43.setBackground(new java.awt.Color(204, 204, 204));
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel43.setOpaque(true);

        jLabel44.setBackground(new java.awt.Color(204, 204, 204));
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel44.setOpaque(true);

        jLabel45.setBackground(new java.awt.Color(204, 204, 204));
        jLabel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel45.setOpaque(true);

        jLabel46.setBackground(new java.awt.Color(204, 204, 204));
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel46.setOpaque(true);

        jLabel47.setBackground(new java.awt.Color(204, 204, 204));
        jLabel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel47.setOpaque(true);

        jLabel48.setBackground(new java.awt.Color(204, 204, 204));
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel48.setOpaque(true);

        jLabel49.setBackground(new java.awt.Color(204, 204, 204));
        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel49.setOpaque(true);

        jLabel50.setBackground(new java.awt.Color(255, 165, 0));
        jLabel50.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("B");
        jLabel50.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel50.setOpaque(true);

        jLabel51.setBackground(new java.awt.Color(204, 204, 204));
        jLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel51.setOpaque(true);

        jLabel52.setBackground(new java.awt.Color(204, 204, 204));
        jLabel52.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel52.setOpaque(true);

        jLabel53.setBackground(new java.awt.Color(204, 204, 204));
        jLabel53.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel53.setOpaque(true);

        jLabel54.setBackground(new java.awt.Color(204, 204, 204));
        jLabel54.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel54.setOpaque(true);

        jButton1.setText("Reset");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Load");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Solve");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton4.setText("Random");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("Run");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setText("Next");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)))
                .addContainerGap())
            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("U1");
        jLabel2.getAccessibleContext().setAccessibleName("U2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        Solve = "";
        facelet = "UUUUUUUUURRRRRRRRRFFFFFFFFFDDDDDDDDDLLLLLLLLLBBBBBBBBB";
        jLabel57.setText(Solve);
        setColor();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String trueface = "";
        String[] facel = new String[6];
        for (int c = 0; c < 6; c++) {
            facel[c] = new String("");
        }
        for (int p = 0; p < 6; p++) {
            Mat img = Imgcodecs.imread("test" + p + ".jpg");
//            Imshow im = new Imshow("Title");
            int k = 0, v = -25, i = 0, j = 95;
            double R = 0, G = 0, B = 0;
            double H = 0, S = 0, V = 0;
            space[] qua = new space[9];
            for (int c = 0; c < 9; c++) {
                qua[c] = new space();
            }

            Mat hsv = new Mat(), red1 = new Mat(), red2 = new Mat(), yellow = new Mat(), blue = new Mat(), green = new Mat(), orange = new Mat(), white = new Mat(), sum = new Mat(), out = new Mat();
            Mat mask = Mat.zeros(img.rows(), img.cols(), CV_8U);
            cvtColor(img, hsv, COLOR_BGR2HSV);

            //inRange(hsv, new Scalar(0, 150, 50), new Scalar(8, 255, 255), red1);
            inRange(hsv, new Scalar(156, 100, 50), new Scalar(180, 255, 255), red2);
            inRange(hsv, new Scalar(20, 100, 50), new Scalar(35, 255, 255), yellow);
            inRange(hsv, new Scalar(90, 40, 50), new Scalar(124, 255, 255), blue);
            inRange(hsv, new Scalar(35, 100, 50), new Scalar(90, 255, 2555), green);
            inRange(hsv, new Scalar(0, 60, 50), new Scalar(20, 255, 255), orange);
            inRange(hsv, new Scalar(0, 0, 231), new Scalar(180, 100, 255), white);
            Core.add(red2, red2, sum);
            Core.add(yellow, sum, sum);
            Core.add(blue, sum, sum);
            Core.add(green, sum, sum);
            Core.add(orange, sum, sum);
            Core.add(white, sum, sum);
            Core.add(mask, sum, mask);
            img.copyTo(out, mask);
            while (k != 9) {
                i = v;
                if (k % 3 == 0) {
                    i += 130;
                }
                if (j > 485) {
                    j = 95;
                }
                j += 80;

                v = i;
                int m = j;
                for (; i <= v + 50; i++) {
                    for (j = m; j <= m + 50; j++) {
                        double ma = 0, mi = 0, x = 0;
                        double BGR[] = out.get(i, j);
                        B = BGR[0];
                        G = BGR[1];
                        R = BGR[2];
                        ma = max(B, G);
                        ma = max(ma, R);
                        mi = min(B, G);
                        mi = min(mi, R);
                        x = ma - mi;

                        V = ma;
                        if (ma != 0) {
                            S = x / ma * 255;
                        }

                        if (x > 0) {
                            if (R == ma) {
                                if (G >= B) {
                                    H = (G - B) / (ma - mi) * 60;
                                } else {
                                    H = (G - B) / (ma - mi) * 60 + 360;
                                }
                            } else if (G == ma) {
                                H = 120 + (B - R) / (ma - mi) * 60;
                            } else if (B == ma) {
                                H = 240 + (R - G) / (ma - mi) * 60;
                            }

                            H /= 2;
//                        System.out.print("["+i+"]["+j+"] "+R+" "+G+" "+B+" ");
//                        System.out.printf("%.2f",H);
//                        System.out.println();
                            if (!(S <= 50 && V >= 195)) {
                                if ((H > 0 && H < 5) || (H > 156 && H < 180)) {
                                    qua[k].setColor(0, qua[k].getColor()[0] + 1);
                                } else if (H > 35 && H < 80) {
                                    qua[k].setColor(1, qua[k].getColor()[1] + 1);
                                } else if (H > 95 && H < 124) {
                                    qua[k].setColor(2, qua[k].getColor()[2] + 1);
                                } else if (H > 20 && H < 35) {
                                    qua[k].setColor(3, qua[k].getColor()[3] + 1);
                                } else if (H > 5 && H < 20) {
                                    qua[k].setColor(4, qua[k].getColor()[4] + 1);
                                }
                            }
                        }
                    }
                }
                qua[k].detect();
                k++;
            }

            int n = 0;

            if (qua[4].getTheColor() == "U") {
                n = 0;
            } else if (qua[4].getTheColor() == "R") {
                n = 1;
            } else if (qua[4].getTheColor() == "F") {
                n = 2;
            } else if (qua[4].getTheColor() == "D") {
                n = 3;
            } else if (qua[4].getTheColor() == "L") {
                n = 4;
            } else if (qua[4].getTheColor() == "B") {
                n = 5;
            }

            for (int c = 0; c < 9; c++) {
                facel[n] += qua[c].getTheColor();
            }
        }

        facelet = "";
        for (int c = 0; c < 6; c++) {
            facelet += facel[c];
        }
        System.out.println(facelet);
//        File file = new File("cubeFacelet.txt");
//        
//        try {
//            Scanner scanner = new Scanner(file);
//            facelet = scanner.next();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
//        }

        setColor();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:        
        int verify = Tools.verify(facelet);
        switch (verify) {
            case 0:
                Solve = Search.solution(facelet, 21, 2, false);
                jLabel57.setText(Solve);
                break;
            case -1:
                jLabel57.setText("There is not exactly one facelet of each colour");
                break;
            case -2:
                jLabel57.setText("Not all 12 edges exist exactly once");
                break;
            case -3:
                jLabel57.setText("Flip error: One edge has to be flipped");
                break;
            case -4:
                jLabel57.setText("Not all 8 corners exist exactly once");
                break;
            case -5:
                jLabel57.setText("Twist error: One corner has to be twisted");
                break;
            case -6:
                jLabel57.setText("Parity error: Two corners or two edges have to be exchanged");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        facelet = Tools.randomCube();
        System.out.println(facelet);
        setColor();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        String temp[] = Solve.split(" ");
        for (String str : temp) {
            doFormula(str);
        }
        Solve = "";
        jLabel57.setText(Solve);
        setColor();
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        if (Solve.equals("")) {
            return;
        }
        String temp[] = Solve.split(" ");
        Solve = "";
        for (int i = 1; i < temp.length; i++) {
            Solve += (temp[i] + " ");
        }
        System.out.println(temp[0]);
        jLabel57.setText(Solve);
        doFormula(temp[0]);
        setColor();
    }//GEN-LAST:event_jButton6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        System.load("C:\\opencv\\build\\java\\x64\\opencv_java330.dll");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainForm().setVisible(true);
                new WebCam_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
