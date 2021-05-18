package businesslogic.listeners.admin.reports;

import businesslogic.DeliveryService;
import presentation.UIFactory;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for generate time report button</p>
 */
public class TimeReportListener implements ActionListener {
   private final AdminPanel adminPanel;

   public TimeReportListener(AdminPanel adminPanel) { this.adminPanel = adminPanel; }

   @Override
   public void actionPerformed(ActionEvent e) {
      int startHour = (int)((JSpinner)adminPanel.getReportInputs().get(0)).getValue();
      int endHour = (int)((JSpinner)adminPanel.getReportInputs().get(1)).getValue();
      JTextArea reportField = adminPanel.getFinalReport();

      DeliveryService.getInstance().generateTimeReport(startHour, endHour, reportField);
   }
}
