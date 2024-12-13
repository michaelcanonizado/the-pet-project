package com.mycompany.thepetproject;

/**
 *
 * @author lilac
 */

import com.mycompany.thepetproject.frames.Home;
import com.mycompany.thepetproject.utils.auth.AdminAuthentication;
import com.mycompany.thepetproject.utils.auth.UserAuthentication;
import com.mycompany.thepetproject.utils.auth.SessionManager;
import com.mycompany.thepetproject.utils.auth.AuthenticationStrategy;

public class ThePetProject {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
        
        SessionManager sessionManager = SessionManager.getInstance();

        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please log in.");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Determine if the user is an admin or a user
        System.out.print("Are you logging in as an Admin? (yes/no): ");
        String roleInput = scanner.nextLine().trim().toLowerCase();
        String role = roleInput.equals("yes") ? "Admin" : "User";

        // Use the appropriate authentication strategy
        AuthenticationStrategy strategy = role.equals("Admin")
                ? new AdminAuthentication()
                : new UserAuthentication();

        // Authenticate and set the session
        if (sessionManager.authenticate(username, password, strategy, role)) {
            System.out.println(role + " login successful!");
        } else {
            System.out.println("Invalid credentials. You are logged in as a Guest.");
        }

        // Display different views based on the role
        if (sessionManager.isLoggedIn()) {
            if (sessionManager.getCurrentUserRole().equals("Admin")) {
                System.out.println("Showing admin dashboard...");
            } else {
                System.out.println("Showing user dashboard...");
            }
        } else {
            System.out.println("Showing guest dashboard...");
        }

        // Simulate logout
        sessionManager.logout();
        System.out.println("Logged out. Current role: " + sessionManager.getCurrentUserRole());
    }
}
