/*
 * Autopsy Forensic Browser
 *
 * Copyright 2014-2016 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.modules.interestingitems;

import java.awt.event.ActionEvent;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.ingest.IngestJobSettings;
import org.sleuthkit.autopsy.modules.interestingitems.FilesSetDefsPanel.PANEL_TYPE;

/**
 * A panel that allows a user to create and edit interesting files set
 * definitions.
 */
public class FilesSetPanel extends javax.swing.JPanel {

    @NbBundle.Messages("FilesSetPanel.ingest.title=File Ingest Filter")
    /**
     * Construct a files set panel in create mode.
     */
    FilesSetPanel(PANEL_TYPE panelType) {
        initComponents();
        if (panelType == PANEL_TYPE.FILE_INGEST_FILTERS) {
            ignoreKnownFilesCheckbox.setVisible(false);
            org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.ingest.nameLabel.text")); // NOI18N
        } else {
            skipsUnallocCheckbox.setVisible(false);
        }
    }

    /**
     * Construct a files set panel in edit mode.
     *
     * @param filesSet The files set to be edited.
     */
    FilesSetPanel(FilesSet filesSet, PANEL_TYPE panelType) {
        initComponents();
        if (panelType == PANEL_TYPE.FILE_INGEST_FILTERS) {
            ignoreKnownFilesCheckbox.setVisible(false);
        } else {
            skipsUnallocCheckbox.setVisible(false);
        }
        this.nameTextField.setText(filesSet.getName());
        this.descTextArea.setText(filesSet.getDescription());
        this.ignoreKnownFilesCheckbox.setSelected(filesSet.ignoresKnownFiles());
        this.skipsUnallocCheckbox.setSelected(filesSet.getSkipUnallocatedSpace());
    }

    /**
     * Returns whether or not the data entered in the panel constitutes a valid
     * interesting files set definition, displaying a dialog explaining the
     * deficiency if the definition is invalid
     *
     * @return True if the definition is valid, false otherwise.
     */
    boolean isValidDefinition() {
        if (this.nameTextField.getText().isEmpty()) {
            NotifyDescriptor notifyDesc = new NotifyDescriptor.Message(
                    NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.messages.filesSetsMustBeNamed"),
                    NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(notifyDesc);
            return false;
        } else {
            // The FileIngestFilters have reserved names for default filter, and creating a new filter from the jComboBox
            // These names if used would have undefined results, so prohibiting the user from using them is necessary
            for (FilesSet filesSet : IngestJobSettings.getStandardFileIngestFilters()) {
                if (this.nameTextField.getText().equals(filesSet.getName())) {
                    NotifyDescriptor notifyDesc = new NotifyDescriptor.Message(
                            NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.messages.filesSetsReservedName"),
                            NotifyDescriptor.WARNING_MESSAGE);
                    DialogDisplayer.getDefault().notify(notifyDesc);
                    return false;
                }
            }
            if (this.nameTextField.getText().equals(FileIngestFilterDefsOptionsPanelController.NEW_FILE_INGEST_FILTER)) {
                NotifyDescriptor notifyDesc = new NotifyDescriptor.Message(
                        NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.messages.filesSetsReservedName"),
                        NotifyDescriptor.WARNING_MESSAGE);
                DialogDisplayer.getDefault().notify(notifyDesc);
                return false;
            }
        }
        return true;
    }

    /**
     * Get the name for the interesting files set defined using this panel.
     *
     * @return A name string.
     */
    String getFilesSetName() {
        String returnValue = this.nameTextField.getText();
        return returnValue;
    }

    /**
     * Get the description for the interesting files set defined using this
     * panel.
     *
     * @return A description string.
     */
    String getFilesSetDescription() {
        return this.descTextArea.getText();
    }

    /**
     * Get whether or not the interesting files set defined using this panel
     * ignores known files.
     *
     * @return True if the set ignores known files, false otherwise.
     */
    boolean getFileSetIgnoresKnownFiles() {
        return this.ignoreKnownFilesCheckbox.isSelected();
    }

    /**
     *
     */
    boolean getSkipUnallocatedSpace() {
        return skipsUnallocCheckbox.isSelected();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        descPanel = new javax.swing.JPanel();
        descScrollPanel = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        ignoreKnownFilesCheckbox = new javax.swing.JCheckBox();
        skipsUnallocCheckbox = new javax.swing.JCheckBox();

        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.interesting.nameLabel.text")); // NOI18N

        descPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.descPanel.border.title"))); // NOI18N

        descTextArea.setColumns(20);
        descTextArea.setRows(5);
        descScrollPanel.setViewportView(descTextArea);

        javax.swing.GroupLayout descPanelLayout = new javax.swing.GroupLayout(descPanel);
        descPanel.setLayout(descPanelLayout);
        descPanelLayout.setHorizontalGroup(
            descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(descPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descScrollPanel)
                .addContainerGap())
        );
        descPanelLayout.setVerticalGroup(
            descPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, descPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(descScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(ignoreKnownFilesCheckbox, org.openide.util.NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.ignoreKnownFilesCheckbox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(skipsUnallocCheckbox, org.openide.util.NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.skipsUnallocCheckbox.text")); // NOI18N
        skipsUnallocCheckbox.setToolTipText(org.openide.util.NbBundle.getMessage(FilesSetPanel.class, "FilesSetPanel.skipsUnallocCheckbox.toolTipText")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ignoreKnownFilesCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(skipsUnallocCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ignoreKnownFilesCheckbox)
                    .addComponent(skipsUnallocCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel descPanel;
    private javax.swing.JScrollPane descScrollPanel;
    private javax.swing.JTextArea descTextArea;
    private javax.swing.JCheckBox ignoreKnownFilesCheckbox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JCheckBox skipsUnallocCheckbox;
    // End of variables declaration//GEN-END:variables
}
