package businesslogic.listeners.admin.products;

import businesslogic.Controller;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for showing the add product panel</p>
 */
public class ShowAddProductPanel implements ActionListener {
   private final Controller appController;
   private final AdminPanel adminPanel;

   public ShowAddProductPanel(Controller appController, AdminPanel adminPanel) {
      this.appController = appController;
      this.adminPanel = adminPanel;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      adminPanel.clearInputs(1);
      adminPanel.showSearchProductPanel("Add");

      JButton addProductButton = adminPanel.getMenuButtonsArray().get(0);
      addProductButton.setText("ADD");
      addProductButton.setEnabled(true);

      appController.addAddProductButtonListener(adminPanel);
   }
}
