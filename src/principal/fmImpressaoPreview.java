/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controlador.Impressor;
import controlador.ImpressorPreview;
import java.awt.Dimension;

/**
 *
 * @author ccandido
 */
public class fmImpressaoPreview extends javax.swing.JDialog {

    private final int margem = 20;
    private ImpressorPreview prev;

    /**
     * Creates new form fmImpressaoPreview
     *
     * @param parent
     * @param modal
     */
    public fmImpressaoPreview(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    final int PRI = -2, ANT = -1, PRO = 1, ULT = 2;
    
    public void Inicie(Impressor pai) {
        prev = new ImpressorPreview(pai);
        pai.iniceImpressao();
        this.panBox.add(prev);
        prev.setLocation(margem, margem);

        prev.setSize(new Dimension(prev.Largura, prev.Altura));
        prev.setPreferredSize(prev.getSize());

        panBox.setSize(new Dimension(prev.Largura + margem * 2, prev.Altura + margem * 2));
        panBox.setPreferredSize(panBox.getSize());

        this.pack();
        movimentePg(1);
    }

    public void movimentePg(int m) {
        btnPrimeiro.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnProx.setEnabled(false);
        btnUltimo.setEnabled(false);
        if (prev.getTlpagina() == 1) {
            prev.setPgatual(1);
        }
        if (prev.getTlpagina() < 2) {
            return;
        }
        int pg = prev.getPgatual();
        switch (m) {
            case PRI:
                prev.setPgatual(1);
                btnProx.setEnabled(true);
                btnUltimo.setEnabled(true);
                break;
            case ANT:
                pg--;
                if (pg > 1) {
                    btnAnterior.setEnabled(true);
                    btnPrimeiro.setEnabled(true);
                }
                prev.setPgatual(pg);
                btnProx.setEnabled(true);
                btnUltimo.setEnabled(true);
                break;
            case PRO:
                pg++;
                if (pg < prev.getTlpagina()) {
                    btnProx.setEnabled(true);
                    btnUltimo.setEnabled(true);
                }
                prev.setPgatual(pg);
                btnAnterior.setEnabled(true);
                btnPrimeiro.setEnabled(true);
                break;
            case ULT:
                prev.setPgatual(prev.getTlpagina());
                btnAnterior.setEnabled(true);
                btnPrimeiro.setEnabled(true);
                break;
        }
        lblPgAtual.setText("Pg. " + String.valueOf(prev.getPgatual()) + " de " + String.valueOf(prev.getTlpagina()));
        prev.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        lblPgAtual = new javax.swing.JLabel();
        btnProx = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnPrintAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panBox = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/first.gif"))); // NOI18N
        btnPrimeiro.setFocusable(false);
        btnPrimeiro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrimeiro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrimeiro);

        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/prior.png"))); // NOI18N
        btnAnterior.setFocusable(false);
        btnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAnterior);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("principal/Formularios_pt_BR"); // NOI18N
        lblPgAtual.setText(bundle.getString("fmImpressaoPreview.lblPgAtual.text")); // NOI18N
        jToolBar1.add(lblPgAtual);

        btnProx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/next.gif"))); // NOI18N
        btnProx.setFocusable(false);
        btnProx.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProx.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProx);

        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/last.gif"))); // NOI18N
        btnUltimo.setFocusable(false);
        btnUltimo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUltimo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUltimo);

        btnPrint.setText(bundle.getString("fmImpressaoPreview.btnPrint.text")); // NOI18N
        btnPrint.setFocusable(false);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrint);

        btnPrintAll.setText(bundle.getString("fmImpressaoPreview.btnPrintAll.text")); // NOI18N
        btnPrintAll.setFocusable(false);
        btnPrintAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrintAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrintAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintAllActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrintAll);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jToolBar1.add(jPanel1);

        btnFechar.setText(bundle.getString("fmImpressaoPreview.btnFechar.text")); // NOI18N
        btnFechar.setFocusable(false);
        btnFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFechar);

        panBox.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout panBoxLayout = new javax.swing.GroupLayout(panBox);
        panBox.setLayout(panBoxLayout);
        panBoxLayout.setHorizontalGroup(
            panBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 682, Short.MAX_VALUE)
        );
        panBoxLayout.setVerticalGroup(
            panBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panBox);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        movimentePg(ANT);
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        movimentePg(PRI);
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxActionPerformed
        movimentePg(PRO);
    }//GEN-LAST:event_btnProxActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        movimentePg(ULT);
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        prev.PrintPg();
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnPrintAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintAllActionPerformed
        prev.Print();
    }//GEN-LAST:event_btnPrintAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnPrintAll;
    private javax.swing.JButton btnProx;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblPgAtual;
    private javax.swing.JPanel panBox;
    // End of variables declaration//GEN-END:variables
}