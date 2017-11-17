/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    int[] enemyPokemonList = {1, 4, 7, 25, 144, 145};
    int[] playerLives = {100, 100, 100, 100, 100, 100};
    public int[] playerMaxLives = {100, 100, 100, 100, 100, 100};
    int[] enemyLives = {100, 100, 100, 100, 100, 100};
    public int currentPokemon = 0;//array index, zero based 0-5 only, first pokemon = 0, second =1 and so on.
    String[] trainers = {"Alder", "Brycen", "Cynthia", "Cilan", "Iris", "Drayden"};
    int counter_enemy = 0;//enemy trainer
    int enemyPokemonCounter = 0;//enemy pokemon
    int lose = 0;//count of pokemon lost
    int win = 0;//count of pokemon defeated
    int gender;
    String user;

    public PokemonBattle() throws SQLException {
        initComponents();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);
    }

    public PokemonBattle(String user, int gender, int count_enemy) throws SQLException, ClassNotFoundException {
        initComponents();
        attack1.setVisible(false);
        attack2.setVisible(false);
        attack3.setVisible(false);
        attack4.setVisible(false);
        nextBtn.setVisible(false);
        
        this.user = user;
        counter_enemy = count_enemy;
        ImageIcon bbry = null;
        if (gender == 0) {
            bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Female.png"));
        } else {
            bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Male.png"));
        }
        jLabel1.setIcon(bbry);
        playerLifeBarProgressBar.setValue(100);
        enemyLifeBarProgressBar.setValue(100);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);
        initPokemonLists();
        initLives();
        initPokemon(user, 0);
    }

    public boolean enemyAttack(int value) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where number = ?");
            pst.setString(1, enemyPokemonList[enemyPokemonCounter] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            switch (value) {
                case 0: {
                    try {
                        announce1.setText(rs.getString("name") + " use " + rs.getString("attack1"));
                        return attack("damage1", "enemy");
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 1: {
                    try {
                        announce1.setText(rs.getString("name") + " use " + rs.getString("attack2"));
                        return attack("damage2", "enemy");
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 2: {
                    try {
                        announce1.setText(rs.getString("name") + " use " + rs.getString("attack3"));
                        return attack("damage3", "enemy");
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
                case 3: {
                    try {
                        announce1.setText(rs.getString("name") + " use " + rs.getString("attack4"));
                        return attack("damage4", "enemy");
                    } catch (SQLException ex) {
                        Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    }
                    break;
                }
            }
            conn.close();
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
        playerPokemonImage = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        playerLifeBarProgressBar = new javax.swing.JProgressBar();
        playerLifeBarLabel = new javax.swing.JLabel();
        enemyPokemonImage = new javax.swing.JLabel();
        enemyLifeBarProgressBar = new javax.swing.JProgressBar();
        enemyLifeBarLabel = new javax.swing.JLabel();
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(attack1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(attack2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(attack4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(attack3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        playerPokemonImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Back/25.png"))); // NOI18N

        enemy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/Alder-Sprite.png"))); // NOI18N

        playerLifeBarProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                playerLifeBarProgressBarStateChanged(evt);
            }
        });

        playerLifeBarLabel.setText("jLabel2");

        enemyPokemonImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Front/4.png"))); // NOI18N

        enemyLifeBarProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                enemyLifeBarProgressBarStateChanged(evt);
            }
        });

        enemyLifeBarLabel.setText("enemylife");

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
                                        .addComponent(enemyLifeBarProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(playerLifeBarProgressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pokemonName, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playerLifeBarLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(enemyLifeBarLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(enemyPokemonImage))))
                            .addComponent(playerPokemonImage))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(enemyPokemonImage)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(enemyPokemonName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enemyLifeBarLabel)
                            .addComponent(enemyLifeBarProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(pokemonName)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerLifeBarProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerLifeBarLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerPokemonImage))
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
        PokemonSwitch switcher = new PokemonSwitch(pokemonlist, playerLives, currentPokemon,this);
        switcher.setVisible(true);
    }//GEN-LAST:event_switchBtnActionPerformed

    private void changeUserPokemonImage(int number) {
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Back/" + number + ".png"));
        playerPokemonImage.setIcon(bbry);
    }

    private void changeEnemyImage(String Name) {
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Trainers/" + Name + "-sprite.png"));
        enemy.setIcon(bbry);
    }

    private void changeEnemyPokemonImage(int number) {
        ImageIcon bbry = new ImageIcon(getClass().getResource("/Pokemon-Java/Pokemon_Front/" + number + ".png"));
        enemyPokemonImage.setIcon(bbry);
    }
    private void attackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attackBtnActionPerformed
        switchBtn.setVisible(false);
        attackBtn.setVisible(false);
        attack1.setVisible(true);
        attack2.setVisible(true);
        attack3.setVisible(true);
        attack4.setVisible(true);
    }//GEN-LAST:event_attackBtnActionPerformed

    private void playerLifeBarProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_playerLifeBarProgressBarStateChanged

    }//GEN-LAST:event_playerLifeBarProgressBarStateChanged
    private boolean attack(String attackDamage, String attacker) throws SQLException {
        String type = "";
        String enemytype = "";
        int damage = 0;
        int value = Integer.parseInt(attackDamage.charAt(6) + "");
        double bonus = 1;
        if (attacker.equals("player")) {
            //getting the attack damage and type of the player pokemon
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, pokemonlist[currentPokemon] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                type = rs.getString("type" + value);
                System.out.println(type + "");
                damage = rs.getInt(attackDamage);
                conn.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
//            //getting the pokemon type of the enemy pokemon
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
//                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
//                pst.setString(1, enemypokemonList[counter_enemy] + "");
//                ResultSet rs = pst.executeQuery();
//                rs.next();
//                enemytype = rs.getString("Type");
//                System.out.println(enemytype + "");
//                conn.close();
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
//            }

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, enemyPokemonList[enemyPokemonCounter] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            enemytype = rs.getString("type" + value);
            System.out.println(enemytype + "");
            damage = rs.getInt(attackDamage);
            bonus = findBonus(enemytype, type);
            int life = enemyLives[enemyPokemonCounter];
            enemyLives[enemyPokemonCounter] = (int) (life - (damage * bonus));
            System.out.println("damage= " + damage);
            System.out.println("bonus= " + bonus);
            System.out.println("enemy life= " + enemyLives[enemyPokemonCounter]);
            enemyLifeBarProgressBar.setValue(enemyLives[enemyPokemonCounter] * 100 / rs.getInt("HP"));

            if (enemyLives[enemyPokemonCounter] > 0) {
                enemyLifeBarLabel.setText(enemyLives[enemyPokemonCounter] + "");
            } else {
                enemyLifeBarLabel.setText("0");
                return false;
            }
            conn.close();
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
                PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
                pst.setString(1, pokemonlist[0] + "");
                ResultSet rs = pst.executeQuery();
                rs.next();
                type = rs.getString("Type");
                System.out.println(type + "");
                conn.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, enemyPokemonList[enemyPokemonCounter] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            enemytype = rs.getString("type" + value);
            System.out.println(enemytype + "");
            damage = rs.getInt(attackDamage);
            bonus = findBonus(enemytype, type);
            int life = playerLives[currentPokemon];
            playerLives[currentPokemon] = (int) (life - (damage * bonus));
            System.out.println("damage= " + damage);
            System.out.println("bonus= " + bonus);
            System.out.println("player life= " + playerLives[currentPokemon]);
            playerLifeBarProgressBar.setValue((playerLives[currentPokemon] * 100 / playerMaxLives[currentPokemon]));
            if (playerLives[currentPokemon] > 0) {
                playerLifeBarLabel.setText(playerLives[currentPokemon] + "");
            } else {
                playerLifeBarLabel.setText("0");
                return false;
            }
            conn.close();
        }
        return true;
    }

    private void enemyLifeBarProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_enemyLifeBarProgressBarStateChanged

    }//GEN-LAST:event_enemyLifeBarProgressBarStateChanged
    private double findBonus(String type, String enemy) throws SQLException {
        double bonus = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from weakness where pokemon_type = ?");
            pst.setString(1, type + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            String strong = rs.getString("strong_against");
            String[] sArray = strong.split(" ");
            System.out.println("" + strong);
            System.out.println("" + sArray[0]);
            if (Arrays.asList(sArray).contains(enemy)) {
                System.out.println("strong");
                bonus = 2.0;
            }
            String weak = rs.getString("weak_against");
            String[] wArray = weak.split(" ");
            System.out.println("" + wArray[0]);
            if (Arrays.asList(wArray).contains(enemy)) {
                bonus = bonus / 2;
            }
            String noeffect = rs.getString("noeffect_against");
            String[] nArray = noeffect.split(" ");
            System.out.println("" + nArray);
            if (Arrays.asList(nArray).contains(enemy)) {
                bonus = 0;
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bonus;
    }
    private void attack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack1ActionPerformed
        beforeAttack(1);
    }//GEN-LAST:event_attack1ActionPerformed

    private void attack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack2ActionPerformed
        beforeAttack(2);
    }//GEN-LAST:event_attack2ActionPerformed

    private void attack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack3ActionPerformed
        beforeAttack(3);
    }//GEN-LAST:event_attack3ActionPerformed

    private void attack4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attack4ActionPerformed
        beforeAttack(4);
    }//GEN-LAST:event_attack4ActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        PokemonIntro a = null;
        attackBtn.setVisible(false);
        switchBtn.setVisible(false);
        if (nextBtn.getText().equals("Next")) {
            try {
                a = new PokemonIntro(user, (19 + (counter_enemy) * 2), gender);
            } catch (SQLException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (nextBtn.getText().equals("Exit")) {
            try {
                a = new PokemonIntro(user, (17 + (counter_enemy) * 2), gender);
            } catch (SQLException ex) {
                Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nextBtnActionPerformed

    public void beforeAttack(int count) {
        switchBtn.setVisible(true);
        attackBtn.setVisible(true);
        attack1.setVisible(false);
        attack2.setVisible(false);
        attack3.setVisible(false);
        attack4.setVisible(false);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst1 = conn.prepareStatement("Select * from moves where number = ?");
            pst1.setString(1, pokemonlist[currentPokemon] + "");
            ResultSet rs1 = pst1.executeQuery();
            rs1.next();
            PreparedStatement pst2 = conn.prepareStatement("Select * from moves where number = ?");
            pst2.setString(1, enemyPokemonList[enemyPokemonCounter] + "");
            ResultSet rs2 = pst2.executeQuery();
            rs2.next();
            Random rand = new Random();
            int value = rand.nextInt(4);
            if (rs2.getInt("damage" + (value + 1)) < rs1.getInt("damage" + count)) {
                if (enemyAttack(value) == true) {
                    if (attack("damage" + count, "player") == false) {
                        announce2.setText("The Enemy's  " + rs2.getString("name") + " has been defeated");
                        win++;
                        if (win == 6) {
                            nextBtn.setVisible(true);
                            nextBtn.setText("Next");
                        } else {
                            changeEnemyPokemon();
                        }
                    } else {
                        announce2.setText("Enemy pokemon first attacks");
                    }
                    announce.setText(rs1.getString("name") + " uses " + rs1.getString("attack" + count));
                } else {
                    announce2.setText("The Player's" + rs1.getString("name") + " has been defeated");
                    lose++;
                    PokemonSwitch switcher = new PokemonSwitch(pokemonlist, playerLives, currentPokemon,this);
                    switcher.setVisible(true);
                    switcher.setNotice("Your pokemon fainted, select another pokemon");
                    if (lose == 6) {
                        nextBtn.setVisible(true);
                        nextBtn.setText("Exit");
                    }
                }
            } else {
                announce.setText(rs1.getString("name") + " uses " + rs1.getString("attack" + count));
                if (attack("damage" + count, "player") == true) {
                    announce.setText(rs1.getString("name") + " uses " + rs1.getString("attack" + count));
                    if (enemyAttack(value) == false) {
                        announce2.setText("The Player's" + rs1.getString("name") + " has been defeated");
                        lose++;
                        if (lose == 6) {
                            nextBtn.setVisible(true);
                            nextBtn.setText("Exit");
                        }
                    }
                    announce2.setText("Player pokemon first attacks");
                } else {
                    announce2.setText("The Enemy's " + rs2.getString("name") + " has been defeated");
                    win++;
                    if (win == 6) {
                        nextBtn.setVisible(true);
                        nextBtn.setText("Next");
                    } else {
                        changeEnemyPokemon();
                    }
                }
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public void changeEnemyPokemon() {
        enemyPokemonCounter++;
        try {
            changeEnemyPokemonImage(enemyPokemonList[enemyPokemonCounter]);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, enemyPokemonList[enemyPokemonCounter] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            enemyPokemonName.setText(rs.getString("Name"));
            enemyLifeBarLabel.setText(rs.getInt("HP") + "");
            enemyLifeBarProgressBar.setValue(100);
            conn.close();
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
    private javax.swing.JLabel enemyLifeBarLabel;
    private javax.swing.JProgressBar enemyLifeBarProgressBar;
    private javax.swing.JLabel enemyPokemonImage;
    private javax.swing.JLabel enemyPokemonName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JLabel playerLifeBarLabel;
    private javax.swing.JProgressBar playerLifeBarProgressBar;
    private javax.swing.JLabel playerPokemonImage;
    private javax.swing.JLabel pokemonName;
    private javax.swing.JButton switchBtn;
    // End of variables declaration//GEN-END:variables

    private void initPokemon(String user, int pokemon_order) throws SQLException {
        changeEnemyImage(trainers[counter_enemy]);
//        System.out.println("marker");

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
            playerLifeBarLabel.setText(playerLives[pokemonNumber]+"");
            changeUserPokemonImage(pokemonlist[pokemonNumber]);
            changeEnemyPokemonImage(enemyPokemonList[enemyPokemonCounter]);
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int pokemonNum = counter_enemy;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");

            PreparedStatement pst = conn.prepareStatement("Select * from moves where Number = ?");
            pst.setString(1, enemyPokemonList[pokemonNum] + "");
            ResultSet rs = pst.executeQuery();
            rs.next();
            enemyPokemonName.setText(rs.getString("Name"));
            enemyLifeBarLabel.setText(enemyLifeBarProgressBar.getValue() * (rs.getInt("HP")) / 100 + "");
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void setPokemon(int current_pokemon) throws SQLException {
        initPokemon(user, current_pokemon);
        playerLifeBarProgressBar.setValue(playerLives[current_pokemon]*100/playerMaxLives[current_pokemon]);
    }

    private void initLives() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
//getting the life of the pokemons of the player
        PreparedStatement pst1 = conn.prepareStatement("Select * from moves where Number = ?");
        for (int i = 0; i < 6; i++) {
            pst1.setString(1, pokemonlist[i] + "");
            ResultSet rs = pst1.executeQuery();
            rs.next();
            playerLives[i] = Integer.parseInt(rs.getString("HP"));
            playerMaxLives[i] = Integer.parseInt(rs.getString("HP"));
        }
//getting the life of the pokemons of the enemy   
        PreparedStatement pst2 = conn.prepareStatement("Select * from moves where Number = ?");
        for (int i = 0; i < 6; i++) {
            pst2.setString(1, enemyPokemonList[i] + "");
            ResultSet rs = pst2.executeQuery();
            rs.next();
            enemyLives[i] = Integer.parseInt(rs.getString("HP"));
        }
        conn.close();
    }

    private void initPokemonLists() {
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
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
//        System.out.println("enemy marker");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select * from trainers where Name = ?");
            pst.setString(1, trainers[counter_enemy]);
            ResultSet rs = pst.executeQuery();
            rs.next();
            for (int i = 1; i <= 6; i++) {
                enemyPokemonList[i - 1] = Integer.parseInt(rs.getString("pokemon" + i));
                System.out.println(enemyPokemonList[i - 1]);
            }

//            System.out.println("image should have changed by now");
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
