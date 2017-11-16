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
    String user;

    public PokemonBattle() throws SQLException {
        initComponents();
        
        
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);
    }

    public PokemonBattle(String user, int gender, int count_enemy) throws SQLException {
        initComponents();
        
        this.user = user;
        counter_enemy = count_enemy;
        ImageIcon bbry = null;
        if (gender == 0) {
            bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Female.png"));
        } else {
            bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Male.png"));
        }
        jLabel1.setIcon(bbry);
        
        
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        initPokemon(user, 0);
        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);
        int life,enemylife;
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, pokemonlist[0] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                life = rs.getInt("HP");
                lifeBarProgressBar.setMaximum(life);
                this.lifeBarProgressBar.setValue(life);
                System.out.println(life+"=pokemon hp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, enemypokemonList[0] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                enemylife = rs.getInt("HP");
                enemyLifeBar.setMaximum(enemylife);
                this.enemyLifeBar.setValue(enemylife);
                System.out.println(enemylife+"=pokemon hp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void Enemy_attack(){
        try {
            Random rand= new Random();                              
            int value= rand.nextInt(3);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where number = ?");
            pst.setString(1, enemypokemonList[counter_enemy]+"");
            ResultSet rs= pst.executeQuery();
            rs.next();
            switch(value){
                case 0:{
                    try {
                        attack("damage1","enemy",1);
                        announce1.setText(rs.getString("name")+" use "+rs.getString("attack1"));
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 1:{
                    try {
                        attack("damage2","enemy",2);
                        announce1.setText(rs.getString("name")+" use "+rs.getString("attack2"));
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 2:{
                    try {
                        attack("damage3","enemy",3);
                        announce1.setText(rs.getString("name")+" use "+rs.getString("attack3"));
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 3:{
                    try {
                        attack("damage4","enemy",4);
                        announce1.setText(rs.getString("name")+" use "+rs.getString("attack4"));
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        attack1 = new javax.swing.JButton();
        attack2 = new javax.swing.JButton();
        attack3 = new javax.swing.JButton();
        attack4 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Switch");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Attack");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attack1)
                    .addComponent(attack2))
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(attack4)
                    .addComponent(attack3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attack1)
                    .addComponent(attack3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(attack4)
                        .addComponent(jButton3))
                    .addComponent(attack2))
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Male.png"))); // NOI18N

        pokemonImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Back/25.png"))); // NOI18N

        enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Alder-Sprite.png"))); // NOI18N

        lifeBarProgressBar.setMaximum(500);
        lifeBarProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                lifeBarProgressBarStateChanged(evt);
            }
        });

        lifeBarLabel.setText("jLabel2");

        pokemon_enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Front/4.png"))); // NOI18N

        enemyLifeBar.setMaximum(500);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pokemonImage))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enemyPokemonName)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(enemyLifeBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lifeBarProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pokemonName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lifeBarLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(enemylife)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pokemon_enemy)))))
                        .addGap(0, 77, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(announce1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(announce, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(13, 13, 13)
                .addComponent(pokemonName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lifeBarProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lifeBarLabel))
                        .addGap(31, 31, 31)
                        .addComponent(pokemonImage))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(announce, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(announce1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PokemonSwitch switcher = new PokemonSwitch(pokemonlist, lives, current_pokemon, this);
        switcher.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton1.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lifeBarProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_lifeBarProgressBarStateChanged
        lifeBarLabel.setText(lifeBarProgressBar.getValue() + "");
    }//GEN-LAST:event_lifeBarProgressBarStateChanged
    private void attack(String att,String attacker,int i) throws SQLException {
        String type = "";
        String enemytype = "";
        int damage=0;
        double bonus=1;
        if(attacker.equals("player")){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, pokemonlist[0] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                type = rs.getString("type"+i);
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
            bonus=findBonus(type,enemytype);
            int life = enemyLifeBar.getValue();
            int out = (int) (life - (damage*bonus));
            System.out.println("damage= "+damage);
            System.out.println("bonus= "+bonus);
            System.out.println("enemy life= "+out);
            enemyLifeBar.setValue(out);
        }
        else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, pokemonlist[0] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                type = rs.getString("type"+i);
                System.out.println(type+"");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, enemypokemonList[counter_pokemon] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                enemytype = rs.getString("Type");
                System.out.println(enemytype+"");
                damage = rs.getInt(att);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
            bonus=findBonus(enemytype,type);
            int life = lifeBarProgressBar.getValue();
            int out = (int) (life - (damage*bonus));
            System.out.println("damage= "+damage);
            System.out.println("bonus= "+bonus);
            System.out.println("player life= "+out);
            lifeBarProgressBar.setValue(out);
        }
    }
    
    private void enemyLifeBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_enemyLifeBarStateChanged
        enemylife.setText(enemyLifeBar.getValue() + "");
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
        try {                                        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where number = ?");
            pst.setString(1, pokemonlist[current_pokemon]+"");
            ResultSet rs= pst.executeQuery();
            rs.next();
            try {
                attack("damage1","player",1);
                announce.setText(rs.getString("name")+" use "+rs.getString("attack1"));
            } catch (SQLException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
            Enemy_attack();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_attack1ActionPerformed

    private void attack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack2ActionPerformed
        try {                                        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where number = ?");
            pst.setString(1, pokemonlist[current_pokemon]+"");
            ResultSet rs= pst.executeQuery();
            rs.next();
            try {
                attack("damage2","player",2);
                announce.setText(rs.getString("name")+" use "+rs.getString("attack2"));
            } catch (SQLException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
            Enemy_attack();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_attack2ActionPerformed

    private void attack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack3ActionPerformed
        try {                                        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where number = ?");
            pst.setString(1, pokemonlist[current_pokemon]+"");
            ResultSet rs= pst.executeQuery();
            rs.next();
            try {
                attack("damage3","player",3);
                announce.setText(rs.getString("name")+" use "+rs.getString("attack3"));
            } catch (SQLException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
            Enemy_attack();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_attack3ActionPerformed

    private void attack4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack4ActionPerformed
        try {                                        
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where number = ?");
            pst.setString(1, pokemonlist[current_pokemon]+"");
            ResultSet rs= pst.executeQuery();
            rs.next();
            try {
                attack("damage4","player",4);
                announce.setText(rs.getString("name")+" use "+rs.getString("attack4"));
            } catch (SQLException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
            Enemy_attack();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_attack4ActionPerformed

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
    private javax.swing.JButton attack1;
    private javax.swing.JButton attack2;
    private javax.swing.JButton attack3;
    private javax.swing.JButton attack4;
    private javax.swing.JLabel enemy;
    private javax.swing.JProgressBar enemyLifeBar;
    private javax.swing.JLabel enemyPokemonName;
    private javax.swing.JLabel enemylife;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lifeBarLabel;
    private javax.swing.JProgressBar lifeBarProgressBar;
    private javax.swing.JLabel pokemonImage;
    private javax.swing.JLabel pokemonName;
    private javax.swing.JLabel pokemon_enemy;
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
                lives[i-1]=rs.getInt("HP");
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setPokemon(int current_pokemon) throws SQLException {
        initPokemon(user, current_pokemon);
    }

}
