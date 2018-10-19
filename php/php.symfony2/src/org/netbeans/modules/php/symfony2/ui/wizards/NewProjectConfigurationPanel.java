/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.php.symfony2.ui.wizards;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.options.OptionsDisplayer;
import org.netbeans.modules.php.api.validation.ValidationResult;
import org.netbeans.modules.php.symfony2.options.SymfonyOptions;
import org.netbeans.modules.php.symfony2.options.SymfonyOptionsValidator;
import org.netbeans.modules.php.symfony2.ui.options.SymfonyOptionsPanelController;
import org.openide.awt.Mnemonics;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;

/**
 * Symfony 2/3 new project panel.
 */
public class NewProjectConfigurationPanel extends JPanel implements ChangeListener {

    private static final long serialVersionUID = 326547867641L;

    private final ChangeSupport changeSupport = new ChangeSupport(this);


    public NewProjectConfigurationPanel() {
        initComponents();

        init();
        initListeners();
    }

    @Override
    public void addNotify() {
        SymfonyOptions.getInstance().addChangeListener(this);
        super.addNotify();
    }

    @Override
    public void removeNotify() {
        SymfonyOptions.getInstance().removeChangeListener(this);
        super.removeNotify();
    }

    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    public String getErrorMessage() {
        // treat all as errors here
        ValidationResult result = new SymfonyOptionsValidator()
                .validate()
                .getResult();
        if (result.hasErrors()) {
            return result.getErrors().get(0).getMessage();
        }
        // warnings
        if (result.hasWarnings()) {
            return result.getWarnings().get(0).getMessage();
        }
        return null;
    }

    private void init() {
        setComponents();
        // work around - keep the label on the right side
        optionsLabel.setMaximumSize(optionsLabel.getPreferredSize());
    }

    private void initListeners() {
        infoLabel.addPropertyChangeListener("enabled", new PropertyChangeListener() { // NOI18N
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                enableOptionsLabel();
            }
        });
        enableOptionsLabel();
    }

    @NbBundle.Messages({
        "NewProjectConfigurationPanel.info.installer=<html>Project will be created using <i>Symfony Installer</i>.</html>",
        "NewProjectConfigurationPanel.info.sandbox=<html>Project will be created using <i>Symfony Sandbox</i>.</html>",
    })
    private void setComponents() {
        String info;
        boolean showOther;
        if (SymfonyOptions.getInstance().isUseInstaller()) {
            info = Bundle.NewProjectConfigurationPanel_info_installer();
            showOther = true;
        } else {
            info = Bundle.NewProjectConfigurationPanel_info_sandbox();
            showOther = false;
        }
        infoLabel.setText(info);
        noteLabel.setVisible(showOther);
    }

    void enableOptionsLabel() {
        optionsLabel.setVisible(infoLabel.isEnabled());
    }

    void fireChange() {
        changeSupport.fireChange();
    }


    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoLabel = new JLabel();
        optionsLabel = new JLabel();
        noteLabel = new JLabel();

        Mnemonics.setLocalizedText(infoLabel, "INFO"); // NOI18N

        Mnemonics.setLocalizedText(optionsLabel, NbBundle.getMessage(NewProjectConfigurationPanel.class, "NewProjectConfigurationPanel.optionsLabel.text")); // NOI18N
        optionsLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                optionsLabelMouseEntered(evt);
            }
            public void mousePressed(MouseEvent evt) {
                optionsLabelMousePressed(evt);
            }
        });

        Mnemonics.setLocalizedText(noteLabel, NbBundle.getMessage(NewProjectConfigurationPanel.class, "NewProjectConfigurationPanel.noteLabel.text")); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(infoLabel)
                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(optionsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(noteLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(optionsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoLabel))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(noteLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void optionsLabelMouseEntered(MouseEvent evt) {//GEN-FIRST:event_optionsLabelMouseEntered
        evt.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_optionsLabelMouseEntered

    private void optionsLabelMousePressed(MouseEvent evt) {//GEN-FIRST:event_optionsLabelMousePressed
        OptionsDisplayer.getDefault().open(SymfonyOptionsPanelController.getOptionsPath());
    }//GEN-LAST:event_optionsLabelMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel infoLabel;
    private JLabel noteLabel;
    private JLabel optionsLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void stateChanged(ChangeEvent e) {
        setComponents();
        fireChange();
    }

}
