/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.femr.dbrestaure.main;

import co.femr.database.DB;
import co.femr.dbrestaure.utils.DumpRead;
import co.femr.dbrestaure.utils.LogFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author netsaj
 */
public class Principal extends javax.swing.JFrame {

    String user = "root";
    String pass = "root";
    String host = "localhost";
    String port = "3306";
    String database = "fotobar";
    String file = "";

    DB db = null;

    private static final long MEGABYTE = 1024L * 1024L;

    public static String bytesToMegabytes(long bytes) {
        DecimalFormat format = new DecimalFormat(",#00.0#");
        return format.format(Math.round(bytes / MEGABYTE));
    }

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        new Thread(() -> {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            while (true) {
                Runtime runtime = Runtime.getRuntime();
                runtime.gc();
                lbMemory.setText("ram availe: " + bytesToMegabytes(runtime.totalMemory() - runtime.freeMemory()) + "MB of " + bytesToMegabytes(runtime.totalMemory()) + "MB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        fileChooser = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filepath = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbPass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbHost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbDb = new javax.swing.JTextField();
        onlyExportSchema = new javax.swing.JCheckBox();
        lbMemory = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logger = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Dump sql file:");

        filepath.setText("");

        jButton2.setText("Select file...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("User:");

        lbUser.setText("root");

        jLabel3.setText("Password:");

        lbPass.setText("root");

        jLabel4.setText("host:");

        lbHost.setText("localhost:3306");

        jLabel5.setText("Database:");

        lbDb.setText("");

        onlyExportSchema.setText("Only export schema in separate file");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(filepath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbHost))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbPass)
                            .addComponent(lbDb))))
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(onlyExportSchema)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filepath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(lbDb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(onlyExportSchema)
                .addGap(31, 31, 31))
        );

        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jButton3.setText("stop");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(logger);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("utils");

        jMenuItem1.setText("create file for contains");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMemory, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(lbMemory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        continueThread = true;
        if (onlyExportSchema.isSelected()) {
            initCreateFileForContains.start();
        } else {
            initRestaure.start();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.showOpenDialog(null);
        File f = fileChooser.getSelectedFile();
        if (f != null) {
            filepath.setText(f.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        continueThread = false;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextField filepath;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lbDb;
    private javax.swing.JTextField lbHost;
    private javax.swing.JLabel lbMemory;
    private javax.swing.JTextField lbPass;
    private javax.swing.JTextField lbUser;
    private javax.swing.JTextPane logger;
    private javax.swing.JCheckBox onlyExportSchema;
    // End of variables declaration//GEN-END:variables

    public void printLog(String log) {
        String log2 = log;
        if (log.length() > 300) {
            log2 = log.substring(0, 200) + "[...]" + log.substring(log.length() - 6, log.length() - 1);
        }
        String date = new Timestamp(Calendar.getInstance().getTimeInMillis()).toString();
        logger.setText(date.split(Pattern.quote("."))[0] + "| " + log2);
        System.out.println(date.split(Pattern.quote("."))[0] + "| " + log);

    }

    public boolean runSplitQuery(String sql) {
        boolean done = false;
        long try_again = 0;
        String[] s1 = sql.split(" VALUES ");
        String[] lines = s1[1].split(Pattern.quote(("),(")));
        int count = 0;
        String row = "no sql";
        while (count < lines.length) {
            String values = "";
            if (count == 0) {
                values = lines[count] + ");";
            } else if (count < lines.length - 1) {
                values = "(" + lines[count] + ");";
            } else {
                values = "(" + lines[count];
            }
            try {
                if (db == null) {
                    db = new DB(host, database, user, pass);
                }
                row = s1[0] + " VALUES " + values;
                done = db.exec(row);
                if (done) {
                    printLog("DONE: " + row + " (" + count + " of " + lines.length + ")");
                } else {
                    printLog("FAIL:" + row + " (" + count + " of " + lines.length + ")");
                }
            } catch (Exception ex) {
                if (ex.getMessage().contains(" Can not issue empty query")) {
                    done = true;
                } else if (ex.getMessage().contains("Duplicate entry")) {
                    done = true;
                    printLog("skipped: key exist - " + sql);
                } else if (ex.getMessage().contains("Communications link failure")) {
                    db = null;
                    printLog("Connection lost - try again");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } else if (ex.getMessage().contains("Access denied; you need (at least one of) the SUPER privilege(s) for this operation")) {
                    done = true;
                    printLog("Need super user for run: " + sql);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } else if (ex.getMessage().contains("Data truncated for column")) {
                    printLog("DONE: " + row + " (" + count + " of " + lines.length + ")");
                    printLog(ex.getMessage());
                } else {
                    db = null;
                    printLog(ex.getMessage());
                    ex.printStackTrace();

                }
            }
        }
        return true;
    }

    public void runQuery(String sql) {
        boolean done = false;
        long try_again = 0;
        while (!done && continueThread) {
            try {
                if (db == null) {
                    db = new DB(host, database, user, pass);
                }
                done = db.exec(sql);
                if (done) {
                    printLog("DONE: " + sql);
                } else {
                    printLog("FAIL:" + sql);
                }
            } catch (Exception ex) {
                if (ex.getMessage().contains(" Can not issue empty query")) {
                    done = true;
                } else if (ex.getMessage().contains("Duplicate entry")) {
                    done = true;
                    printLog("skipped: key exist - " + sql);
                } else if (ex.getMessage().contains("Communications link failure")) {
                    db = null;
                    printLog("Connection lost - try again");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } else if (ex.getMessage().contains("Access denied; you need (at least one of) the SUPER privilege(s) for this operation")) {
                    done = true;
                    printLog("Need super user for run: " + sql);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                } else if (ex.getMessage().contains("Data truncated for column")) {
                    printLog(ex.getMessage());
                    if (sql.toLowerCase().contains("insert into")) {
                        done = runSplitQuery(sql);
                    }
                } else {
                    ex.printStackTrace();
                    db = null;
                }
            }
        }
        if (db != null) {

        }
    }

    long lastQuery = 0;
    long currentQuery = 0;
    boolean continueThread = true;
    Thread initRestaure = new Thread(new Runnable() {
        @Override
        public void run() {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            try {
                user = lbUser.getText();
                pass = lbPass.getText();
                database = lbDb.getText();
                host = lbHost.getText();
                file = filepath.getText();
                runQuery("set global max_allowed_packet=1048576000");
                DumpRead reader = new DumpRead(file);
                String sql;
                String readLast = LogFile.read(file + ".progress");
                lastQuery = readLast == null || readLast.isEmpty() ? 0 : Long.parseLong(readLast);
                System.out.println("Actuallity : " + lastQuery);
                while ((sql = reader.line()) != null && continueThread) {
                    currentQuery++;
                    if (lastQuery > currentQuery) {
                        System.out.println("skipped line: " + currentQuery);
                        printLog("skip line " + currentQuery + " - last query: " + lastQuery);
                        float percent = (reader.currentSize() * 100) / reader.totalSize();
                        jProgressBar1.setValue((int) (percent));
                        jProgressBar1.setString(bytesToMegabytes(reader.currentSize()) + "MB of " + bytesToMegabytes(reader.totalSize()) + "MB");
                        continue;
                    }
                    if (!sql.isEmpty()) {
                        runQuery(sql);
                    }
                    float percent = (reader.currentSize() * 100) / reader.totalSize();
                    jProgressBar1.setValue((int) (percent));
                    jProgressBar1.setString(bytesToMegabytes(reader.currentSize()) + "MB of " + bytesToMegabytes(reader.totalSize()) + "MB");
                    if (continueThread) {
                        LogFile.write(file + ".progress", String.valueOf(currentQuery));
                    }
                }
                if (continueThread) {
                    logger.setText("PROCESS STOPED");
                }
                jProgressBar1.setValue(100);
                jProgressBar1.setString(reader.totalSize() + " / " + reader.totalSize());
                JOptionPane.showMessageDialog(null, "Process complete...");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });

    Thread initCreateFileForContains = new Thread(new Runnable() {
        @Override
        public void run() {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            try {
                file = filepath.getText();
                DumpRead reader = new DumpRead(file);
                String sql;
                File dump = new File("create_tables_" + fileChooser.getSelectedFile().getName());
                if (!dump.exists()) {
                    dump.createNewFile();
                }
                String readLast = LogFile.read("create_tables_" + fileChooser.getSelectedFile().getName() + ".progress");
                FileWriter writer = new FileWriter(dump);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                lastQuery = readLast == null || readLast.isEmpty() ? 0 : Long.parseLong(readLast);
                System.out.println("Actuallity : " + lastQuery);
                while ((sql = reader.line(true)) != null && continueThread) {
                    currentQuery++;
                    if (lastQuery > currentQuery) {
                        System.out.println("skipped line: " + currentQuery);
                        printLog("skip line " + currentQuery + " - last query: " + lastQuery);
                        float percent = (reader.currentSize() * 100) / reader.totalSize();
                        jProgressBar1.setValue((int) (percent));
                        jProgressBar1.setString(bytesToMegabytes(reader.currentSize()) + "MB of " + bytesToMegabytes(reader.totalSize()) + "MB");
                        continue;
                    }

                    if (!sql.isEmpty() && !sql.toLowerCase().contains("insert into")) {
                        printLog(sql);
                        bufferedWriter.write(sql);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }

                    float percent = (reader.currentSize() * 100) / reader.totalSize();
                    jProgressBar1.setValue((int) (percent));
                    jProgressBar1.setString(bytesToMegabytes(reader.currentSize()) + "MB of " + bytesToMegabytes(reader.totalSize()) + "MB");
                    if (continueThread) {
                        LogFile.write(file + ".progress", String.valueOf(currentQuery));
                    }
                }
                if (continueThread) {
                    logger.setText("PROCESS STOPED");
                }
                jProgressBar1.setValue(100);
                jProgressBar1.setString(reader.totalSize() + " / " + reader.totalSize());
                bufferedWriter.flush();
                bufferedWriter.close();
                writer.close();
                JOptionPane.showMessageDialog(null, "Process complete...");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    });

}
