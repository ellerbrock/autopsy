/*
 * Autopsy
 *
 * Copyright 2020 Basis Technology Corp.
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
package org.sleuthkit.autopsy.filequery;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

/**
 *
 * @author wschaefer
 */
public class DocumentPanel extends javax.swing.JPanel implements ListCellRenderer<DocumentWrapper> {

    private static final long serialVersionUID = 1L;
    private static final Color SELECTION_COLOR = new Color(0, 120, 215);
    private static final int BYTE_UNIT_CONVERSION = 1000;
    private static final int ICON_SIZE = 16;
    private static final String RED_CIRCLE_ICON_PATH = "org/sleuthkit/autopsy/images/red-circle-exclamation.png";
    private static final String YELLOW_CIRCLE_ICON_PATH = "org/sleuthkit/autopsy/images/yellow-circle-yield.png";
    private static final String DELETE_ICON_PATH = "/org/sleuthkit/autopsy/images/file-icon-deleted.png";
    private static final ImageIcon INTERESTING_SCORE_ICON = new ImageIcon(ImageUtilities.loadImage(YELLOW_CIRCLE_ICON_PATH, false));
    private static final ImageIcon NOTABLE_SCORE_ICON = new ImageIcon(ImageUtilities.loadImage(RED_CIRCLE_ICON_PATH, false));
    private static final ImageIcon DELETED_ICON = new ImageIcon(ImageUtilities.loadImage(DELETE_ICON_PATH, false));

    /**
     * Creates new form DocumentPanel
     */
    public DocumentPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        countLabel = new javax.swing.JLabel();
        isDeletedLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        fileSizeLabel = new javax.swing.JLabel();
        documentType = new javax.swing.JLabel();
        previewScrollPane = new javax.swing.JScrollPane();
        previewTextArea = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        countLabel.setToolTipText(org.openide.util.NbBundle.getMessage(DocumentPanel.class, "DocumentPanel.countLabel.toolTipText")); // NOI18N
        countLabel.setMaximumSize(new java.awt.Dimension(159, 12));
        countLabel.setMinimumSize(new java.awt.Dimension(159, 12));
        countLabel.setPreferredSize(new java.awt.Dimension(159, 12));

        isDeletedLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/file-icon-deleted.png"))); // NOI18N
        isDeletedLabel.setToolTipText(org.openide.util.NbBundle.getMessage(DocumentPanel.class, "DocumentPanel.isDeletedLabel.toolTipText")); // NOI18N
        isDeletedLabel.setMaximumSize(new Dimension(ICON_SIZE,ICON_SIZE));
        isDeletedLabel.setMinimumSize(new Dimension(ICON_SIZE,ICON_SIZE));
        isDeletedLabel.setPreferredSize(new Dimension(ICON_SIZE,ICON_SIZE));

        scoreLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/images/red-circle-exclamation.png"))); // NOI18N
        scoreLabel.setToolTipText(org.openide.util.NbBundle.getMessage(DocumentPanel.class, "DocumentPanel.scoreLabel.toolTipText")); // NOI18N
        scoreLabel.setMaximumSize(new Dimension(ICON_SIZE,ICON_SIZE));
        scoreLabel.setMinimumSize(new Dimension(ICON_SIZE,ICON_SIZE));
        scoreLabel.setPreferredSize(new Dimension(ICON_SIZE,ICON_SIZE));

        fileSizeLabel.setToolTipText(org.openide.util.NbBundle.getMessage(DocumentPanel.class, "DocumentPanel.fileSizeLabel.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(documentType, org.openide.util.NbBundle.getMessage(DocumentPanel.class, "DocumentPanel.documentType.text")); // NOI18N

        previewScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        previewTextArea.setEditable(false);
        previewTextArea.setColumns(20);
        previewTextArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        previewTextArea.setLineWrap(true);
        previewTextArea.setRows(5);
        previewTextArea.setWrapStyleWord(true);
        previewTextArea.setEnabled(false);
        previewTextArea.setFocusable(false);
        previewTextArea.setMaximumSize(new java.awt.Dimension(164, 94));
        previewScrollPane.setViewportView(previewTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(countLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(isDeletedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fileSizeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(previewScrollPane)
                    .addComponent(documentType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(documentType, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isDeletedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @NbBundle.Messages({"# {0} - fileSize",
        "# {1} - units",
        "DocumentPanel.sizeLabel.text=Size: {0} {1}",
        "DocumentPanel.bytes.text=bytes",
        "DocumentPanel.kiloBytes.text=KB",
        "DocumentPanel.megaBytes.text=MB",
        "DocumentPanel.gigaBytes.text=GB",
        "DocumentPanel.terraBytes.text=TB"})
    /**
     * Convert a size in bytes to a string with representing the size in the
     * largest units which represent the value as being greater than or equal to
     * one. Result will be rounded down to the nearest whole number of those
     * units.
     *
     * @param bytes Size in bytes.
     */
    private String getFileSizeString(long bytes) {
        long size = bytes;
        int unitsSwitchValue = 0;
        while (size > BYTE_UNIT_CONVERSION && unitsSwitchValue < 4) {
            size /= BYTE_UNIT_CONVERSION;
            unitsSwitchValue++;
        }
        String units;
        switch (unitsSwitchValue) {
            case 1:
                units = Bundle.DocumentPanel_kiloBytes_text();
                break;
            case 2:
                units = Bundle.DocumentPanel_megaBytes_text();
                break;
            case 3:
                units = Bundle.DocumentPanel_gigaBytes_text();
                break;
            case 4:
                units = Bundle.DocumentPanel_terraBytes_text();
                break;
            default:
                units = Bundle.DocumentPanel_bytes_text();
                break;
        }
        return Bundle.DocumentPanel_sizeLabel_text(size, units);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countLabel;
    private javax.swing.JLabel documentType;
    private javax.swing.JLabel fileSizeLabel;
    private javax.swing.JLabel isDeletedLabel;
    private javax.swing.JScrollPane previewScrollPane;
    private javax.swing.JTextArea previewTextArea;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends DocumentWrapper> list, DocumentWrapper value, int index, boolean isSelected, boolean cellHasFocus) {
        fileSizeLabel.setText(getFileSizeString(value.getResultFile().getFirstInstance().getSize()));
        countLabel.setText(Bundle.ImageThumbnailPanel_countLabel_text(value.getResultFile().getAllInstances().size()));
        documentType.setText("Extension: " + value.getResultFile().getFirstInstance().getNameExtension());  //WJS-TODO fill this in with a document type instead of just DOCUMENT
        previewTextArea.setText(value.getPreview());
        previewTextArea.setCaretPosition(0);
        if (value.getResultFile().isDeleted()) {
            isDeletedLabel.setIcon(DELETED_ICON);
            isDeletedLabel.setToolTipText(Bundle.ImageThumbnailPanel_isDeleted_text());
        } else {
            isDeletedLabel.setIcon(null);
            isDeletedLabel.setToolTipText(null);
        }
        switch (value.getResultFile().getScore()) {
            case NOTABLE_SCORE:
                scoreLabel.setIcon(NOTABLE_SCORE_ICON);
                break;
            case INTERESTING_SCORE:
                scoreLabel.setIcon(INTERESTING_SCORE_ICON);
                break;
            case NO_SCORE:  // empty case - this is interpreted as an intentional fall-through
            default:
                scoreLabel.setIcon(null);
                break;
        }
        scoreLabel.setToolTipText(value.getResultFile().getScoreDescription());
        setBackground(isSelected ? SELECTION_COLOR : list.getBackground());

        return this;
    }

    @Override
    public String getToolTipText(MouseEvent event) {
        if (event != null) {
            //gets tooltip of internal panel item mouse is over
            Point point = event.getPoint();
            for (Component comp : getComponents()) {
                if (isPointOnIcon(comp, point)) {
                    String toolTip = ((JComponent) comp).getToolTipText();
                    if (toolTip == null || toolTip.isEmpty()) {
                        return null;
                    } else {
                        return toolTip;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Helper method to see if point is on the icon.
     *
     * @param comp  The component to check if the cursor is over the icon of
     * @param point The point the cursor is at.
     *
     * @return True if the point is over the icon, false otherwise.
     */
    private boolean isPointOnIcon(Component comp, Point point) {
        return comp instanceof JComponent && point.x >= comp.getX() && point.x <= comp.getX() + ICON_SIZE && point.y >= comp.getY() && point.y <= comp.getY() + ICON_SIZE;
    }
}
