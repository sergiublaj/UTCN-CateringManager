package businesslogic.listeners.admin.reports;

import businesslogic.DeliveryService;
import presentation.panels.AdminPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <p>Listener for generate date report button</p>
 */
public class DateReportListener implements ActionListener {
   private final AdminPanel adminPanel;

   public DateReportListener(AdminPanel adminPanel) {
      this.adminPanel = adminPanel;
   }

   @Override
   @SuppressWarnings({"unchecked", "ConstantConditions"})
   public void actionPerformed(ActionEvent e) {
      int selectedIndex = ((JComboBox<String>) adminPanel.getReportInputs().get(2)).getSelectedIndex();
      String selectedDay = (String)((JComboBox<String>) adminPanel.getReportInputs().get(2)).getSelectedItem();
      JTextArea reportField = adminPanel.getFinalReport();

      DeliveryService.getInstance().generateDateReport(selectedIndex, selectedDay, reportField);
   }
}
