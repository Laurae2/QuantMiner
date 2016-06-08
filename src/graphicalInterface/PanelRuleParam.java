/*                                             
 *Copyright 2007, 2011 CCLS Columbia University (USA), LIFO University of Orl��ans (France), BRGM (France)
 *
 *Authors: Cyril Nortet, Xiangrong Kong, Ansaf Salleb-Aouissi, Christel Vrain, Daniel Cassard
 *
 *This file is part of QuantMiner.
 *
 *QuantMiner is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.
 *
 *QuantMiner is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License along with QuantMiner.  If not, see <http://www.gnu.org/licenses/>.
 */
package src.graphicalInterface;

import javax.swing.*;

import src.apriori.*;
import src.solver.*;
import src.tools.*;



public class PanelRuleParam extends PanelBaseParam { //step 3 rule parameters for Apriori
    
    /** Creates new form PanneauParamRegles */
    public PanelRuleParam(ResolutionContext contexteResolution) {
        super(contexteResolution);

        ImageIcon iconeRetourDefaut = null;
        
        initComponents();
        
        // Ic�nes sur les boutons :
        iconeRetourDefaut = new ImageIcon( ENV.REPERTOIRE_RESSOURCES + "retour_defaut.jpg" );
        jButtonDefautSupport.setIcon(iconeRetourDefaut);
        jButtonDefautConfiance.setIcon(iconeRetourDefaut);
        
        if (m_contexteResolution == null)
            return;
      
        // Initialisation du contenu des champs :
        jTextFieldSupport.setText( ResolutionContext.EcrirePourcentage( m_contexteResolution.m_parametresRegles.m_fMinSupp, 3, false) );
        jTextFieldConfiance.setText( ResolutionContext.EcrirePourcentage( m_contexteResolution.m_parametresRegles.m_fMinConf, 3, false) );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jTextFieldSupport = new javax.swing.JTextField();
        jLabelSupport = new javax.swing.JLabel();
        jLabelConfiance = new javax.swing.JLabel();
        jTextFieldConfiance = new javax.swing.JTextField();
        jButtonDefautSupport = new javax.swing.JButton();
        jButtonDefautConfiance = new javax.swing.JButton();

        setLayout(null);

        setPreferredSize(new java.awt.Dimension(300, 90));
        jTextFieldSupport.setInputVerifier(new ToolsInterface.VerifieurTextFieldIntervalleFloat(0.000f, 100.000f));
        add(jTextFieldSupport);
        jTextFieldSupport.setBounds(160, 20, 100, 20);

        jLabelSupport.setText("Support threshold (%) :");
        add(jLabelSupport);
        jLabelSupport.setBounds(10, 20, 140, 20);

        jLabelConfiance.setText("Confidence threshold (%) : ");
        add(jLabelConfiance);
        jLabelConfiance.setBounds(10, 50, 150, 16);

        jTextFieldConfiance.setInputVerifier(new ToolsInterface.VerifieurTextFieldIntervalleFloat(0.000f, 100.000f));
        add(jTextFieldConfiance);
        jTextFieldConfiance.setBounds(160, 50, 100, 20);

        jButtonDefautSupport.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDefautSupport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefautSupportActionPerformed(evt);
            }
        });

        add(jButtonDefautSupport);
        jButtonDefautSupport.setBounds(270, 20, 20, 20);

        jButtonDefautConfiance.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDefautConfiance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefautConfianceActionPerformed(evt);
            }
        });

        add(jButtonDefautConfiance);
        jButtonDefautConfiance.setBounds(270, 50, 20, 20);

    }//GEN-END:initComponents

    private void jButtonDefautConfianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefautConfianceActionPerformed
        jTextFieldConfiance.setText( ResolutionContext.EcrirePourcentage(StandardParameters.DEFAUT_MINCONF, 3, false) );
    }//GEN-LAST:event_jButtonDefautConfianceActionPerformed

    private void jButtonDefautSupportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefautSupportActionPerformed
        jTextFieldSupport.setText( ResolutionContext.EcrirePourcentage(StandardParameters.DEFAUT_MINSUPP, 3, false) );
    }//GEN-LAST:event_jButtonDefautSupportActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDefautConfiance;
    private javax.swing.JButton jButtonDefautSupport;
    private javax.swing.JLabel jLabelConfiance;
    private javax.swing.JLabel jLabelSupport;
    private javax.swing.JTextField jTextFieldConfiance;
    private javax.swing.JTextField jTextFieldSupport;
    // End of variables declaration//GEN-END:variables
    
      
    
    
    public boolean EnregistrerParametres() {
        
        StandardParameters parametresRegles = null;
        float fMinSupp = 0.000f;
        float fMinConf = 0.000f;
        
        parametresRegles = m_contexteResolution.m_parametresRegles;
        if (parametresRegles == null)
            return true;
    
        // M�morisation des param�tres :
        
        try {
            fMinSupp = (float) ( Double.parseDouble( jTextFieldSupport.getText() ) / 100.000 );
            parametresRegles.m_fMinSupp = fMinSupp;
        }
        catch (NumberFormatException e) {
            return false;
        }
 
        try {
            fMinConf = (float) ( Double.parseDouble( jTextFieldConfiance.getText() ) / 100.000 );
            parametresRegles.m_fMinConf = fMinConf;
        }
        catch (NumberFormatException e) {
            return false;
        }

        return true;    
    }
    
    
}
