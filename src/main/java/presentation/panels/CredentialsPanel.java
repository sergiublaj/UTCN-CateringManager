package presentation.panels;

import model.User;
import presentation.UIFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * <p>Panel used for registering or logging in an user</p>
 */
public class CredentialsPanel extends JPanel {
   private final String title;
   private final boolean showType;
   private final JLabel titleLabel = UIFactory.createLabel("", "");
   private final JLabel nameLabel = UIFactory.createLabel("Username: ", "");
   private final JTextField nameInput = UIFactory.createInput();
   private final JLabel passwordLabel = UIFactory.createLabel("Password:  ", "");
   private final JPasswordField passwordInput = UIFactory.createPassword();
   private final JLabel typeLabel = UIFactory.createLabel("Type:           ", "");
   private final JComboBox<String> typeInput = UIFactory.createComboBox(new String[]{"client", "employee", "admin"});
   private final JButton actionButton = UIFactory.createButton("", "");

   /**
    * <p>Default constructor</p>
    * @param title panel title
    */
   public CredentialsPanel(String title, boolean showType) {
      this.title = title;
      this.showType = showType;
      this.setUpComponents();
      this.addComponents();
   }

   /**
    * <p>Sets up the components</p>
    */
   private void setUpComponents() {
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.setBorder(BorderFactory.createTitledBorder(title + " panel"));
      UIFactory.initializeTitle(titleLabel);
      titleLabel.setBorder(BorderFactory.createMatteBorder(2, 10, 2, 2, Color.RED));
      if (title.compareTo("Register") == 0) {
         titleLabel.setText("<html><p style='text-align:center'>First time here?<br>Don't hesitate, register now </p></html>");
      } else {
         titleLabel.setText("<html><p style='text-align:center'>Already been here?<br>Log in now and order </p></html>");
      }
      actionButton.setText(title.toUpperCase());
   }

   /**
    * <p>Adds the components to panel</p>
    */
   private void addComponents() {
      this.add(titleLabel);

      JPanel namePanel = new JPanel();
      namePanel.setBorder(new EmptyBorder(20, 0, 0, 0));
      namePanel.add(nameLabel);
      namePanel.add(nameInput);
      this.add(namePanel);

      JPanel passPanel = new JPanel();
      passPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
      passPanel.add(passwordLabel);
      passPanel.add(passwordInput);
      this.add(passPanel);

      if (this.showType) {
         JPanel typePanel = new JPanel();
         typePanel.setBorder(new EmptyBorder(0, 0, 20, 0));
         typePanel.add(typeLabel);
         typePanel.add(typeInput);
         this.add(typePanel);
      } else {
         this.add(Box.createRigidArea(new Dimension(650, 80)));
      }

      this.add(actionButton);
   }

   /**
    * <p>Returns the text from the username desired input</p>
    * @return user's name
    */
   public String getUsername() { return nameInput.getText(); }

   /**
    * <p>Returns the text from the password desired input</p>
    * @return user's password
    */
   public String getPassword() { return new String(passwordInput.getPassword()); }

   /**
    * <p>Returns the text from the type desired input</p>
    * @return user's type
    */
   public String getType() { return Objects.requireNonNull(typeInput.getSelectedItem()).toString();}

   /**
    * <p>Adds event listener for button</p>
    * @param crtListener current event listener
    */
   public void addButtonListener(ActionListener crtListener) { actionButton.addActionListener(crtListener);}

   public User getUser() {
      User newUser = new User();
      newUser.setUsername(getUsername());
      newUser.setPassword(getPassword());
      newUser.setType(getType());
      return newUser;
   }

   public void clearFields() {
      nameInput.setText("");
      passwordInput.setText("");
      typeInput.setSelectedIndex(0);
   }
}
