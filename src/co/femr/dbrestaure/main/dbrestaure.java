/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.femr.dbrestaure.main;

import co.femr.dbrestaure.utils.DumpRead;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author netsaj
 */
public class dbrestaure {

    public static void main(String args[]) throws InterruptedException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(dbrestaure.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal p = new Principal();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    }
}
