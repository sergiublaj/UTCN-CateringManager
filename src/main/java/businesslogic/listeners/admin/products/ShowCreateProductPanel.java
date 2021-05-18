package businesslogic.listeners.admin.products;

import businesslogic.Controller;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for showing the create product panel</p>
 */
public class ShowCreateProductPanel implements ActionListener {
   private final Controller appController;
   private final AdminPanel adminPanel;

   public ShowCreateProductPanel(Controller appController, AdminPanel adminPanel) {
      this.appController = appController;
      this.adminPanel = adminPanel;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      adminPanel.clearInputs(0);
      adminPanel.showCreateProductPanel();

      JButton createProductButton = adminPanel.getMenuButtonsArray().get(0);
      createProductButton.setText("CREATE");
      createProductButton.setEnabled(false);

      for (int i = 0; i < 5; i++) {
         adminPanel.clearInput(i);
         appController.addProductNameListener(adminPanel, i);
      }

      adminPanel.clearInput(5);

      appController.addCreateProductButtonListener(adminPanel);
   }
}
