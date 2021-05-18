package businesslogic.listeners.admin.products;

import businesslogic.Controller;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for showing the delete product panel</p>
 */
public class ShowDeleteProductPanel implements ActionListener {
   private final Controller appController;
   private final AdminPanel adminPanel;

   public ShowDeleteProductPanel(Controller appController, AdminPanel adminPanel) {
      this.appController = appController;
      this.adminPanel = adminPanel;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      adminPanel.clearInputs(0);
      adminPanel.showSearchProductPanel("Delete");

      JButton addProductButton = adminPanel.getMenuButtonsArray().get(0);
      addProductButton.setText("DELETE");
      addProductButton.setEnabled(false);

      appController.addProductNameListener(adminPanel, -1);
      appController.addDeleteProductButtonListener(adminPanel);
   }
}
