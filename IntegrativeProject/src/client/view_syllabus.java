 package client;

import integrativeproject.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.nio.file.*;
import java.awt.Desktop;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class view_syllabus extends javax.swing.JFrame {
    private File selectedFile;
    private int tabCount = 1;
    private Map<String, DefaultTableModel> tabModels = new HashMap<>();
    private TableRowSorter<TableModel> sorter;
    
    public view_syllabus() {
        initComponents();
        loadSavedTabs();
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
    private void loadSavedTabs() {
    try (Connection conn = DBConnection.connectDB();
         PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tabbed")) {

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String tabName = rs.getString("tab_name");
            addTabWithCourseTable(tabName);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading saved tabs: " + e.getMessage());
    }
}
    
    private void addTabWithCourseTable(String tabName) {
    
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new Object[]{"School Year", "Semester", "Course Code", "Course Title"});
    
    JTable tabTable = new JTable(model);
    loadTableData(model, tabName); 
    
    JScrollPane scrollPane = new JScrollPane(tabTable);
    JPanel tabPanel = new JPanel(new BorderLayout());
    tabPanel.add(scrollPane, BorderLayout.CENTER);

    tabsyllabus.addTab(tabName, tabPanel);
    tabModels.put(tabName, model); 

}
    
   private void loadTableData(DefaultTableModel model, String tabName) {
        model.setRowCount(0);
        
        try (Connection conn = DBConnection.connectDB()) {
        String sql = "SELECT c.school_year, c.semester, c.course_code, c.course_title " +
                     "FROM courses c " +
                     "JOIN tabbed t ON c.tab_id = t.tab_id " +
                     "WHERE t.tab_name = ?" ;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tabName);
            ResultSet rs = stmt.executeQuery();
      
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("school_year"),
                    rs.getString("semester"),
                    rs.getString("course_code"),
                    rs.getString("course_title")
                });
            }}
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
        delete_data1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        show_data = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        tabsyllabus = new javax.swing.JTabbedPane();
        move = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        view_syllabus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        my_courses = new javax.swing.JButton();
        about_us = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        sign_out = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("INSTRUCTOR SYLLABUS SYSTEM");

        search_for_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_for_tableActionPerformed(evt);
            }
        });

        delete_data1.setBackground(new java.awt.Color(0, 0, 0));
        delete_data1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        delete_data1.setForeground(new java.awt.Color(255, 255, 255));
        delete_data1.setText("MENU");
        delete_data1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_data1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(delete_data1)
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(search_for_table, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_for_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(delete_data1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

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

        move.setBackground(new java.awt.Color(0, 0, 0));
        move.setForeground(new java.awt.Color(255, 255, 255));
        move.setText("MOVE TO COURSES");
        move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabsyllabus, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(show_data, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(move)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabsyllabus, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(show_data, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(move, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        view_syllabus.setBackground(new java.awt.Color(0, 0, 0));
        view_syllabus.setFont(new java.awt.Font("Sitka Small", 0, 16)); // NOI18N
        view_syllabus.setForeground(new java.awt.Color(255, 255, 255));
        view_syllabus.setText("VIEW SYLLABUS");
        view_syllabus.setSelected(true);
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
            .addComponent(view_syllabus, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
            .addComponent(my_courses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(about_us, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(view_syllabus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(my_courses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(about_us, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sign_out, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_for_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_for_tableActionPerformed
        // TODO add your handling code here:
        int selectedTabIndex = tabsyllabus.getSelectedIndex();
    if (selectedTabIndex == -1) {
        JOptionPane.showMessageDialog(this, "No tab is selected.");
        return;
    }

    JScrollPane scrollPane = (JScrollPane) ((JPanel) tabsyllabus.getComponentAt(selectedTabIndex)).getComponent(0);
    JTable currentTable = (JTable) scrollPane.getViewport().getView();

    if (sorter == null || sorter.getModel() != currentTable.getModel()) {
        sorter = new TableRowSorter<>(currentTable.getModel());
        currentTable.setRowSorter(sorter);

        search_for_table.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filter(); }
            public void removeUpdate(DocumentEvent e) { filter(); }
            public void changedUpdate(DocumentEvent e) { filter(); }

            private void filter() {
                String text = search_for_table.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });
    }

    // Trigger filter once on Enter key (optional)
    String text = search_for_table.getText();
    sorter.setRowFilter(text.trim().length() == 0 ? null : RowFilter.regexFilter("(?i)" + text));
        
    }//GEN-LAST:event_search_for_tableActionPerformed

    private void show_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_dataActionPerformed
    int selectedTabIndex = tabsyllabus.getSelectedIndex();
    if (selectedTabIndex == -1) {
        JOptionPane.showMessageDialog(this, "No tab is selected.");
        return;
    }

    // Get tab name and table model
    String tabName = tabsyllabus.getTitleAt(selectedTabIndex);
    DefaultTableModel model = tabModels.get(tabName);

    // Get table from selected tab panel
    JScrollPane scrollPane = (JScrollPane) ((JPanel) tabsyllabus.getComponentAt(selectedTabIndex)).getComponent(0);
    JTable currentTable = (JTable) scrollPane.getViewport().getView();

    int selectedRow = currentTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row first!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String courseCode = (String) currentTable.getValueAt(selectedRow, 2); 

    try (Connection conn = DBConnection.connectDB();
         PreparedStatement stmt = conn.prepareStatement("SELECT doc_file FROM courses WHERE course_code = ?")) {

        stmt.setString(1, courseCode);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            byte[] pdfdata = rs.getBytes("doc_file");

            Path tempFile = Files.createTempFile("syllabus_", ".pdf");
            Files.write(tempFile, pdfdata);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(tempFile.toFile());
            } else {
                System.out.println("Desktop is not supported.");
            }
        } else {
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
        view_syllabus hello = new view_syllabus();
        hello.setVisible(true);
        hello.setLocationRelativeTo(null);
    }//GEN-LAST:event_refreshActionPerformed

    private void delete_data1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_data1ActionPerformed
        // TODO add your handling code here:
        this.dispose();  
        Instructor1 ins = new Instructor1(); 
        ins.setVisible(true);
        ins.setLocationRelativeTo(null);
    }//GEN-LAST:event_delete_data1ActionPerformed

    private void moveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveActionPerformed
        int selectedTabIndex = tabsyllabus.getSelectedIndex();
    if (selectedTabIndex == -1) {
        JOptionPane.showMessageDialog(this, "No tab is selected.");
        return;
    }

    String tabName = tabsyllabus.getTitleAt(selectedTabIndex);
    DefaultTableModel model = tabModels.get(tabName);

    // Get the table in the selected tab
    JScrollPane scrollPane = (JScrollPane) ((JPanel) tabsyllabus.getComponentAt(selectedTabIndex)).getComponent(0);
    JTable currentTable = (JTable) scrollPane.getViewport().getView();

    int selectedRow = currentTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row first!", "Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    String courseCode = (String) currentTable.getValueAt(selectedRow, 2); 

    try (Connection conn = DBConnection.connectDB();
     PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM courses WHERE course_code = ?")) {

    pstmt.setString(1, courseCode);
    ResultSet rs = pstmt.executeQuery();

    if (rs.next()) {
        String school_y = rs.getString("school_year");
        String semi = rs.getString("semester");
        String code = rs.getString("course_code");
        String title = rs.getString("course_title");
        byte[] pdfdata = rs.getBytes("doc_file");

        try (PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO client_courses (school_year, semester, course_code, course_title, client_id, doc_file) VALUES (?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, school_y);
            stmt.setString(2, semi);
            stmt.setString(3, code);
            stmt.setString(4, title);
            stmt.setInt(5, Login_for_client.data); // user ID
            stmt.setBytes(6, pdfdata);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Record saved successfully!");

            // Refresh table view
            loadTableData(tabModels.get(tabName), tabName);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "No record found for the given course code.");
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error loading record: " + e.getMessage());
}

        
    }//GEN-LAST:event_moveActionPerformed

    private void view_syllabusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_syllabusActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_view_syllabusActionPerformed

    private void my_coursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_my_coursesActionPerformed
        // TODO add your handling code here:
        this.dispose();
       Client cl = new Client();
       cl.setVisible(true);
       cl.setLocationRelativeTo(null);
    }//GEN-LAST:event_my_coursesActionPerformed

    private void about_usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_about_usActionPerformed

    private void sign_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_outActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sign_outActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton about_us;
    private javax.swing.JButton delete_data1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton move;
    private javax.swing.JButton my_courses;
    private javax.swing.JLabel name;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField search_for_table;
    private javax.swing.JButton show_data;
    private javax.swing.JButton sign_out;
    private javax.swing.JTabbedPane tabsyllabus;
    private javax.swing.JButton view_syllabus;
    // End of variables declaration//GEN-END:variables
}
