/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Maverick Rivera
 */
public class PokemonSwitch extends javax.swing.JFrame {

    /**
     * Creates new form PokemonSwitch
     */
    PokemonBattle battleGUI = null;
    int current_pokemon; 
    PokemonSwitch(int[] pokemons, int[] livesPercentage, int current_pokemon, PokemonBattle aThis) {
        
        this.current_pokemon = current_pokemon;
        battleGUI=aThis;
        initComponents();
        JLabel[] pokemonLogos = {pokemon1,pokemon2,pokemon3,pokemon4,pokemon5,pokemon6};
        JProgressBar[] lives = {life1,life2,life3,life4,life5,life6};
        for(int i=0;i<6;i++)
        {   if(i<6-current_pokemon){
//            System.out.println(pokemons[i]);
            pokemonLogos[i].setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_PC/"+pokemons[i+current_pokemon]+".png" )));
            lives[i].setValue(livesPercentage[i]);
        }else{
            System.out.println(pokemons[i]);
            pokemonLogos[i].setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_PC/"+pokemons[i+current_pokemon-6]+".png" )));
            lives[i].setValue(livesPercentage[i]);
        }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pokemon1 = new javax.swing.JLabel();
        pokemon2 = new javax.swing.JLabel();
        pokemon3 = new javax.swing.JLabel();
        pokemon4 = new javax.swing.JLabel();
        pokemon5 = new javax.swing.JLabel();
        pokemon6 = new javax.swing.JLabel();
        life1 = new javax.swing.JProgressBar();
        life2 = new javax.swing.JProgressBar();
        life3 = new javax.swing.JProgressBar();
        life4 = new javax.swing.JProgressBar();
        life5 = new javax.swing.JProgressBar();
        life6 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pokemon1.setText("1");
        pokemon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pokemon1MouseClicked(evt);
            }
        });
        getContentPane().add(pokemon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 23, -1, -1));

        pokemon2.setText("2");
        pokemon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pokemon2MouseClicked(evt);
            }
        });
        getContentPane().add(pokemon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 55, -1, -1));

        pokemon3.setText("3");
        pokemon3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pokemon3MouseClicked(evt);
            }
        });
        getContentPane().add(pokemon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 87, -1, -1));

        pokemon4.setText("4");
        pokemon4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pokemon4MouseClicked(evt);
            }
        });
        getContentPane().add(pokemon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 119, -1, -1));

        pokemon5.setText("5");
        pokemon5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pokemon5MouseClicked(evt);
            }
        });
        getContentPane().add(pokemon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 151, -1, -1));

        pokemon6.setText("6");
        pokemon6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pokemon6MouseClicked(evt);
            }
        });
        getContentPane().add(pokemon6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 183, -1, -1));
        getContentPane().add(life1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 23, -1, -1));
        getContentPane().add(life2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 55, -1, -1));
        getContentPane().add(life3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 87, -1, -1));
        getContentPane().add(life4, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 119, 148, -1));
        getContentPane().add(life5, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 151, 148, -1));
        getContentPane().add(life6, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 183, 148, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Battle_Frontier_logo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 155, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/rsz_7tokox.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pokemon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pokemon1MouseClicked
        try {
            // TODO add your handling code here:
            battleGUI.setPokemon(current_pokemon);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonSwitch.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        battleGUI.current_pokemon = current_pokemon;
    }//GEN-LAST:event_pokemon1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void pokemon2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pokemon2MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(current_pokemon+1<6){
                battleGUI.setPokemon(current_pokemon+1);
                battleGUI.current_pokemon = current_pokemon+1;
            }else{
                battleGUI.setPokemon(current_pokemon+1-6);
                battleGUI.current_pokemon = current_pokemon+1-6;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonSwitch.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_pokemon2MouseClicked

    private void pokemon3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pokemon3MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(current_pokemon+1<6){
                battleGUI.setPokemon(current_pokemon+2);
                
                battleGUI.current_pokemon = current_pokemon+2;
            }else{
                battleGUI.setPokemon(current_pokemon+2-6);
                
                battleGUI.current_pokemon = current_pokemon+2-6;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonSwitch.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_pokemon3MouseClicked

    private void pokemon4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pokemon4MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(current_pokemon+1<6){
                battleGUI.setPokemon(current_pokemon+3);
                battleGUI.current_pokemon = current_pokemon+3;
            }else{
                battleGUI.setPokemon(current_pokemon+3-6);
                battleGUI.current_pokemon = current_pokemon+3-6;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonSwitch.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_pokemon4MouseClicked

    private void pokemon5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pokemon5MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(current_pokemon+1<6){
                battleGUI.setPokemon(current_pokemon+4);
                battleGUI.current_pokemon = current_pokemon+4;
            }else{
                battleGUI.setPokemon(current_pokemon+4-6);
                battleGUI.current_pokemon = current_pokemon+4-6;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonSwitch.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_pokemon5MouseClicked

    private void pokemon6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pokemon6MouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(current_pokemon+1<6){
                battleGUI.setPokemon(current_pokemon+5);
                battleGUI.current_pokemon = current_pokemon+5;
            }else{
                battleGUI.setPokemon(current_pokemon+5-6);
                battleGUI.current_pokemon = current_pokemon+5-6;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonSwitch.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_pokemon6MouseClicked

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
            java.util.logging.Logger.getLogger(PokemonSwitch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PokemonSwitch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PokemonSwitch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PokemonSwitch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar life1;
    private javax.swing.JProgressBar life2;
    private javax.swing.JProgressBar life3;
    private javax.swing.JProgressBar life4;
    private javax.swing.JProgressBar life5;
    private javax.swing.JProgressBar life6;
    private javax.swing.JLabel pokemon1;
    private javax.swing.JLabel pokemon2;
    private javax.swing.JLabel pokemon3;
    private javax.swing.JLabel pokemon4;
    private javax.swing.JLabel pokemon5;
    private javax.swing.JLabel pokemon6;
    // End of variables declaration//GEN-END:variables
}
