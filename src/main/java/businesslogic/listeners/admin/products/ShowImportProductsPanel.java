package businesslogic.listeners.admin.products;

import businesslogic.Controller;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for showing the import products panel</p>
 */
public class ShowImportProductsPanel implements ActionListener {
   private final Controller appController;
   private final AdminPanel adminPanel;

   public ShowImportProductsPanel(Controller appController, AdminPanel adminPanel) {
      this.appController = appController;
      this.adminPanel = adminPanel;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      appController.addImportProductsButtonListener(adminPanel);

      JButton generateReportButton = adminPanel.getMenuButtonsArray().get(0);
      generateReportButton.setText("IMPORT");
      generateReportButton.setEnabled(true);

      adminPanel.showImportProductsPanel();
   }
}
