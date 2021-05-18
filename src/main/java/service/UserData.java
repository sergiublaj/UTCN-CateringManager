package service;

import model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Class that manipulates user models</p>
 */
public class UserData extends ObjectData {
   private static final String USER_FILE = "data/users.ser";

   public static boolean registerUser(User newUser) {
      Set<User> userList = UserData.loadUsers();
      newUser.setId(userList.size() + 1);

      return userList.add(newUser) && writeObject(userList, USER_FILE);
   }

   public static User loginUser(String userName) {
      Set<User> userList = UserData.loadUsers();

      for (User crtUser : userList) {
         if (crtUser.getUsername().compareTo(userName) == 0) {
            return crtUser;
         }
      }

      return null;
   }

   @SuppressWarnings("unchecked")
   private static Set<User> loadUsers() {
      Set<User> availableUsers;

      availableUsers = (HashSet<User>) readObject(USER_FILE);

      if (availableUsers == null) {
         availableUsers = new HashSet<>();
      }

      return availableUsers;
   }

   public static User findUser(int userId) {
      Set<User> allUsers = UserData.loadUsers();

      for (User crtUser : allUsers) {
         if (crtUser.getId() == userId) {
            return crtUser;
         }
      }
      return null;
   }
}
