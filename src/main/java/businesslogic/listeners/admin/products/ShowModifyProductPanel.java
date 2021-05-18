package businesslogic.listeners.admin.products;

import businesslogic.Controller;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for showing the modify product panel</p>
 */
public class ShowModifyProductPanel implements ActionListener {
   private final Controller appController;
   private final AdminPanel adminPanel;

   public ShowModifyProductPanel(Controller appController, AdminPanel adminPanel) {
      this.appController = appController;
      this.adminPanel = adminPanel;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      adminPanel.clearInputs(0);
      adminPanel.showSearchProductPanel("Modify");

      JButton addProductButton = adminPanel.getMenuButtonsArray().get(0);
      addProductButton.setText("MODIFY");
      addProductButton.setEnabled(false);

      appController.addProductNameListener(adminPanel, -1);
      appController.addModifyProductButtonListener(adminPanel);
   }
}
