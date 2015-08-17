/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaac
 */

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class info_cmp extends javax.swing.JFrame {

    /**
     * Creates new form info_cmp
     * 
     */
    
    Connection conn = null ; 
    ResultSet rs = null ; 
    PreparedStatement pst = null ; 
    ResultSet rs1 = null ; 
    PreparedStatement pst1 = null ; 
    
    
    public info_cmp() {
        initComponents();
        conn = javaconnect.ConnectDb();
        Update_table();
        currentDate ();
        Fill_com ();
        fill_com1();
        fill_com2();
    }

    private void Update_table() { //  fill the table  complet 
   
   try {
        
    String sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos";
    pst=conn.prepareStatement(sql);
    rs = pst.executeQuery();
    cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
    cmp_tab.getColumnModel().getColumn(0).setWidth(40);
    cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
    cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
    cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
   
    
   } catch (Exception e) {
   
      JOptionPane.showMessageDialog(null, e);
   
   }finally {
     try{
        rs.close(); 
        pst.close(); }
        catch(Exception e) { } 
           }

        
    }
    
    
    
    
    
    
          
   private void Fill_com () { //  fill the  box  ID  ta3 SELECT  ID    BOOM BOOM 
   
   try {
   
   String sql = "select * from cmp_infos";
   pst=conn.prepareStatement(sql);
        
   rs = pst.executeQuery();
   
   while(rs.next()){
   
       
       String name = rs.getString("ID");
       
        if (((DefaultComboBoxModel)box_cmp.getModel()).getIndexOf(name) == -1) {
          
      
      box_cmp.addItem(name);
      
          
      }
     
       
   
   }
   }catch (Exception e) {
   
       
       JOptionPane.showMessageDialog(null, "catch ta3 fill_com  LI T3aMER select id  ");
       
   
   }
   
   
   } 
   
    
   private  void  fill_com1 () { //  FILL COMBOBOX   DE CATEGORIE    
       
       // VIEULLEZ   SELECTIONNEZ  UNE  CATEGORIE  
   
   try {
   
   
   String sql = "select * from cmp_infos";
   pst=conn.prepareStatement(sql);
   rs = pst.executeQuery();
    
   String sql1 = "select COUNT(*)  from cmp_infos";
      pst1 =conn.prepareStatement(sql1);
      rs1 = pst1.executeQuery();
   int num ; 
      num = 0 ;
    if(rs1.next()) {
      num = rs1.getInt(1);
      }
      
     
   com1.addItem("all §( "+num+" )§");
   String activite;
   while(rs.next()){
   
      activite = rs.getString("activite");
      
      sql1 = "select COUNT(*)  from cmp_infos WHERE activite='"+activite+"'";
      pst1 =conn.prepareStatement(sql1);
      rs1 = pst1.executeQuery();

      
      
      if("".equals(activite)) {
          activite = "vide";
          
          }
      
      
      
      if(rs1.next()) {
      num = rs1.getInt(1);
      }
      
      activite = activite+" §( "+num+" )§";
      if (((DefaultComboBoxModel)com1.getModel()).getIndexOf(activite) == -1) {
          

          com1.addItem(activite);

          
      }
   
   
   
   }
   
   
   
   }catch (Exception e) {
   
   JOptionPane.showMessageDialog(null, e);
   JOptionPane.showMessageDialog(null, "ERROR   CAN'T  FILL COMBOBOX  OF CATEGORIE SELECT ACTIVITE  9IIOO ");
   
   }
   
   
   }
    
   
   
   
      
   private  void  fill_com2 () { // FILL COMBOBOX   TA3  INFORMQTIONS    DISPLAY JTEXFIELD WHEN CLICK  WITH THE MOUSE 
   
   try {
       
       
       
    if (((DefaultComboBoxModel)com2.getModel()).getIndexOf("New ") == -1 && ((DefaultComboBoxModel)com2.getModel()).getIndexOf("New") == -1) {
          
      
      com2.addItem("New");
      
          
      }   
   
   String sql = "select * from cmp_infos";
   pst=conn.prepareStatement(sql);
   rs = pst.executeQuery();
   
   while(rs.next()){
   
      String activite = rs.getString("activite");
      
      if("".equals(activite)) {
          activite = "vide";
          
          }
      
      if (((DefaultComboBoxModel)com2.getModel()).getIndexOf(activite) == -1) {
          
      
      com2.addItem(activite);
      
          
      }
   
   
   
   }
   
   
   
   }catch (Exception e) {
   
   JOptionPane.showMessageDialog(null, e);
   
   }
   
   
   }
   
   
   
      public void close() {
      
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    
    
    }
    
    
    
       public void currentDate () {
      
      Calendar cal = new  GregorianCalendar();
      int month = cal.get(Calendar.MONTH);
      int year = cal.get(Calendar.YEAR);
      int day = cal.get(Calendar.DAY_OF_MONTH);
      
      
      date1.setText(day+"/"+(month + 1)+"/"+year);
      
      int second = cal.get(Calendar.SECOND);
      int minut = cal.get(Calendar.MINUTE);
      int hour  = cal.get(Calendar.HOUR);
      
      time1.setText(hour+":"+minut+":"+second);
      
      
      
      
      }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cmp_tab = new javax.swing.JTable();
        search_b = new javax.swing.JButton();
        com1 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        box_cmp = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        search_txt = new javax.swing.JTextField();
        search_com = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jWEB = new javax.swing.JTextField();
        jEMA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTEL = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jFON = new javax.swing.JTextField();
        jADR = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCON = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMOB = new javax.swing.JTextField();
        jENT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        com2 = new javax.swing.JComboBox();
        add = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        lab1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        date1 = new javax.swing.JMenu();
        time1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("companies_infos");

        cmp_tab.setBackground(new java.awt.Color(0, 0, 0));
        cmp_tab.setForeground(new java.awt.Color(0, 102, 0));
        cmp_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        cmp_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmp_tabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cmp_tab);

        search_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Zoom-icon.png"))); // NOI18N
        search_b.setText("chercher");
        search_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_bActionPerformed(evt);
            }
        });

        com1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                com1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buttons", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 255))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trash-mail-icon.png"))); // NOI18N
        jButton1.setText("supprimer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Clear-icon.png"))); // NOI18N
        jButton5.setText("vider");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setText("SELECT ID ");

        box_cmp.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                box_cmpPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        box_cmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_cmpActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Actions-document-save-icon.png"))); // NOI18N
        jButton3.setText("enregistrer ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user-add-icon.png"))); // NOI18N
        jButton4.setText("Ajouter");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(box_cmp, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 119, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(box_cmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel11.setText("sélectionner une catégorie");

        search_com.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TOUTES", "ENTREPRISE", "CONTACT", "TEL_FAX", "Mobile", "EMAIL", "ADRESSE", "FONCTION", "website", "activite" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel2.setText("CONTACT");

        jLabel4.setText("Mobile");

        jLabel5.setText("E-MAIL");

        jLabel8.setText("ADRESSE");

        jLabel9.setText("FONCTION");

        jLabel6.setText("website");

        jLabel1.setText("ENTREPRISE");

        jLabel3.setText("TEL_FAX");

        jLabel12.setText("ACTIVITE");

        com2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                com2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(jENT)
                    .addComponent(jCON)
                    .addComponent(jMOB)
                    .addComponent(jEMA)
                    .addComponent(jWEB)
                    .addComponent(jADR)
                    .addComponent(jFON)
                    .addComponent(com2, 0, 294, Short.MAX_VALUE)
                    .addComponent(jTEL))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jENT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jMOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jEMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jWEB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jADR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(com2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Refresh-icon.png"))); // NOI18N
        jButton2.setText("ACTUALISER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lab1.setForeground(new java.awt.Color(0, 102, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data-management-icon.png"))); // NOI18N

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New ");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Button-Close-icon.png"))); // NOI18N
        jMenuItem2.setText("Exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        date1.setText("Date");
        jMenuBar1.add(date1);

        time1.setText("Time");
        jMenuBar1.add(time1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(com1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_com, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_b, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(lab1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(com1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_b)
                        .addComponent(search_com, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        close();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void cmp_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmp_tabMouseClicked
        // TODO add your handling code here:
       
              try {
        
        int row = cmp_tab.getSelectedRow();
        String Table_click = (cmp_tab.getModel().getValueAt(row, 0).toString());
        
        String sql = "select * from cmp_infos where ID='"+Table_click+"'";
        pst=conn.prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        if(rs.next()){
        
        ID_1.id = Integer.parseInt(rs.getString("ID"));
        String add9 = rs.getString("ID");
        
        String add1 = rs.getString("ENTREPRISE");
        jENT.setText(add1);
        
        String add2 = rs.getString("CONTACT");
        jCON.setText(add2);
        
        String add3 = rs.getString("TEL_FAX");
        jTEL.setText(add3);
        
        String add4 = rs.getString("Mobile");
        jMOB.setText(add4);
        
        String add5 = rs.getString("EMAIL");
        jEMA.setText(add5);
       
        String add6 = rs.getString("FONCTION");
        jFON.setText(add6);
        
        String add8 = rs.getString("website");
        jWEB.setText(add8);
        String add10 = rs.getString("ADRESSE");
        jADR.setText(add10);
        
        com2.removeAllItems();
        com2.addItem(rs.getString("activite"));
        fill_com2();
       
        
        
       box_cmp.removeAllItems();
       box_cmp.addItem(add9);
       
       Fill_com();
        
        
        
        
        
        }else {
        
           JOptionPane.showMessageDialog(null,"nothinnnnnnnnnnnnnnnnnnnnnnnnnnng");
        
        }
        
        
        }catch(Exception e) {
        
        JOptionPane.showMessageDialog(null,e);
        
        }
        
        
    }//GEN-LAST:event_cmp_tabMouseClicked

    private void box_cmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_cmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_cmpActionPerformed

    private void box_cmpPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_box_cmpPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
             String tmp = (String )box_cmp.getSelectedItem();
        String sql = "select * from cmp_infos where ID=?";
        
        
        try {
        
        pst=conn.prepareStatement(sql);
        
        pst.setString(1,tmp);
        
        
        rs = pst.executeQuery();
        
        if(rs.next()){
        
        String add1 = rs.getString("ENTREPRISE");
        jENT.setText(add1);
        
        String add2 = rs.getString("CONTACT");
        jCON.setText(add2);
        
        String add3 = rs.getString("TEL_FAX");
        jTEL.setText(add3);
        
        String add4 = rs.getString("Mobile");
        jMOB.setText(add4);
        
        String add5 = rs.getString("EMAIL");
        jEMA.setText(add5);
       
        String add6 = rs.getString("FONCTION");
        jFON.setText(add6);
        
        String add8 = rs.getString("website");
        jWEB.setText(add8);
        
        ID_1.id=Integer.parseInt(rs.getString("ID"));
       
        
        
        
        } else {
        
           
          JOptionPane.showMessageDialog(null,"no Result ");
            
        
        }
        
            
            
            
            
        }catch (Exception e ){
        
        JOptionPane.showMessageDialog(null,e);
        
        
        }
        
        
    }//GEN-LAST:event_box_cmpPopupMenuWillBecomeInvisible

    private void com1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_com1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        
        //   we have  all  vide et loukhrine  sama  3  dir fi balleuk bali  act == vide mais el content is "" empty  nigaaa 
        String act = (String)com1.getSelectedItem();
        String[] req;
        req = act.split("§");
        act  = req[0];
        
        if(!"all ".equals(act) && !"vide ".equals(act)) {
        
        try {
 
            String sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where activite=?";
            pst=conn.prepareStatement(sql);
             
            pst.setString(1,act);
            rs = pst.executeQuery();
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            //When I wrote this, only God and I understood what I was doing

            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
            //Now, God only knows
            // Li djaat  djaat  
      
         
        }catch(Exception e) {
        
        JOptionPane.showMessageDialog(null,e);
        
        
        }
        } else if ("vide ".equals(act)) {
        
         
        try {
         
         
            String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where activite='' ";
            pst=conn.prepareStatement(sql);
            
            
            rs = pst.executeQuery();
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
        
          
         
        }catch(Exception e) {
        
        JOptionPane.showMessageDialog(null,e);
        
        
        }
        
        } else {
        

        Update_table();
        
        }
        
    }//GEN-LAST:event_com1PopupMenuWillBecomeInvisible

    
    private  void delete (int id) {
    
    
    try {
    
    
      int  p = JOptionPane.showConfirmDialog(null,"Êtes-vous sûr de vouloir supprimer ? ","supprimer", JOptionPane.YES_NO_OPTION);
    
      if (p==0) {
          
         try {
         
             String sql = "DELETE FROM cmp_infos WHERE ID=?";
             pst=conn.prepareStatement(sql);
             pst.setInt(1,id);
             pst.executeUpdate();
             Update_table();
             Fill_com();
             fill_com1();
             fill_com2();
             
         
         
         }catch(Exception e){
         
         JOptionPane.showMessageDialog(null, e);
         
         
         } 
          
      
      
      
      
      }
    
    
    
    }catch (Exception e) {
    
    
    JOptionPane.showMessageDialog(null, e);
    
    
    }
    
    
    
    
    
    }
    
    
    private void search_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_bActionPerformed
        // TODO add your handling code here:
        
        
        String s =(String) com1.getSelectedItem();
        
        String[] req;
        req = s.split("§");
        s  = req[0];
        
        if ("all".equals(s) || "all ".equals(s)) {
        
        String search = search_txt.getText();
        if("\'".equals(search)){
        
        JOptionPane.showMessageDialog(null,"LoL Noob DETECTED   are you trying  SQl injection :D ");
        
        
        }
        
        search = search.replace("\'","\\\'");
        String column = (String )search_com.getSelectedItem();
        
        
       if  (!"".equals(search)) {
        
        
        if (!"TOUTES".equals(column)) {
        
        try {
        
        
        String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where "+column+" like '%"+search+"%'";

            
             
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
        
        } catch (Exception e) {
        
  
        JOptionPane.showMessageDialog(null,e);
        
        
        
        } 
        
        
        } else  {
        
        
            
         try {   
            
        String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where ENTREPRISE like \'%"+search+"%\' or CONTACT like \'%"+search+"%\' or TEL_FAX LIKE \'%"+search+"%\' OR Mobile like \'%"+search+"%\' or EMAIL  like \'%"+search+"%\'  OR ADRESSE  LIKE \'%"+search+"%\'  OR  FONCTION LIKE \'%"+search+"%\' OR website  like \'%"+search+"%\' or activite like \'%"+search+"%\' or ID like \'%"+search+"%\' ";
        
        
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
         
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
 
         } catch (Exception e) {
         
         
              JOptionPane.showMessageDialog(null, e);
             
         
         } 
    
        
        
        } } 
       
       
       else {
           
           
           
        if (!"TOUTES".equals(column))   {
           try {
        
        
        String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where "+column+" like '' ";

            
             
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
        
        } catch (Exception e) {
        
    
        JOptionPane.showMessageDialog(null,e);
        
        
        
        } } else { 
            
            
                   
         try {   
            
        String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where ENTREPRISE='' or CONTACT='' or TEL_FAX='' OR Mobile ='' or EMAIL=''  OR  ADRESSE=''  OR  FONCTION='' OR website='' or activite='' or ID='' ";
        
        
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
       
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
 
         } catch (Exception e) {
         
         
              JOptionPane.showMessageDialog(null, e);
             
         
         } 
            
            
       
        }
       
       }
        
        
    } else {
        
        
        if ("vide".equals(s) || "vide ".equals(s)) {
        
        s ="";
        }
        String search = search_txt.getText();
        if("\'".equals(search)){
        
        JOptionPane.showMessageDialog(null,"LoL Noob DETECTED   are you trying  SQl injection :D ");
        
        
        }
        
        search = search.replace("\'","\\\'");
        String column = (String )search_com.getSelectedItem();
        
        
       if  (!"".equals(search)) {
        
        
        if (!"TOUTES".equals(column)) {
        
        try {
        
        
        String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where "+column+" like '%"+search+"%' AND activite='"+s+"'";

            
             
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
        
        } catch (Exception e) {
        
  
        JOptionPane.showMessageDialog(null,e);
        
        
        
        } 
        
        
        } else  {
        
        
            
         try {   
            
        String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where ENTREPRISE like \'%"+search+"%\' or CONTACT like \'%"+search+"%\' or TEL_FAX LIKE \'%"+search+"%\' OR Mobile like \'%"+search+"%\' or EMAIL  like \'%"+search+"%\'  OR ADRESSE  LIKE \'%"+search+"%\'  OR  FONCTION LIKE \'%"+search+"%\' OR website  like \'%"+search+"%\' or activite like \'%"+search+"%\' or ID like \'%"+search+"%\' AND activite='"+s+"' ";
        
        
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
         
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
 
         } catch (Exception e) {
         
         
              JOptionPane.showMessageDialog(null, e);
             
         
         } 
    
        
        
        } } 
       
       
       else {
           
           
           
        if (!"TOUTES".equals(column))   {
           try {
        
        
        String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where "+column+" like '' AND activite='"+s+"' ";

            
             
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
        
        } catch (Exception e) {
        
    
        JOptionPane.showMessageDialog(null,e);
        
        
        
        } } else { 
            
            
                   
         try {   
            
        String sql;
            sql = "select ID,ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite from cmp_infos where ENTREPRISE='' or CONTACT='' or TEL_FAX='' OR Mobile ='' or EMAIL=''  OR  ADRESSE=''  OR  FONCTION='' OR website='' or activite='' or ID='' AND activite='"+s+"'";
        
        
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            cmp_tab.setModel(DbUtils.resultSetToTableModel(rs));
            cmp_tab.getColumnModel().getColumn(0).setWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMaxWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setMinWidth(40);
            cmp_tab.getColumnModel().getColumn(0).setPreferredWidth(40);
 
         } catch (Exception e) {
         
         
              JOptionPane.showMessageDialog(null, e);
             
         
         } 
            
            
       
        }
       
       }
        
        
        
        
        }
        
        

  
    }//GEN-LAST:event_search_bActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       Update_table();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
// TODO add your handling code here:
      delete(ID_1.id); 
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       
        String val1 = jENT.getText();
        String val2 = jCON.getText();
        String val3 = jTEL.getText();
        String val4 = jMOB.getText();
        String val5 = jEMA.getText();
        String val6 = jWEB.getText();
        String val7 = jADR.getText();
        String val8 = jFON.getText();
        String val9 = (String)com2.getSelectedItem();
        if ("New".equals(val9)) {
        
         val9 = add.getText();
        
        }
        int val10 = ID_1.id;
        
        int  p = JOptionPane.showConfirmDialog(null,"Êtes-vous sûr de vouloir modifier ? ","modifier", JOptionPane.YES_NO_OPTION);
        
        if (p==0){
        
        try {
        
        String sql = "UPDATE cmp_infos SET ENTREPRISE=?,CONTACT=?,TEL_FAX=?,Mobile=?,EMAIL=?,ADRESSE=?,FONCTION=?,website=?,activite=? WHERE  ID=?";
        
        pst = conn.prepareStatement(sql);
        
        pst.setString(1, val1);
        pst.setString(2, val2);
        pst.setString(3, val3);
        pst.setString(4, val4);
        pst.setString(5, val5);
        pst.setString(6, val6);
        pst.setString(7, val7);
        pst.setString(8, val8);
        pst.setString(9, val9);
        pst.setInt(10, val10);
        
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"modifié");
        Update_table();
     
             Fill_com();
             fill_com1();
             fill_com2();
        
        
        } catch (SQLException | HeadlessException e) {
        
        
        JOptionPane.showMessageDialog(null,e);
        
        
        }
        
        
        
        
        
        
        
        
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        
       jENT.setText("");
       jCON.setText("");
       jMOB.setText("");
       jEMA.setText("");
       jADR.setText("");
       jFON.setText("");
       jWEB.setText("");
       jTEL.setText("");
       com2.removeAllItems();
       com2.addItem("New");
       fill_com2();
       
       
       
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void com2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_com2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (com2.getSelectedItem()=="New") {
        
          add.setText("veuillez saisir une nouvelle activité ");
            
        } else {
        
        add.setText("");
        
        }
        
    }//GEN-LAST:event_com2PopupMenuWillBecomeInvisible

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        try {
        
          String val1 = jENT.getText();
        String val2 = jCON.getText();
        String val3 = jTEL.getText();
        String val4 = jMOB.getText();
        String val5 = jEMA.getText();
        String val6 = jWEB.getText();
        String val7 = jADR.getText();
        String val8 = jFON.getText();
        String val9 = (String)com2.getSelectedItem();
        if ("New".equals(val9)) {
        
         val9 = add.getText();
        
        }   
            
        String sql = "INSERT  INTO cmp_infos(ENTREPRISE,CONTACT,TEL_FAX,Mobile,EMAIL,ADRESSE,FONCTION,website,activite) VALUES(?,?,?,?,?,?,?,?,?)";
        pst=conn.prepareStatement(sql);
        
        pst.setString(1, val1);
        pst.setString(2, val2);
        pst.setString(3, val3);
        pst.setString(4, val4);
        pst.setString(5, val5);
        pst.setString(6, val7);
        pst.setString(7, val8);
        pst.setString(8, val6);
        pst.setString(9, val9);
       
        
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"ajouté");
        
        Update_table();
        fill_com1();
      
             Fill_com();
           
             fill_com2();
        
        
        
        } catch (Exception e) {
        
        
        JOptionPane.showMessageDialog(null,e);
        
        
        
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(info_cmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(info_cmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(info_cmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(info_cmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new info_cmp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField add;
    private javax.swing.JComboBox box_cmp;
    private javax.swing.JTable cmp_tab;
    private javax.swing.JComboBox com1;
    private javax.swing.JComboBox com2;
    private javax.swing.JMenu date1;
    private javax.swing.JTextField jADR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextField jCON;
    private javax.swing.JTextField jEMA;
    private javax.swing.JTextField jENT;
    private javax.swing.JTextField jFON;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jMOB;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTEL;
    private javax.swing.JTextField jWEB;
    private javax.swing.JLabel lab1;
    private javax.swing.JButton search_b;
    private javax.swing.JComboBox search_com;
    private javax.swing.JTextField search_txt;
    private javax.swing.JMenu time1;
    // End of variables declaration//GEN-END:variables

    private int getIndexOf(String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
