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
package org.netbeans.modules.php.nette2.ui.codegen;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.netbeans.modules.php.nette2.codegen.ActionRenderMethodChecker;
import org.netbeans.modules.php.nette2.utils.Constants;
import org.netbeans.modules.php.nette2.utils.EditorUtils;
import org.openide.util.NbBundle;

/**
 *
 * @author Ondrej Brejla <obrejla@netbeans.org>
 */
public final class ActionRenderVisualPanel extends JPanel {
    private DefaultTableModel tableModel;
    private ActionRenderMethodChecker methodChecker;

    public ActionRenderVisualPanel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
        initComponents();
        warningLabel.setText(""); //NOI18N
    }

    @NbBundle.Messages("TXT_ActionRenderVisualPanelName=Action and Render")
    @Override
    public String getName() {
        return Bundle.TXT_ActionRenderVisualPanelName();
    }

    public Set<Action> getActions() {
        Set<Action> actions = new HashSet<Action>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            actions.add(new Action(
                    (String) tableModel.getValueAt(i, 0),
                    (Boolean) tableModel.getValueAt(i, 1),
                    (Boolean) tableModel.getValueAt(i, 2)));
        }
        return actions;
    }

    public void setMethodChecker(ActionRenderMethodChecker methodChecker) {
        this.methodChecker = methodChecker;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        directoryChooser = new javax.swing.JFileChooser();
        jLabel2 = new javax.swing.JLabel();
        actionNameText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        actionTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        directoryChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ActionRenderVisualPanel.class, "ActionRenderVisualPanel.jLabel2.text")); // NOI18N

        actionNameText.setText(org.openide.util.NbBundle.getMessage(ActionRenderVisualPanel.class, "ActionRenderVisualPanel.actionNameText.text")); // NOI18N
        actionNameText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                actionNameTextCaretUpdate(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(addButton, org.openide.util.NbBundle.getMessage(ActionRenderVisualPanel.class, "ActionRenderVisualPanel.addButton.text")); // NOI18N
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        actionTable.setModel(tableModel);
        actionTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(actionTable);

        org.openide.awt.Mnemonics.setLocalizedText(deleteButton, org.openide.util.NbBundle.getMessage(ActionRenderVisualPanel.class, "ActionRenderVisualPanel.deleteButton.text")); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(warningLabel, org.openide.util.NbBundle.getMessage(ActionRenderVisualPanel.class, "ActionRenderVisualPanel.warningLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(ActionRenderVisualPanel.class, "ActionRenderVisualPanel.jLabel3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actionNameText, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(warningLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(actionNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(warningLabel))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        addAction();
    }//GEN-LAST:event_addButtonActionPerformed

    private void actionNameTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_actionNameTextCaretUpdate
        if (isValidAction(actionNameText.getText())) {
            addButton.setEnabled(true);
        } else {
            if (actionNameText.getText().trim().isEmpty()) {
                hideWarning();
            }
            addButton.setEnabled(false);
        }
    }//GEN-LAST:event_actionNameTextCaretUpdate

    @NbBundle.Messages({
        "TXT_DeleteRowConfirmText=Do you really want to delete this action row?",
        "TXT_DeleteRowConfirmTitle=Are you sure?",
        "TXT_NoActionSelectedText=You must select an action row before you can delete it.",
        "TXT_NoActionSelectedTitle=No row selected"
    })
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = actionTable.getSelectedRow();
        if (row != -1) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    Bundle.TXT_DeleteRowConfirmText(),
                    Bundle.TXT_DeleteRowConfirmTitle(),
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                tableModel.removeRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    Bundle.TXT_NoActionSelectedText(),
                    Bundle.TXT_NoActionSelectedTitle(),
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * Adds action into the table.
     */
    private void addAction() {
        if (isValidAction(actionNameText.getText())) {
            tableModel.addRow(new Object[]{actionNameText.getText(), false, false});
            actionNameText.setText(""); //NOI18N
            addButton.setEnabled(false);
            hideWarning();
            actionNameText.requestFocus();
        }
    }

    private boolean isValidAction(String action) {
        boolean result = false;
        if (isValidActionFormat(action) && !actionExists(action)) {
            hideWarning();
            result = true;
        }
        return result;
    }

    @NbBundle.Messages("WRN_InvalidActionFormat=Action name is not alphanumeric string.")
    private boolean isValidActionFormat(String action) {
        boolean result = false;
        if (action.trim().matches(Constants.VALID_ACTION_NAME_REGEX)) {
            result = true;
        } else {
            showWarning(Bundle.WRN_InvalidActionFormat());
        }
        return result;
    }

    @NbBundle.Messages({
        "WRN_ActionExists=Action with this name already exists.",
        "WRN_ActionRenderMethodExists=Action and render method for this action already exist."
    })
    private boolean actionExists(String newAction) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String oldAction = (String) tableModel.getValueAt(i, 0);
            if (oldAction.equals(newAction)) {
                showWarning(Bundle.WRN_ActionExists());
                return true;
            }
        }
        if (methodChecker != null) {
            if (methodChecker.existsActionMethod(newAction) && methodChecker.existsRenderMethod(newAction)) {
                showWarning(Bundle.WRN_ActionRenderMethodExists());
                return true;
            }
        }
        return false;
    }

    private void showWarning(String warning) {
        warningLabel.setText(" "); //NOI18N
        warningLabel.setForeground(UIManager.getColor("nb.warningForeground")); //NOI18N
        warningLabel.setText(warning);
    }

    private void hideWarning() {
        warningLabel.setText(" "); //NOI18N
    }

    public static final class Action {
        private final String name;
        private final boolean generateAction;
        private final boolean generateRender;

        public Action(String name, boolean generateAction, boolean generateRender) {
            assert name != null;
            this.name = name;
            this.generateAction = generateAction;
            this.generateRender = generateRender;
        }

        public String getName() {
            return name;
        }

        public boolean isGenerateAction() {
            return generateAction;
        }

        public String generateAction() {
            return getMethod(Constants.NETTE_ACTION_METHOD_PREFIX);
        }

        public boolean isGenerateRender() {
            return generateRender;
        }

        public String generateRender() {
            return getMethod(Constants.NETTE_RENDER_METHOD_PREFIX);
        }

        private String getMethod(String type) {
            return "public function " + type + EditorUtils.firstLetterCapital(name) + "() {\n \n}"; //NOI18N
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actionNameText;
    private javax.swing.JTable actionTable;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JFileChooser directoryChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
