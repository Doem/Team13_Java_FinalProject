/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

/**
 *
 * @author Doem
 */
public class WebCam_Form extends javax.swing.JFrame {

    Webcam webcam = Webcam.getDefault();
    static int index = 0;
    Mat mask = new Mat();

//    public String convertIntToStr(int index) {
//        switch (index) {
//            case 0:
//                return "U";
//            case 1:
//                return "R";
//            case 2:
//                return "F";
//            case 3:
//                return "D";
//            case 4:
//                return "L";
//            case 5:
//                return "B";
//            default:
//                break;
//        }
//        return "None";
//    }
    public void imgTransForm() {
        Mat src = Imgcodecs.imread("test.jpg");
        Mat hsv = new Mat(), red1 = new Mat(), red2 = new Mat(), yellow = new Mat(), blue = new Mat(), green = new Mat(), orange = new Mat(), white = new Mat(), sum = new Mat(), out = new Mat();
        Mat mask = Mat.zeros(src.rows(), src.cols(), CV_8U);
        cvtColor(src, hsv, COLOR_BGR2HSV);

        inRange(hsv, new Scalar(0, 150, 50), new Scalar(8, 255, 255), red1);
        inRange(hsv, new Scalar(156, 100, 50), new Scalar(180, 255, 255), red2);
        inRange(hsv, new Scalar(20, 100, 50), new Scalar(35, 255, 255), yellow);
        inRange(hsv, new Scalar(90, 40, 50), new Scalar(124, 255, 255), blue);
        inRange(hsv, new Scalar(35, 100, 50), new Scalar(90, 255, 2555), green);
        inRange(hsv, new Scalar(8, 60, 50), new Scalar(20, 255, 255), orange);
        inRange(hsv, new Scalar(0, 0, 231), new Scalar(180, 100, 255), white);
        Core.add(red1, red2, sum);
        Core.add(yellow, sum, sum);
        Core.add(blue, sum, sum);
        Core.add(green, sum, sum);
        Core.add(orange, sum, sum);
        Core.add(white, sum, sum);
        Core.add(mask, sum, mask);
        src.copyTo(out, mask);
        Imgcodecs.imwrite("test.jpg", out);
    }

//    public void ColorDetecter(Mat img) {
//        int k = 0, v = -25, i = 0, j = 95;
//        double R = 0, G = 0, B = 0;
//        double H = 0, S = 0, V = 0;
//        space qua[] = new space[9];
//
//        while (k != 9) {
//            i = v;
//            if (k % 3 == 0) {
//                i += 130;
//            }
//            if (j > 485) {
//                j = 95;
//            }
//            j += 80;
//
//            v = i;
//            int m = j;
//            for (; i <= v + 50; i++) {
//                for (j = m; j <= m + 50; j++) {
//                    double ma = 0, mi = 0, x = 0;
//                    double BGR[] = img.get(i, j);
//                    B = BGR[0];
//                    G = BGR[1];
//                    R = BGR[2];
//                    ma = max(B, G);
//                    ma = max(ma, R);
//                    mi = min(B, G);
//                    mi = min(mi, R);
//                    x = ma - mi;
//
//                    V = ma;
//                    if (ma != 0) {
//                        S = x / ma * 255;
//                    }
//
//                    if (x > 0) {
//                        if (R == ma) {
//                            if (G >= B) {
//                                H = (G - B) / (ma - mi) * 60;
//                            } else {
//                                H = (G - B) / (ma - mi) * 60 + 360;
//                            }
//                        } else if (G == ma) {
//                            H = 120 + (B - R) / (ma - mi) * 60;
//                        } else if (B == ma) {
//                            H = 240 + (R - G) / (ma - mi) * 60;
//                        }
//
//                        H /= 2;
//
//                        if (!(S <= 50 && V >= 195)) {
//                            if ((H > 0 && H < 8) || (H > 156 && H < 180)) {
//                                qua[k].setColor(0, qua[k].getColor()[0]++);
//                            } else if (H > 35 && H < 80) {
//                                qua[k].setColor(1, qua[k].getColor()[1]++);
//                            } else if (H > 95 && H < 124) {
//                                qua[k].setColor(2, qua[k].getColor()[2]++);
//                            } else if (H > 20 && H < 35) {
//                                qua[k].setColor(3, qua[k].getColor()[3]++);
//                            } else if (H > 8 && H < 20) {
//                                qua[k].setColor(4, qua[k].getColor()[4]++);
//                            }
//                        }
//                    }
//                }
//            }
//            qua[k].detect();
//            k++;
//        }
//
//        int n = 0;
//        StringBuilder tempfacelet = new StringBuilder(facelet);
//        if (qua[4].getTheColor() == "U") {
//            n = 0;
//        } else if (qua[4].getTheColor() == "R") {
//            n = 9;
//        } else if (qua[4].getTheColor() == "F") {
//            n = 18;
//        } else if (qua[4].getTheColor() == "D") {
//            n = 27;
//        } else if (qua[4].getTheColor() == "L") {
//            n = 36;
//        } else if (qua[4].getTheColor() == "B") {
//            n = 45;
//        }
//        
//        for (int c = 0; c < 9; c++) {
//            tempfacelet.setCharAt(n + c, qua[c].getTheColor().charAt(0));
//        }
//        facelet = tempfacelet.toString();
//        new mainForm().setColor();
//    }
    /**
     * Creates new form WebCam_Form
     */
    public WebCam_Form() {
        initComponents();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.open();
        new CaptureCam().start();
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rubik's Cube Detecter");

        jButton1.setText("Capture");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (index == 6) {
                index = 0;
            }
            ImageIO.write(webcam.getImage(), "JPG", new File("test" + index + ".jpg"));
            index++;
        } catch (IOException ex) {
            Logger.getLogger(WebCam_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(WebCam_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebCam_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebCam_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebCam_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        System.load("C:\\opencv\\build\\java\\x64\\opencv_java330.dll");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WebCam_Form().setVisible(true);
            }
        });
    }

    class CaptureCam extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    ImageIO.write(webcam.getImage(), "JPG", new File("test.jpg"));
                    imgTransForm();

                    Image img = ImageIO.read(new File("test.jpg"));
                    Graphics g = img.getGraphics();

                    g.drawRect(150, 80, 100, 100);
                    g.drawRect(280, 80, 100, 100);
                    g.drawRect(410, 80, 100, 100);
                    g.drawRect(150, 210, 100, 100);
                    g.drawRect(280, 210, 100, 100);
                    g.drawRect(410, 210, 100, 100);
                    g.drawRect(150, 340, 100, 100);
                    g.drawRect(280, 340, 100, 100);
                    g.drawRect(410, 340, 100, 100);
                    jLabel1.setIcon(new ImageIcon(img));
                    Thread.sleep(50);
                } catch (IOException ex) {
                    Logger.getLogger(WebCam_Form.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WebCam_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
