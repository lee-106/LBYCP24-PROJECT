/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Johann Carta
 */
public class PokemonIntro extends javax.swing.JFrame {
    Connection conn;
    int counter = 0;
    int gender = 0;
    String user;
    //Gender Male if 1, Female if 0
    /**
     * Creates new form PokemonIntro
     */
    public PokemonIntro(String user,int progress,int gender) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?" + "user=root&password=");
        initComponents();
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jButton7.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        this.user=user;
        this.counter=progress;
        this.gender=gender;
        System.out.println(gender);
        jButton1.doClick();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width-this.getSize().width)/2,(size.height-this.getSize().height)/2);
        
    }

    ImageIcon Bianca = new ImageIcon(getClass().getResource("/Pokemon-Java/Bianca.png"));
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yearbook Solid", 3, 100)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("V.S.");
        jLayeredPane6.add(jLabel10);
        jLabel10.setBounds(240, 170, 230, 110);

        jLabel11.setFont(new java.awt.Font("Yearbook Solid", 3, 80)); // NOI18N
        jLabel11.setText("V.S.");
        jLayeredPane6.add(jLabel11);
        jLabel11.setBounds(260, 170, 160, 110);
        jLayeredPane6.add(jLabel9);
        jLabel9.setBounds(390, 280, 140, 210);
        jLayeredPane6.add(jLabel8);
        jLabel8.setBounds(110, 290, 150, 190);
        jLayeredPane6.add(jLabel2);
        jLabel2.setBounds(360, 70, 155, 161);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Bianca.png"))); // NOI18N
        jLabel1.setFocusable(false);
        jLayeredPane6.add(jLabel1);
        jLabel1.setBounds(250, 20, 177, 450);
        jLayeredPane6.add(jLabel4);
        jLabel4.setBounds(80, 30, 190, 410);

        jLabel5.setIconTextGap(20);
        jLayeredPane6.add(jLabel5);
        jLabel5.setBounds(380, 40, 250, 390);

        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 8, true));
        jLayeredPane6.add(jLabel6);
        jLabel6.setBounds(40, 30, 270, 410);

        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 8, true));
        jLabel7.setIconTextGap(20);
        jLayeredPane6.add(jLabel7);
        jLabel7.setBounds(370, 30, 270, 410);

        jLabel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 20, true));
        jLayeredPane6.add(jLabel12);
        jLabel12.setBounds(30, 20, 290, 430);

        jLabel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 20, true));
        jLayeredPane6.add(jLabel13);
        jLabel13.setBounds(360, 20, 290, 430);

        jButton5.setText("Yes");
        jButton5.setBorderPainted(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("No");
        jButton6.setHideActionText(true);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setText("Next");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Female");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Male");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Save");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setText("Open PC");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(109, 109, 109)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(132, 132, 132))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel3.setText("Hello there! Welcome to the world of Pokémon!  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 11, 720, -1));
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        gender = 0;
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton1.doClick();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(counter==6){
            counter-=2;
            gender=0;
        }
        else{
            counter+=8;
            jButton5.setVisible(false);
            jButton6.setVisible(false);
        }
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jButton1.doClick();
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        gender++;
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton1.doClick();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        counter++;
        switch(counter){
            case 1:{
                jLabel3.setText("My name is Bianca! I am an Assistant Pokemon Professor.");
                break;
            }
            case 2:{
                jLabel3.setText("This is what we call a Pokemon!");
                ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Pikachu-intro.png"));
                jLabel2.setIcon(bbry);
                break;
            }
            case 3:{
                jLabel3.setText("For some people, Pokémon are pets.Others use them for fights.");
                break;
            }
            case 4:{
                jLabel3.setText("I, myself study Pokémon as a profession.");
                break;
            }
            case 5:{
                jLabel1.setIcon(Bianca);
                jLabel2.setVisible(true);
                jButton2.setVisible(true);
                jButton3.setVisible(true);
                jButton1.setVisible(false);
                jLabel3.setText("So tell me are you a boy or a girl");
                break;
            }
            case 6:{
                jLabel3.setText("Are you sure?");
                if(gender == 1)
                {
                    jLabel1.setIcon(null);
                    ImageIcon avatar = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-Full.png"));
                    jLabel1.setIcon(avatar);
                }
                else
                {
                    jLabel1.setIcon(null);
                    ImageIcon avatar = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-Full.png"));
                    jLabel1.setIcon(avatar);
                }
                jLabel2.setVisible(false);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                break;
            }
            case 7:{
                
                jLabel1.setIcon(Bianca);
                jLabel3.setText("Do you want to hear the mechanics of the game?");
                jButton1.setVisible(false);
                jButton5.setVisible(true);
                jButton6.setVisible(true);
                break;
            }
            case 8:{
                jButton1.setVisible(true);
                jLabel3.setText("Battle Frontier consists of 6 rounds with each having it's own respective trainer.");
                break;
            }
            case 9:{   
                jLabel3.setText("The player is given the chance to select 6 Pokemon for his team.");
                break;
            }
            case 10:{
                jLabel3.setText("Pokemon Battle Frontier is a turn-based combat which focuses on strategy to win.");
                break;
            }
            case 11:{
                jLabel3.setText("There are multiple factors to consider in order to win.");
                break;
            }
            case 12:{
                jLabel3.setText("1. How other types are vulnerable to certain types of attack.");
                break;
            }
            case 13:{
                jLabel3.setText("2. How often a Pokemon uses it's skill is limited to the number of PP.");
                break;
            }
            case 14:{
                jLabel3.setText("3. How some attacks enable the player to strike first.");
                break;
            }
            case 15:{
                jLabel3.setText("In the start of each round, the player is given the chance to save his file.");
                break;
            }
            case 16:{
                jLabel3.setText("Now that you know the mechanics press \"Next\"to proceed");
                jButton4.setVisible(true);
                jButton1.setVisible(true);
                break;
            }
            case 17:{
                jLabel3.setText("Select your Team!");
                jButton7.setVisible(true);
                jButton4.setVisible(false);
                jButton1.setVisible(false);
                break;
            }
            case 18:{
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jLabel10.setVisible(true);
                jLabel11.setVisible(true);
                jLabel12.setVisible(true);
                jLabel13.setVisible(true);
                if(gender==0){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-OW.png")));
                }
                else if(gender==1){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-OW.png")));
                }
                jLabel9.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Alder-OW.png")));
                jLabel5.setVisible(true);
                jLabel5.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Alder-Full.png")));
                jLabel1.setVisible(false);
                jLabel5.setLocation(jLabel5.getLocation().x,jLabel5.getLocation().y+10);
                jLabel3.setText("Round 1: Alder");
                break;
            }
            case 19:{
            try {
                PokemonBattle a=new PokemonBattle(user,gender,0);
                a.setVisible(true);
                this.dispose();
                break;
            } catch (SQLException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
            }
            case 20:{
                jLabel1.setVisible(false);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jLabel10.setVisible(true);
                jLabel11.setVisible(true);
                jLabel12.setVisible(true);
                jLabel13.setVisible(true);
                if(gender==0){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-OW.png")));
                }
                else if(gender==1){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-OW.png")));
                }
                jLabel9.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Brycen-OW.png")));
                jLabel5.setVisible(true);
                jLabel5.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Brycen-Full.png")));
                jLabel5.setLocation(jLabel5.getLocation().x+30,jLabel5.getLocation().y);
                jLabel3.setText("Round 2: Brycen");
                break;
            }
            case 21:{
            try {
                PokemonBattle a=new PokemonBattle(user,gender,1);
                a.setVisible(true);
                this.dispose();
                break;
            } catch (SQLException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
                break;
            }
            case 22:{
                jLabel1.setVisible(false);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jLabel10.setVisible(true);
                jLabel11.setVisible(true);
                jLabel12.setVisible(true);
                jLabel13.setVisible(true);
                if(gender==0){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-OW.png")));
                }
                else if(gender==1){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-OW.png")));
                }
                jLabel9.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Cynthia-OW.png")));
                jLabel5.setVisible(true);
                
                jLabel5.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Cynthia-Full.png")));
                jLabel5.setLocation(jLabel5.getLocation().x+40,jLabel5.getLocation().y);
                jLabel3.setText("Round 3: Cynthia");
                break;
            }
            case 23:{
                try {
                PokemonBattle a=new PokemonBattle(user,gender,2);
                a.setVisible(true);
                this.dispose();
                break;
            } catch (SQLException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
                break;
            }
            case 24:{
                jLabel1.setVisible(false);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jLabel10.setVisible(true);
                jLabel11.setVisible(true);
                jLabel12.setVisible(true);
                jLabel13.setVisible(true);
                if(gender==0){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-OW.png")));
                }
                else if(gender==1){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-OW.png")));
                }
                jLabel9.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Cilan-OW.png")));
                jLabel5.setVisible(true);
                jLabel5.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Cilan-Full.png")));
                jLabel5.setLocation(jLabel5.getLocation().x+55,jLabel5.getLocation().y);
                jLabel3.setText("Round 4: Cilan");
                break;
            }
            case 25:{
                try {
                PokemonBattle a=new PokemonBattle(user,gender,3);
                a.setVisible(true);
                this.dispose();
                break;
            } catch (SQLException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
                break;
            }
            case 26:{
                jLabel1.setVisible(false);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jLabel10.setVisible(true);
                jLabel11.setVisible(true);
                jLabel12.setVisible(true);
                jLabel13.setVisible(true);
                if(gender==0){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-OW.png")));
                }
                else if(gender==1){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-OW.png")));
                }
                jLabel9.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Iris-OW.png")));
                jLabel5.setVisible(true);
                jLabel5.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Iris-Full.png")));
                jLabel5.setLocation(jLabel5.getLocation().x,jLabel5.getLocation().y);
                jLabel3.setText("Round 5: Iris");
                break;
            }
            case 27:{
                try {
                PokemonBattle a=new PokemonBattle(user,gender,4);
                a.setVisible(true);
                this.dispose();
                break;
            } catch (SQLException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
                break;
            }
            case 28:{jLabel1.setVisible(false);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jLabel10.setVisible(true);
                jLabel11.setVisible(true);
                jLabel12.setVisible(true);
                jLabel13.setVisible(true);
                if(gender==0){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Rosa-OW.png")));
                }
                else if(gender==1){
                    jLabel4.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-Full.png")));
                    jLabel8.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Hugh-OW.png")));
                }
                jLabel9.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Drayden-OW.png")));
                jLabel5.setVisible(true);
                jLabel5.setIcon(new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Drayden-Full.png")));
                jLabel5.setLocation(jLabel5.getLocation().x+15,jLabel5.getLocation().y);
                jLabel3.setText("Round 6: Drayden");
                break;
            }
            case 29:{
                try {
                PokemonBattle a=new PokemonBattle(user,gender,5);
                a.setVisible(true);
                this.dispose();
                break;
            } catch (SQLException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
                break;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(counter==7){
            jButton5.setVisible(false);
            jButton6.setVisible(false);
        }
        jButton1.doClick();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Statement data=conn.createStatement();
            data.execute("use pokemon_user;");
            data.execute("update login set gender='"+gender+"' where username='"+user+"';");
            data.execute("update login set progress='"+(counter-1)+"' where username='"+user+"';");
        } catch (SQLException ex) {
            Logger.getLogger(PokemonIntro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        PokemonSelection s = new PokemonSelection(user,gender);
        this.dispose();
        s.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed
    
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
            java.util.logging.Logger.getLogger(PokemonIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PokemonIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PokemonIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PokemonIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
