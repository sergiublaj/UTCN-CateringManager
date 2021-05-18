package presentation;

import presentation.panels.CredentialsPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * <p>Main application frame</p>
 */
public class MainFrame extends JFrame {
   public static final String APP_TITLE = "Catering manager";

   private static final int APP_WIDTH = 900;
   private static final int APP_HEIGHT = 600;
   private static final int IMAGE_WIDTH = 150;
   private static final int IMAGE_HEIGHT = 450;

   private final JPanel contentPanel = new JPanel();
   private final JPanel imagePanel = new JPanel();
   private final JPanel mainPanel = new JPanel();
   private final CredentialsPanel registerPanel = new CredentialsPanel("Register", true);
   private final CredentialsPanel loginPanel = new CredentialsPanel("Login", false);

   private static final MainFrame INSTANCE = new MainFrame();
   /**
    * <p>Default constructor</p>
    */
   private MainFrame() {
      this.setUpFrame();
      this.setUpContentPanel();
      this.addLeftSideInformation();
      this.addMainPanelComponents();
   }

   public static MainFrame getInstance() {
      return INSTANCE;
   }

   /**
    * <p>Sets up the frame</p>
    */
   private void setUpFrame() {
      this.setLocation(300, 150);

      this.setMinimumSize(new Dimension(APP_WIDTH, APP_HEIGHT));
      this.setResizable(false);
      this.setTitle(APP_TITLE);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   /**
    * <p>Sets up the frame panel</p>
    */
   private void setUpContentPanel() {
      contentPanel.setLayout(new BorderLayout());
      contentPanel.setBackground(Color.LIGHT_GRAY);
      this.setContentPane(contentPanel);
   }

   /**
    * <p>Adds information on the left side of GUI</p>
    */
   private void addLeftSideInformation() {
      this.setUpImagePanel();
      this.addCateringImage();
      this.addAuthorInfo();
   }

   /**
    * <p>Sets up the image panel</p>
    */
   private void setUpImagePanel() {
      imagePanel.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
      imagePanel.setLayout(new BorderLayout());
      contentPanel.add(imagePanel, BorderLayout.WEST);
   }

   /**
    * <p>Adds the catering image</p>
    */
   private void addCateringImage() {
      JLabel mathImage = new JLabel();
      mathImage.setIcon(new ImageIcon("src/main/resources/images/app/catering.png"));
      imagePanel.add(mathImage, BorderLayout.CENTER);
   }

   /**
    * <p>Adds information about the developer</p>
    */
   private void addAuthorInfo() {
      JLabel shortInfo = new JLabel("<html>Ver: 1.14_22.51<br>" +
         "@ author Blaj Sergiu<br>" +
         "@ group 30225</html>");
      shortInfo.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
      shortInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
      shortInfo.setForeground(Color.WHITE);
      shortInfo.setBackground(Color.BLACK);
      shortInfo.setOpaque(true);
      imagePanel.add(shortInfo, BorderLayout.SOUTH);
   }

   /**
    * <p>Adds components to main panel</p>
    */
   private void addMainPanelComponents() {
      this.setUpMainPanel();
      this.showRegisterLoginPanel();
   }

   /**
    * <p>Sets up main panel</p>
    */
   private void setUpMainPanel() {
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      contentPanel.add(mainPanel, BorderLayout.CENTER);
   }

   /**
    * <p>Adds application title</p>
    */
   private void addAppTitle() {
      JLabel appTitle = new JLabel(APP_TITLE.toUpperCase());
      appTitle.setFont(new Font("Impact", Font.BOLD, 40));
      appTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
      mainPanel.add(appTitle);
   }

   public void showRegisterLoginPanel() {
      JPanel midPanel = new JPanel(new GridLayout(1, 2, 5, 0));
      midPanel.setBorder(new EmptyBorder(75, 0, 100, 0));

      registerPanel.clearFields();
      loginPanel.clearFields();

      midPanel.add(registerPanel);
      midPanel.add(loginPanel);
      this.setMainPanelComponents(midPanel);
   }

   public Component[] getMainPanelComponents() { return ((JPanel)mainPanel.getComponents()[1]).getComponents(); }

   public void setMainPanelComponents(JPanel newPanel) {
      mainPanel.removeAll();
      this.addAppTitle();
      mainPanel.add(newPanel);
      mainPanel.revalidate();
      mainPanel.repaint();
   }
}