package businesslogic.listeners.admin.reports;

import businesslogic.Controller;
import presentation.panels.AdminPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for showing date report panel</p>
 */
public class ShowDateReportPanel implements ActionListener {
   private final Controller appController;
   private final AdminPanel adminPanel;

   public ShowDateReportPanel(Controller appController, AdminPanel adminPanel) {
      this.appController = appController;
      this.adminPanel = adminPanel;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      adminPanel.getFinalReport().setText("");
      adminPanel.showDateReportPanel();

      appController.addDateReportButtonListener(adminPanel);
   }
}
