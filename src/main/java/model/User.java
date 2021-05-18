package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * <p>Model class for an entry in 'user' file</p>
 */
public class User implements Serializable {
   @Serial
   private static final long serialVersionUID = 3212112364826093568L;

   private int id;
   private String username;
   private String password;
   private String type;

   /**
    * <p>Default constructor without parameters</p>
    */
   public User() {
   }

   /**
    * <p>Getter for id</p>
    * @return id of user
    */
   public int getId() {
      return id;
   }

   /**
    * <p>Setter for id</p>
    * @param id new id of user
    */
   public void setId(int id) {
      this.id = id;
   }

   /**
    * <p>Getter for username</p>
    * @return username of user
    */
   public String getUsername() {
      return username;
   }

   /**
    * <p>Setter for username</p>
    * @param username new username of user
    */
   public void setUsername(String username) {
      this.username = username;
   }

   /**
    * <p>Getter for username</p>
    * @return username of user
    */
   public String getPassword() {
      return password;
   }

   /**
    * <p>Setter for password</p>
    * @param password new password of user
    */
   public void setPassword(String password) {
      this.password = password;
   }

   /**
    * <p>Getter for type</p>
    * @return type of user
    */
   public String getType() {
      return type;
   }

   /**
    * <p>Setter for type</p>
    * @param type new type of user
    */
   public void setType(String type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return username + " [id: " + id + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(username);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return Objects.equals(username, user.username);
   }
}
