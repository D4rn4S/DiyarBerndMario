package GUI;


import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1bestcsharp.blogspot.com
 */
public class Java_Populate_JTable_Using_ArrayList extends javax.swing.JFrame {

    /**
     * Creates new form Java_Populate_JTable_Using_ArrayList
     */
    public Java_Populate_JTable_Using_ArrayList() {
        initComponents();

         // use the addRowToJTable
        addRowToJTable();

    }
    
// create a class User and use it to populate the arraylist
    public class Artikel{
    	String name;
    	int nummer;
    	double preis;
    	int bestand;
    	int mindestbestand;
        
        public Artikel(String name, int nummer, double preis, int bestand, int mindestbestand)
        {
            this.name = name;
            this.nummer = nummer;
            this.preis = preis;
            this.bestand = bestand;
            this.mindestbestand = mindestbestand;
        }
    }
    
// create a list of users
    public ArrayList ListUsers()
    {
        ArrayList<Artikel> list = new ArrayList<Artikel>();
        Artikel a1 = new Artikel("Kiste-Bier", 1, 7.99, 100, 5);
        Artikel a2 = new Artikel("BernddasBrot", 2, 99.30, 15, 1);
        Artikel a3 = new Artikel("Fass-Bier", 3, 30.00, 10, 3);
        Artikel a4 = new Artikel("Brause", 4, 5.0, 75, 6);
        Artikel a5 = new Artikel("Behrensen Korn", 5, 6.70, 180, 1);
        Artikel a6 = new Artikel("Maibaum", 6, 100.00, 3, 1);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);

        return list;
    }
    
// added rows from arraylist to jtable
    public void addRowToJTable()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ArrayList<Artikel> list = ListUsers();
        Object rowData[] = new Object[5];
        for(int i = 0; i < list.size(); i++)
        {
            rowData[0] = list.get(i).name;
            rowData[1] = list.get(i).nummer;
            rowData[2] = list.get(i).preis;
            rowData[3] = list.get(i).bestand;
            rowData[4] = list.get(i).mindestbestand;
            model.addRow(rowData);
        }
                
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Nummer", "Preis", "Bestand", "Mindestbestand"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(Java_Populate_JTable_Using_ArrayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Java_Populate_JTable_Using_ArrayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Java_Populate_JTable_Using_ArrayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Java_Populate_JTable_Using_ArrayList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Java_Populate_JTable_Using_ArrayList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
