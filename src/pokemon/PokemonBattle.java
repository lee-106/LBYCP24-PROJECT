/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Johann Carta
 */
public class PokemonBattle extends javax.swing.JFrame {

    /**
     * Creates new form PokemonBattle
     */
    int[] pokemonlist = {1, 4, 7, 25, 144, 145};
    int[] enemypokemonList = {1, 4, 7, 25, 144, 145};
    int[] lives = {100, 100, 100, 100, 100, 100};
    public int current_pokemon = 0;//array index, zero based 0-5 only, first pokemon = 0, second =1 and so on.
    String[] trainers = {"Alder", "Brycen", "Cynthia", "Cilan", "Iris", "Drayden"};
    int counter_enemy = 0;//enemy trainer
    int counter_pokemon=0;//enemy pokemon
    int lose=0;//count of pokemon lost
    int win=0;//count of pokemon defeated
    int gender;
    String user;

    public PokemonBattle() throws SQLException {
        initComponents();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);
    }
    
    public PokemonBattle(String user, int gender, int count_enemy) throws SQLException {
        initComponents();
        attack1.setVisible(false);
        attack2.setVisible(false);
        attack3.setVisible(false);
        attack4.setVisible(false);
        nextBtn.setVisible(false);
        lifeBarProgressBar.setValue(100);
        enemyLifeBar.setValue(100);
        this.user = user;
        counter_enemy =count_enemy;
        ImageIcon bbry = null;
        if (gender == 0) {
            bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Female.png"));
        } else {
            bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Male.png"));
        }
        jLabel1.setIcon(bbry);
        lifeBarProgressBar.setValue(100);
        enemyLifeBar.setValue(100);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        initPokemon(user, 0);
        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);
    }

    public boolean Enemy_attack(int value){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where number = ?");
            pst.setString(1, enemypokemonList[current_pokemon]+"");
            ResultSet rs= pst.executeQuery();
            rs.next();
            switch(value){
                case 0:{
                    try {
                        announce1.setText(rs.getString("name")+" use "+rs.getString("attack1"));
                        return attack("damage1","enemy");
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 1:{
                    try {
                        announce1.setText(rs.getString("name")+" use "+rs.getString("attack2"));
                        return attack("damage2","enemy");
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 2:{
                    try {
                        announce1.setText(rs.getString("name")+" use "+rs.getString("attack3"));
                        return attack("damage3","enemy");
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 3:{
                    try {
                        announce1.setText(rs.getString("name")+" use "+rs.getString("attack4"));
                        return attack("damage4","enemy");
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    /*
    NOTE!
    This is an example on how you change the png file:
    
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Female.png"));
        jLabel1.setIcon(bbry);
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        switchBtn = new javax.swing.JButton();
        attackBtn = new javax.swing.JButton();
        attack1 = new javax.swing.JButton();
        attack2 = new javax.swing.JButton();
        attack3 = new javax.swing.JButton();
        attack4 = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pokemonImage = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        lifeBarProgressBar = new javax.swing.JProgressBar();
        lifeBarLabel = new javax.swing.JLabel();
        pokemon_enemy = new javax.swing.JLabel();
        enemyLifeBar = new javax.swing.JProgressBar();
        enemylife = new javax.swing.JLabel();
        pokemonName = new javax.swing.JLabel();
        enemyPokemonName = new javax.swing.JLabel();
        announce = new javax.swing.JLabel();
        announce1 = new javax.swing.JLabel();
        announce2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        switchBtn.setText("Switch");
        switchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchBtnActionPerformed(evt);
            }
        });

        attackBtn.setText("Attack");
        attackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attackBtnActionPerformed(evt);
            }
        });

        attack1.setText("Attack1");
        attack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attack1ActionPerformed(evt);
            }
        });

        attack2.setText("Attack2");
        attack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attack2ActionPerformed(evt);
            }
        });

        attack3.setText("Attack3");
        attack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attack3ActionPerformed(evt);
            }
        });

        attack4.setText("Attack4");
        attack4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attack4ActionPerformed(evt);
            }
        });

        nextBtn.setText(" ");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attack1)
                            .addComponent(attack2))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attack3)
                            .addComponent(attack4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attackBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(switchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nextBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attack1)
                    .addComponent(attack3)
                    .addComponent(attackBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attack2)
                    .addComponent(attack4)
                    .addComponent(switchBtn))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Male.png"))); // NOI18N

        pokemonImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Back/25.png"))); // NOI18N

        enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Alder-Sprite.png"))); // NOI18N

        lifeBarProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lifeBarProgressBarStateChanged(evt);
            }
        });

        lifeBarLabel.setText("jLabel2");

        pokemon_enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Front/4.png"))); // NOI18N

        enemyLifeBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                enemyLifeBarStateChanged(evt);
            }
        });

        enemylife.setText("enemylife");

        pokemonName.setText("Name");

        enemyPokemonName.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(enemy))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enemyPokemonName)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(enemyLifeBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lifeBarProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pokemonName, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lifeBarLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(enemylife)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pokemon_enemy)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pokemonImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(announce, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(announce1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(announce2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(enemy)
                            .addComponent(pokemon_enemy)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(enemyPokemonName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemylife)
                            .addComponent(enemyLifeBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(pokemonName)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lifeBarProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lifeBarLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pokemonImage))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(announce2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(announce, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(announce1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void switchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchBtnActionPerformed
        PokemonSwitch switcher = new PokemonSwitch(pokemonlist, lives, current_pokemon, this);
        switcher.setVisible(true);
    }//GEN-LAST:event_switchBtnActionPerformed

    private void changeUserPokemonImage(int number) {
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Back/" + number + ".png"));
        pokemonImage.setIcon(bbry);
    }

    private void changeEnemyImage(String Name) {
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/" + Name + "-sprite.png"));
        enemy.setIcon(bbry);
    }

    private void changeEnemyPokemonImage(int number) {
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Front/" + number + ".png"));
        pokemon_enemy.setIcon(bbry);
    }
    private void attackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackBtnActionPerformed
        switchBtn.setVisible(false);
        attackBtn.setVisible(false);
        attack1.setVisible(true);
        attack2.setVisible(true);
        attack3.setVisible(true);
        attack4.setVisible(true);
    }//GEN-LAST:event_attackBtnActionPerformed

    private void lifeBarProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lifeBarProgressBarStateChanged
       
    }//GEN-LAST:event_lifeBarProgressBarStateChanged
    private boolean attack(String att,String attacker) throws SQLException {
        String type = "";
        String enemytype = "";
        int damage=0;
        int value=Integer.parseInt(att.charAt(6)+"");
        double bonus=1;
        if(attacker.equals("player")){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, pokemonlist[0] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                type = rs.getString("type"+value);
                System.out.println(type+"");
                damage = rs.getInt(att);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, enemypokemonList[counter_enemy] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                enemytype = rs.getString("Type");
                System.out.println(enemytype+"");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, enemypokemonList[counter_pokemon] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            enemytype = rs.getString("type"+value);
            System.out.println(enemytype+"");
            damage = rs.getInt(att);
            bonus=findBonus(enemytype,type);
            int life = Integer.parseInt(enemylife.getText());
            int out = (int) (life-(damage*bonus));
            System.out.println("damage= "+damage);
            System.out.println("bonus= "+bonus);
            System.out.println("enemy life= "+out);
            enemyLifeBar.setValue(out*100/rs.getInt("HP"));
            if(out>0) enemylife.setText(out+"");
            else{
                enemylife.setText("0");
                return false;
            }
        }
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, pokemonlist[0] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                type = rs.getString("Type");
                System.out.println(type+"");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, enemypokemonList[counter_pokemon] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            enemytype = rs.getString("type"+value);
            System.out.println(enemytype+"");
            damage = rs.getInt(att);
            bonus=findBonus(enemytype,type);
            int life = Integer.parseInt(lifeBarLabel.getText());
            int out = (int) (life - (damage*bonus));
            System.out.println("damage= "+damage);
            System.out.println("bonus= "+bonus);
            System.out.println("player life= "+out);
            lifeBarProgressBar.setValue((out*100/rs.getInt("HP")));
            if(out>0) lifeBarLabel.setText(out+"");
            else{
                lifeBarLabel.setText("0");
                return false;
            }
        }
        return true;
    }
    
    private void enemyLifeBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_enemyLifeBarStateChanged
        
    }//GEN-LAST:event_enemyLifeBarStateChanged
    private double findBonus(String type, String enemy) throws SQLException{
        double bonus=1;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from weakness where pokemon_type = ?");
            pst.setString(1, type + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            String strong = rs.getString("strong_against");
            String[] sArray = strong.split(" ");
            System.out.println(""+strong);
            System.out.println(""+sArray[0]);
            if(Arrays.asList(sArray).contains(enemy)){
                System.out.println("strong");
                bonus=2.0;
            }
            String weak = rs.getString("weak_against");
            String[] wArray = weak.split(" ");
            System.out.println(""+wArray[0]);
            if(Arrays.asList(wArray).contains(enemy)){
                bonus=bonus/2;
            }
            String noeffect = rs.getString("noeffect_against");
            String[] nArray = noeffect.split(" ");
            System.out.println(""+nArray);
            if(Arrays.asList(nArray).contains(enemy)){
                bonus=0;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
         return bonus;
    }
    private void attack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack1ActionPerformed
        before_attack(1);
    }//GEN-LAST:event_attack1ActionPerformed

    private void attack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack2ActionPerformed
        before_attack(2);
    }//GEN-LAST:event_attack2ActionPerformed

    private void attack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack3ActionPerformed
        before_attack(3);
    }//GEN-LAST:event_attack3ActionPerformed

    private void attack4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack4ActionPerformed
        before_attack(4);
    }//GEN-LAST:event_attack4ActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        PokemonIntro a = null;
        attackBtn.setVisible(false);
         switchBtn.setVisible(false);
        if(nextBtn.getText().equals("Next")){
            try {
                a = new PokemonIntro(user,(19+(counter_enemy)*2),gender);
            } catch (SQLException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(nextBtn.getText().equals("Exit")){
            try {
                a = new PokemonIntro(user,(17+(counter_enemy)*2),gender);
            } catch (SQLException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            a.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_nextBtnActionPerformed

     public void before_attack(int count){
        switchBtn.setVisible(true);
        attackBtn.setVisible(true);
        attack1.setVisible(false);
        attack2.setVisible(false);
        attack3.setVisible(false);
        attack4.setVisible(false);
        try {                                        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where number = ?");
            pst.setString(1, pokemonlist[current_pokemon]+"");
            ResultSet rs= pst.executeQuery();
            rs.next();
            PreparedStatement pst2 = conn.prepareStatement("Select * from moves where number = ?");
            pst2.setString(1, enemypokemonList[counter_pokemon]+"");
            ResultSet rs1= pst2.executeQuery();
            rs1.next();
            Random rand= new Random();                              
            int value= rand.nextInt(4);
            if(rs1.getInt("damage"+(value+1))<rs.getInt("damage"+count)){
               if(Enemy_attack(value)==true){
                    if(attack("damage"+count,"player")==false){
                        announce2.setText("The Enemy's  "+rs1.getString("name")+" has been defeated");
                        win++;
                        if(win==6){
                            nextBtn.setVisible(true);
                            nextBtn.setText("Next");
                        }
                        else change_enemypokemon();
                    }
                    else announce2.setText("Enemy pokemon first attacks");
                    announce.setText(rs.getString("name")+" uses "+rs.getString("attack"+count));
               }
               else{
                   announce2.setText("The Player's"+rs.getString("name")+" has been defeated");
                    lose++;
                    if(lose==6){
                        nextBtn.setVisible(true);
                        nextBtn.setText("Exit");
                   }
               }
            }
            else{
                announce.setText(rs.getString("name")+" uses "+rs.getString("attack"+count));
                if(attack("damage"+count,"player")==true){
                    announce.setText(rs.getString("name")+" uses "+rs.getString("attack"+count));
                    if(Enemy_attack(value)==false){
                        announce2.setText("The Player's"+rs.getString("name")+" has been defeated");
                        lose++;
                        if(lose==6){
                        nextBtn.setVisible(true);
                        nextBtn.setText("Exit");
                   }
                    }
                    announce2.setText("Player pokemon first attacks");
                }
                else{
                    announce2.setText("The Enemy's "+rs1.getString("name")+" has been defeated");
                    win++;
                    if(win==6){
                        nextBtn.setVisible(true);
                        nextBtn.setText("Next");
                    }
                    else change_enemypokemon();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    /**
     * @param args the command line arguments
     */
     public void change_enemypokemon(){
        counter_pokemon++;
        try {
            changeEnemyPokemonImage(enemypokemonList[counter_pokemon]);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, enemypokemonList[counter_pokemon] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            enemyPokemonName.setText(rs.getString("Name"));
            enemylife.setText(rs.getInt("HP")+"");
            enemyLifeBar.setValue(100);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
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
            java.util.logging.Logger.getLogger(PokemonBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PokemonBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PokemonBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PokemonBattle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PokemonBattle().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel announce;
    private javax.swing.JLabel announce1;
    private javax.swing.JLabel announce2;
    private javax.swing.JButton attack1;
    private javax.swing.JButton attack2;
    private javax.swing.JButton attack3;
    private javax.swing.JButton attack4;
    private javax.swing.JButton attackBtn;
    private javax.swing.JLabel enemy;
    private javax.swing.JProgressBar enemyLifeBar;
    private javax.swing.JLabel enemyPokemonName;
    private javax.swing.JLabel enemylife;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lifeBarLabel;
    private javax.swing.JProgressBar lifeBarProgressBar;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel pokemonImage;
    private javax.swing.JLabel pokemonName;
    private javax.swing.JLabel pokemon_enemy;
    private javax.swing.JButton switchBtn;
    // End of variables declaration//GEN-END:variables

    private void initPokemon(String user, int pokemon_order) throws SQLException {
        changeEnemyImage(trainers[counter_enemy]);
        System.out.println("marker");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon_user?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from login where username = ?");
            pst.setString(1, user);
            ResultSet rs = pst.executeQuery();
            rs.next();
            for (int i = 1; i <= 6; i++) {
                pokemonlist[i - 1] = Integer.parseInt(rs.getString("pokemon" + i));
                System.out.println(pokemonlist[i - 1]);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        System.out.println("enemy marker");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from trainers where Name = ?");
            pst.setString(1, trainers[counter_enemy]);
            ResultSet rs = pst.executeQuery();
            rs.next();
            for (int i = 1; i <= 6; i++) {
                enemypokemonList[i - 1] = Integer.parseInt(rs.getString("pokemon" + i));
                System.out.println(enemypokemonList[i - 1]);
            }
            changeEnemyPokemonImage(enemypokemonList[0]);
            System.out.println("image should have changed by now");
        } catch (Exception e) {
            System.out.println("Error");
        }
        try {
            //select from user database to get the pokemon list
            //select the first pokemon, then display it.

            int pokemonNumber = pokemon_order;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");

            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, pokemonlist[pokemonNumber] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            pokemonName.setText(rs.getString("Name"));
            attack1.setText(rs.getString("attack1"));
            attack2.setText(rs.getString("attack2"));
            attack3.setText(rs.getString("attack3"));
            attack4.setText(rs.getString("attack4"));
            lifeBarLabel.setText((lifeBarProgressBar.getValue()*rs.getInt("HP"))/100+"");
            changeUserPokemonImage(pokemonlist[pokemonNumber]);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int pokemonNum = counter_enemy;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");

            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, enemypokemonList[pokemonNum] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            enemyPokemonName.setText(rs.getString("Name"));
            enemylife.setText((rs.getInt("HP"))+"");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void setPokemon(int current_pokemon) throws SQLException {
        initPokemon(user, current_pokemon);
    }

}
