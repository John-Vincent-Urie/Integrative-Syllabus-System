 package client;

import integrativeproject.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.nio.file.*;
import java.awt.Desktop;



public class Client extends javax.swing.JFrame {
    private File selectedFile;
    
    public Client() {
        initComponents();
        loadTableData();
        label_lang();
    }

   
   private void label_lang(){
       try (Connection conn = DBConnection.connectDB();
               PreparedStatement stmt = conn.prepareStatement("SELECT * FROM client WHERE client_id = ?")){
           stmt.setInt(1, Login_for_client.data);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name_client = rs.getString("client_name");
                name.setText(name_client);
            }
           } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Label: " + e.getMessage());
            e.printStackTrace();
        }
   }
   private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data
        
        try (Connection conn = DBConnection.connectDB();
             
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM client_courses WHERE client_id = ?")){
            
            
            stmt.setInt(1, Login_for_client.data);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("school_year"),
                    rs.getString("semester"),
                    rs.getString("course_code"),
                    rs.getString("course_title")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search_for_table = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        view_syllabus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        my_courses = new javax.swing.JButton();
        about_us = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        sign_out = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        delete_data = new javax.swing.JButton();
        show_data = new javax.swing.JButton();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("INSTRUCTOR SYLLABUS SYSTEM");

        search_for_table.setToolTipText("Search");
        search_for_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_for_tableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(search_for_table, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_for_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        view_syllabus.setBackground(new java.awt.Color(0, 0, 0));
        view_syllabus.setFont(new java.awt.Font("Sitka Small", 0, 16)); // NOI18N
        view_syllabus.setForeground(new java.awt.Color(255, 255, 255));
        view_syllabus.setText("VIEW SYLLABUS");
        view_syllabus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_syllabusActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/user.png"))); // NOI18N

        my_courses.setBackground(new java.awt.Color(0, 0, 0));
        my_courses.setFont(new java.awt.Font("Sitka Small", 0, 16)); // NOI18N
        my_courses.setForeground(new java.awt.Color(255, 255, 255));
        my_courses.setText("MY COURSES");
        my_courses.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        my_courses.setSelected(true);
        my_courses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                my_coursesActionPerformed(evt);
            }
        });

        about_us.setBackground(new java.awt.Color(0, 0, 0));
        about_us.setFont(new java.awt.Font("Sitka Small", 0, 16)); // NOI18N
        about_us.setForeground(new java.awt.Color(255, 255, 255));
        about_us.setText("ABOUT US");
        about_us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_usActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N

        sign_out.setBackground(new java.awt.Color(0, 0, 0));
        sign_out.setFont(new java.awt.Font("Sitka Small", 0, 16)); // NOI18N
        sign_out.setForeground(new java.awt.Color(255, 255, 255));
        sign_out.setText("SIGN OUT");
        sign_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_outActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view_syllabus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(my_courses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(about_us, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
            .addComponent(sign_out, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(view_syllabus, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(my_courses, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(about_us, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sign_out, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "School Year", "Semester", "Course Code", "Course Title"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        delete_data.setBackground(new java.awt.Color(0, 0, 0));
        delete_data.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        delete_data.setForeground(new java.awt.Color(255, 255, 255));
        delete_data.setText("DELETE");
        delete_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_dataActionPerformed(evt);
            }
        });

        show_data.setBackground(new java.awt.Color(0, 0, 0));
        show_data.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        show_data.setForeground(new java.awt.Color(255, 255, 255));
        show_data.setText("SHOW");
        show_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_dataActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(0, 0, 0));
        refresh.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(delete_data, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_data, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(show_data, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_data, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delete_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_dataActionPerformed
        // TODO add your handling code here:
    int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row first!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String courseCode = (String) jTable1.getValueAt(selectedRow, 2);
        
        try (Connection conn = DBConnection.connectDB();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM client_courses WHERE course_code = ?")
        ) {
            pstmt.setString(1, courseCode);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Record deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "No record found for the given course code.");
            }
            
            this.dispose();
            Client hello = new Client();
            hello.setVisible(true);
            hello.setLocationRelativeTo(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting record: " + e.getMessage());
        }
    }//GEN-LAST:event_delete_dataActionPerformed

    private void search_for_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_for_tableActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_search_for_tableActionPerformed

    private void show_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_dataActionPerformed
    int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row first!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String courseCode = (String) jTable1.getValueAt(selectedRow, 2); // Get Course Code from Table

    try (Connection conn = DBConnection.connectDB();
         PreparedStatement stmt = conn.prepareStatement("SELECT doc_file FROM client_courses WHERE course_code = ?")) {

        stmt.setString(1, courseCode);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()){
            byte[] pdfdata = rs.getBytes("doc_file");
            
            Path tempFile = Files.createTempFile("syllabus_", ".pdf");
            Files.write(tempFile, pdfdata);
            
            if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(tempFile.toFile());
                } else {	
                    System.out.println("Desktop is not supported.");
                }
        }else {
                System.out.println("PDF not found.");
            }
        

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error opening file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
        
    }//GEN-LAST:event_show_dataActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Client hello = new Client();
        hello.setVisible(true);
        hello.setLocationRelativeTo(null);
    }//GEN-LAST:event_refreshActionPerformed

    private void view_syllabusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_syllabusActionPerformed
        // TODO add your handling code here:
        this.dispose();  
        view_syllabus ins = new view_syllabus(); 
        ins.setVisible(true);
        ins.setLocationRelativeTo(null);
    }//GEN-LAST:event_view_syllabusActionPerformed

    private void my_coursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_my_coursesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_my_coursesActionPerformed

    private void about_usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_about_usActionPerformed

    private void sign_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_outActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sign_outActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton about_us;
    private javax.swing.JButton delete_data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton my_courses;
    private javax.swing.JLabel name;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField search_for_table;
    private javax.swing.JButton show_data;
    private javax.swing.JButton sign_out;
    private javax.swing.JButton view_syllabus;
    // End of variables declaration//GEN-END:variables
}