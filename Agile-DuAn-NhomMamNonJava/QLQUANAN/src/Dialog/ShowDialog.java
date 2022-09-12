/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialog;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author sangtm
 */
public class ShowDialog {
    public static void openMessage(Component c, String thongbao, String title) {
        JOptionPane.showMessageDialog(c, thongbao, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int showConfirm(Component c, String thongbao, String title) {
        return JOptionPane.showConfirmDialog(c, thongbao, title, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
}
