package businesslogic.listeners.admin.reports;

import businesslogic.DeliveryService;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for generate rich report button</p>
 */
public class RichReportListener implements ActionListener {
   private final AdminPanel adminPanel;

   public RichReportListener(AdminPanel adminPanel) { this.adminPanel = adminPanel; }

   @Override
   public void actionPerformed(ActionEvent e) {
      int orderedAmount = (int) ((JSpinner) adminPanel.getReportInputs().get(0)).getValue();
      int orderValue = (int) ((JSpinner) adminPanel.getReportInputs().get(1)).getValue();
      JTextArea reportField = adminPanel.getFinalReport();

      DeliveryService.getInstance().generateRichReport(orderedAmount, orderValue, reportField);
   }
}
