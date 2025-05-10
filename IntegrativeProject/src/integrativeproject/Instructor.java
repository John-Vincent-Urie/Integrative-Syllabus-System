 package integrativeproject;

import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.nio.file.*;
import java.awt.Desktop;
import integrativeproject.Login;
import java.util.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class Instructor extends javax.swing.JFrame {
    private File selectedFile;
    private int tabCount = 1;
    private Map<String, DefaultTableModel> tabModels = new HashMap<>();
    private TableRowSorter<TableModel> sorter;
    
    public Instructor() {
        initComponents();
        loadSavedTabs();
    }

    static Login get = new Login();
    
    private void loadSavedTabs() {
    try (Connection conn = DBConnection.connectDB();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT tab_name FROM tabbed")) {

        while (rs.next()) {
            String tabName = rs.getString("tab_name");
            addTabWithCourseTable(tabName);
            tabs.addItem(tabName);
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
                     "WHERE t.tab_name = ? AND user_id = ?" ;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tabName);
            stmt.setInt(2, get.data);
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
        jPanel2 = new javax.swing.JPanel();
        sy = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        course_c = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        course_t = new javax.swing.JTextField();
        b_submit = new javax.swing.JButton();
        b_file = new javax.swing.JButton();
        sem = new javax.swing.JComboBox<>();
        tabs = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        delete_data = new javax.swing.JButton();
        show_data = new javax.swing.JButton();
        Logout1 = new javax.swing.JButton();
        tabsyllabus = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();
        delete_TAB = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        sy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("SCHOOL YEAR");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("SEMESTER");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("COURSE CODE");

        course_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_cActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("COURSE TITLE");

        course_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_tActionPerformed(evt);
            }
        });

        b_submit.setBackground(new java.awt.Color(0, 0, 0));
        b_submit.setForeground(new java.awt.Color(255, 255, 255));
        b_submit.setText("SUBMIT");
        b_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_submitActionPerformed(evt);
            }
        });

        b_file.setBackground(new java.awt.Color(0, 0, 0));
        b_file.setForeground(new java.awt.Color(255, 255, 255));
        b_file.setText("CHOOSE FILE");
        b_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_fileActionPerformed(evt);
            }
        });

        sem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "Summer" }));
        sem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semActionPerformed(evt);
            }
        });

        tabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabsActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("TYPE OF SYLLABUS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(sy, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(course_c, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(course_t, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_file, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sem, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sy, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(course_c, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(course_t, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_file, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

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

        Logout1.setBackground(new java.awt.Color(0, 0, 0));
        Logout1.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        Logout1.setForeground(new java.awt.Color(255, 255, 255));
        Logout1.setText("Refresh");
        Logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD TAB");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        delete_TAB.setBackground(new java.awt.Color(0, 0, 0));
        delete_TAB.setFont(new java.awt.Font("Sitka Small", 0, 12)); // NOI18N
        delete_TAB.setForeground(new java.awt.Color(255, 255, 255));
        delete_TAB.setText("DELETE TAB");
        delete_TAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_TABActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(delete_data, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_data, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete_TAB))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(tabsyllabus, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabsyllabus)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(show_data, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delete_data, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete_TAB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(691, 691, 691))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void syActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_syActionPerformed

    private void course_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course_tActionPerformed

    private void delete_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_dataActionPerformed
        // TODO add your handling code here:
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
         PreparedStatement pstmt = conn.prepareStatement("DELETE FROM courses WHERE course_code = ?")) {

        pstmt.setString(1, courseCode);
        int rowsDeleted = pstmt.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(this, "Record deleted successfully!");
            model.removeRow(selectedRow); 
        } else {
            JOptionPane.showMessageDialog(this, "No record found for the given course code.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error deleting record: " + e.getMessage());
    }
    }//GEN-LAST:event_delete_dataActionPerformed

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

    private void b_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_submitActionPerformed
        // TODO add your handling code here:
        String sh_year = sy.getText();
    String semester = (String) sem.getSelectedItem();
    String course_code = course_c.getText();
    String c_t = course_t.getText();
    String tabName = (String) tabs.getSelectedItem();

    if (selectedFile == null || tabName == null) {
        JOptionPane.showMessageDialog(this, "Please select a file and a tab.");
        return;
    }

    try (Connection conn = DBConnection.connectDB()) {
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed.");
            return;
        }

        
        int tabId = -1;
        try (PreparedStatement tabStmt = conn.prepareStatement("SELECT tab_id FROM tabbed WHERE tab_name = ?")) {
            tabStmt.setString(1, tabName);
            ResultSet tabRs = tabStmt.executeQuery();
            if (tabRs.next()) {
                tabId = tabRs.getInt("tab_id");
            } else {
                JOptionPane.showMessageDialog(this, "Tab not found in database.");
                return;
            }
        }

       
        String sql = "INSERT INTO courses (school_year, semester, course_code, course_title, tab_id, user_id, doc_file) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             FileInputStream fis = new FileInputStream(selectedFile)) {

            pstmt.setString(1, sh_year);
            pstmt.setString(2, semester);
            pstmt.setString(3, course_code);
            pstmt.setString(4, c_t);
            pstmt.setInt(5, tabId); 
            pstmt.setInt(6, get.data);
            pstmt.setBinaryStream(7, fis, (int) selectedFile.length());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "File uploaded successfully!");
            }
        }

        this.dispose();  
        Instructor ins = new Instructor(); 
        ins.setVisible(true);
        ins.setLocationRelativeTo(null);

        DefaultTableModel model = tabModels.get(tabName);
        if (model != null) {
            model.addRow(new Object[]{sh_year, semester, course_code, c_t});
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error uploading file: " + e.getMessage());
        e.printStackTrace();
    }
    
    }//GEN-LAST:event_b_submitActionPerformed

    private void b_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_fileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Documents (PDF)", "pdf"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Selected file: " + selectedFile.getName());
        }
    
    }//GEN-LAST:event_b_fileActionPerformed

    private void semActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semActionPerformed

    private void course_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course_cActionPerformed

    private void Logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Instructor hello = new Instructor();
        hello.setVisible(true);
        hello.setLocationRelativeTo(null);
    }//GEN-LAST:event_Logout1ActionPerformed

    private void delete_data1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_data1ActionPerformed
        // TODO add your handling code here:
        this.dispose();  
        Instructor1 ins = new Instructor1(); 
        ins.setVisible(true);
        ins.setLocationRelativeTo(null);
    }//GEN-LAST:event_delete_data1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String name = JOptionPane.showInputDialog(
        Instructor.this,
        "Enter tab name:",
        "Tab Name",
        JOptionPane.PLAIN_MESSAGE
    );
    
    if (name == null || name.trim().isEmpty()) {
        name = "Tab " + tabCount++;
    }

    // Save tab name to DB
    try (Connection conn = DBConnection.connectDB();
         PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tabbed (tab_name) VALUES (?)")) {
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        
        this.dispose();  
        Instructor ins = new Instructor(); 
        ins.setVisible(true);
        ins.setLocationRelativeTo(null);
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saving tab: " + e.getMessage());
    }

    addTabWithCourseTable(name);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabsActionPerformed
        // TODO add your handling code here:
        String selectedTab = (String) tabs.getSelectedItem();
        for (int i = 0; i < tabsyllabus.getTabCount(); i++) {
            if (tabsyllabus.getTitleAt(i).equals(selectedTab)) {
                tabsyllabus.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tabsActionPerformed

    private void delete_TABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_TABActionPerformed
        // TODO add your handling code here:
        String selectedTabName = (String) tabs.getSelectedItem();

    if (selectedTabName == null) {
        JOptionPane.showMessageDialog(this, "No tab selected to delete.");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete tab: " + selectedTabName + "?\nAll related courses will also be deleted.",
        "Confirm Deletion",
        JOptionPane.YES_NO_OPTION);

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    try (Connection conn = DBConnection.connectDB()) {
        conn.setAutoCommit(false);

       
        int tabId = -1;
        try (PreparedStatement tabStmt = conn.prepareStatement("SELECT tab_id FROM tabbed WHERE tab_name = ?")) {
            tabStmt.setString(1, selectedTabName);
            ResultSet rs = tabStmt.executeQuery();
            if (rs.next()) {
                tabId = rs.getInt("tab_id");
            } else {
                JOptionPane.showMessageDialog(this, "Tab not found in database.");
                return;
            }
        }

        
        try (PreparedStatement deleteCourses = conn.prepareStatement("DELETE FROM courses WHERE tab_id = ?")) {
            deleteCourses.setInt(1, tabId);
            deleteCourses.executeUpdate();
        }

      
        try (PreparedStatement deleteTab = conn.prepareStatement("DELETE FROM tabbed WHERE tab_id = ?")) {
            deleteTab.setInt(1, tabId);
            deleteTab.executeUpdate();
        }

        conn.commit();

       
        for (int i = 0; i < tabsyllabus.getTabCount(); i++) {
            if (tabsyllabus.getTitleAt(i).equals(selectedTabName)) {
                tabsyllabus.removeTabAt(i);
                break;
            }
        }

        tabs.removeItem(selectedTabName);
        tabModels.remove(selectedTabName);

        JOptionPane.showMessageDialog(this, "Tab and its data deleted successfully.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error deleting tab: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_delete_TABActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout1;
    private javax.swing.JButton b_file;
    private javax.swing.JButton b_submit;
    private javax.swing.JTextField course_c;
    private javax.swing.JTextField course_t;
    private javax.swing.JButton delete_TAB;
    private javax.swing.JButton delete_data;
    private javax.swing.JButton delete_data1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField search_for_table;
    private javax.swing.JComboBox<String> sem;
    private javax.swing.JButton show_data;
    private javax.swing.JTextField sy;
    private javax.swing.JComboBox<String> tabs;
    private javax.swing.JTabbedPane tabsyllabus;
    // End of variables declaration//GEN-END:variables
}
