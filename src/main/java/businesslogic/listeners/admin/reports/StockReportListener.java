package businesslogic.listeners.admin.reports;

import businesslogic.DeliveryService;
import presentation.UIFactory;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for generate stock report button</p>
 */
public class StockReportListener implements ActionListener {
   private final AdminPanel adminPanel;

   public StockReportListener(AdminPanel adminPanel) {
      this.adminPanel = adminPanel;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      int orderedAmount = (int) ((JSpinner) adminPanel.getReportInputs().get(0)).getValue();
      JTextArea reportField = adminPanel.getFinalReport();

      DeliveryService.getInstance().generateStockReport(orderedAmount, reportField);
   }
}
