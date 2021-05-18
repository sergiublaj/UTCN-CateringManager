package businesslogic;

import businesslogic.listeners.LoginListener;
import businesslogic.listeners.ProductNameListener;
import businesslogic.listeners.RegisterListener;
import businesslogic.listeners.admin.products.*;
import businesslogic.listeners.admin.reports.*;
import businesslogic.listeners.client.*;
import presentation.MainFrame;
import presentation.UIFactory;
import presentation.panels.*;

/**
 * <p>Class used for adding button event listeners</p>
 */
public class Controller {
   private final MainFrame mainFrame;

   public Controller(MainFrame mainFrame) {
      this.mainFrame = mainFrame;
      this.addEventListeners();
   }

   private void addEventListeners() {
      if (mainFrame.getMainPanelComponents()[0] instanceof CredentialsPanel) {
         CredentialsPanel registerPanel = (CredentialsPanel) mainFrame.getMainPanelComponents()[0];
         CredentialsPanel loginPanel = (CredentialsPanel) mainFrame.getMainPanelComponents()[1];

         registerPanel.addButtonListener(new RegisterListener(mainFrame, registerPanel, this));
         loginPanel.addButtonListener(new LoginListener(mainFrame, loginPanel, this));
      }
   }

   public void addLogoutButtonListener(Navbar navbar) {
      navbar.addLogoutButtonListener(e -> {
         if (UIFactory.showConfirm("Are you sure you want to log out?") == 0) {
            mainFrame.showRegisterLoginPanel();
         }
      });
   }

   public void addClientListeners(ClientPanel clientPanel) {
      clientPanel.addMenuButtonListener(new ShowViewProductsPanel(clientPanel), 1);
      clientPanel.addMenuButtonListener(new ShowSearchProductPanel(this, clientPanel), 2);
      clientPanel.addMenuButtonListener(new ShowPlaceOrderPanel(this, clientPanel), 3);
   }

   public void addProductFormListener(ClientPanel clientPanel, int fieldNb) {
      clientPanel.addProductFormListeners(new ProductFormFilter(clientPanel), fieldNb);
   }

   public void addPlaceOrderButtonListener(ClientPanel clientPanel) {
      clientPanel.addMenuButtonListener(new PlaceOrderListener(clientPanel), 0);
   }

   public void addProductNameListener(UserPanel userPanel, int fieldNb) {
      userPanel.addProductFormListeners(new ProductNameListener(userPanel, fieldNb), fieldNb);
   }

   public void addAdminListeners(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new ShowImportProductsPanel(this, adminPanel), 1);
      adminPanel.addMenuButtonListener(new ShowManageProductsPanel(this, adminPanel), 2);
      adminPanel.addMenuButtonListener(new ShowGenerateReportsPanel(this, adminPanel), 3);
   }

   public void addImportProductsButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new ImportProductsListener(adminPanel), 0);
   }

   public void addManageProductsListener(AdminPanel adminPanel) {
      if (adminPanel.getMenuButtonsArray().size() == 8) {
         adminPanel.getMenuButtonsArray().remove(7);
         adminPanel.getMenuButtonsArray().remove(6);
         adminPanel.getMenuButtonsArray().remove(5);
         adminPanel.getMenuButtonsArray().remove(4);
      }

      adminPanel.getMenuButtonsArray().add(UIFactory.createButton("Add", "button/create.png"));
      adminPanel.getMenuButtonsArray().add(UIFactory.createButton("Delete", "button/remove.png"));
      adminPanel.getMenuButtonsArray().add(UIFactory.createButton("Modify", "button/edit.png"));
      adminPanel.getMenuButtonsArray().add(UIFactory.createButton("Create", "button/view.png"));

      adminPanel.addMenuButtonListener(new ShowAddProductPanel(this, adminPanel), 4);
      adminPanel.addMenuButtonListener(new ShowDeleteProductPanel(this, adminPanel), 5);
      adminPanel.addMenuButtonListener(new ShowModifyProductPanel(this, adminPanel), 6);
      adminPanel.addMenuButtonListener(new ShowCreateProductPanel(this, adminPanel), 7);
   }

   public void addAddProductButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new AddProductListener(adminPanel), 0);
   }

   public void addDeleteProductButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new DeleteProductListener(adminPanel), 0);
   }

   public void addModifyProductButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new ModifyProductListener(adminPanel), 0);
   }

   public void addCreateProductButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new CreateProductListener(adminPanel), 0);
   }

   public void addGenerateReportsListener(AdminPanel adminPanel) {
      if (adminPanel.getMenuButtonsArray().size() == 8) {
         adminPanel.getMenuButtonsArray().remove(7);
         adminPanel.getMenuButtonsArray().remove(6);
         adminPanel.getMenuButtonsArray().remove(5);
         adminPanel.getMenuButtonsArray().remove(4);
      }

      adminPanel.getMenuButtonsArray().add(UIFactory.createButton("Time", "button/time.png"));
      adminPanel.getMenuButtonsArray().add(UIFactory.createButton("Stock", "button/stock.png"));
      adminPanel.getMenuButtonsArray().add(UIFactory.createButton("Rich", "button/rich.png"));
      adminPanel.getMenuButtonsArray().add(UIFactory.createButton("Date", "button/date.png"));

      adminPanel.addMenuButtonListener(new ShowTimeReportPanel(this, adminPanel), 4);
      adminPanel.addMenuButtonListener(new ShowStockReportPanel(this, adminPanel), 5);
      adminPanel.addMenuButtonListener(new ShowRichReportPanel(this, adminPanel), 6);
      adminPanel.addMenuButtonListener(new ShowDateReportPanel(this, adminPanel), 7);
   }

   public void addTimeReportButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new TimeReportListener(adminPanel), 0);
   }

   public void addStockReportButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new StockReportListener(adminPanel), 0);
   }

   public void addRichReportButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new RichReportListener(adminPanel), 0);
   }

   public void addDateReportButtonListener(AdminPanel adminPanel) {
      adminPanel.addMenuButtonListener(new DateReportListener(adminPanel), 0);
   }
}
