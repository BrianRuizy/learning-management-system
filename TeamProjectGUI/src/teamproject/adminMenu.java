package teamproject;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author OscarDuarte
 */
public class adminMenu extends javax.swing.JFrame{
    admin admin = new admin();
    
    public adminMenu() {
        initComponents();
    }
    
    public adminMenu(ArrayList<student> students) {
        initComponents();
        admin.students = (ArrayList)students.clone();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdminLogout = new javax.swing.JButton();
        btnViewStudent = new javax.swing.JButton();
        btnAddStudent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ADMIN"));

        btnAdminLogout.setText("Log Out");
        btnAdminLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLogoutActionPerformed(evt);
            }
        });

        btnViewStudent.setText("View a Student");
        btnViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStudentActionPerformed(evt);
            }
        });

        btnAddStudent.setText("Enroll a Student");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(btnViewStudent)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(btnAdminLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewStudent)
                    .addComponent(btnAddStudent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnAdminLogout)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //***************
    //btnAdminLogout*
    //***************
    private void btnAdminLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLogoutActionPerformed
        LogIn login = new LogIn(admin.students);
        
        login.setVisible(true);
        setVisible(false);       
    }//GEN-LAST:event_btnAdminLogoutActionPerformed

    //**************
    //btnAddStudent*
    //**************
    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentActionPerformed
        //Enter student information
        String fName = JOptionPane.showInputDialog(null, "Enter first name: ");
        String lName = JOptionPane.showInputDialog(null, "Enter last name: ");
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID: "));
        
        //Check if student exists
        boolean found = false;
        found = admin.studentExist(fName, lName, id);
               
        //Enter course information
        if(found == false){
            
            student student = new student(fName, lName, id);
            
            //Enter amount of courses
            int courses = Integer.parseInt(JOptionPane.showInputDialog(null, "How many courses is the student taking: "));
            
            for(int i = 0; i < courses; i++){
                ArrayList<Object> tempCourse = new ArrayList<>();
                
                String courseName = JOptionPane.showInputDialog(null, "Course " + (i + 1) + " Name: ");
                int test1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter test 1: "));
                int test2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter test 2: "));
                int test3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter test 3: "));
                
                tempCourse.add(courseName);
                tempCourse.add(test1);
                tempCourse.add(test2);
                tempCourse.add(test3);
                
                student.courses.add(tempCourse);               
            }    

            student.calcGradeLetter();
            student.calcGPA();
            admin.students.add(student);
        }
        else{
            JOptionPane.showMessageDialog(null, "Student already existd.");
        }
        
    }//GEN-LAST:event_btnAddStudentActionPerformed

    //*************
    //View Student*
    //*************
    private void btnViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStudentActionPerformed
        if(admin.students.isEmpty()){
            JOptionPane.showMessageDialog(null, "There are no students.");
        }
        else{
            String fName = JOptionPane.showInputDialog(null, "Enter first name: ");
            String lName = JOptionPane.showInputDialog(null, "Enter last name: ");
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID: "));
            
            admin.display(fName, lName, id);
        }
    }//GEN-LAST:event_btnViewStudentActionPerformed

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
            java.util.logging.Logger.getLogger(adminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnAdminLogout;
    private javax.swing.JButton btnViewStudent;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
