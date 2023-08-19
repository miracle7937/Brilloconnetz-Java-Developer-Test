package com.brilloconnetz.brilloconnetz;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question1 {
static String secreteKey = "a3bF9pS5yH2zD1vC8mX6oP4va3bF9pS5yH2zD1vC8mX6oP4";

    public static void main(String[] args) {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dobString = scanner.nextLine();

        if (validateInputs(username, email, password, dobString)) {
            System.out.println("All validations passed!");
            String token = generateToken(username);
            System.out.println("Generated Token: " + token);
            String verificationResult = verifyToken(token);
            System.out.println("Token Verification Result: " + verificationResult);
        } else {
            System.out.println("Validation failed for the following fields:");
            Map<String, String> failedValidations = getFailedValidations(username, email, password, dobString);
            for (Map.Entry<String, String> entry : failedValidations.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static boolean validateInputs(String username, String email, String password, String dobString) {
        return validateUsername(username) &&
                validateEmail(email) &&
                validatePassword(password) &&
                validateDateOfBirth(dobString);
    }

    public static boolean validateUsername(String username) {
        return username != null && username.length() >= 4;
    }

    public static boolean validateEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean validatePassword(String password) {
        return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$");
    }

    public static boolean validateDateOfBirth(String dobString) {
        if (dobString == null) return false;

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate dob = LocalDate.parse(dobString, dateFormatter);
            LocalDate today = LocalDate.now();
            Period age = Period.between(dob, today);
            return age.getYears() >= 16;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static Map<String, String> getFailedValidations(String username, String email, String password, String dobString) {
        Map<String, String> failedValidations = new HashMap<>();
        if (!validateUsername(username)) {
            failedValidations.put("Username", "Min length: 4 characters");
        }
        if (!validateEmail(email)) {
            failedValidations.put("Email", "Invalid email format");
        }
        if (!validatePassword(password)) {
            failedValidations.put("Password", "Min length: 8 characters, at least 1 upper case, 1 special character, 1 number");
        }
        if (!validateDateOfBirth(dobString)) {
            failedValidations.put("Date of Birth", "Age must be 16 years or greater");
        }
        return failedValidations;
    }

    public static String generateToken(String username) {
        SecretKey secretKey = new SecretKeySpec(secreteKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        Instant now = Instant.now();
        Instant expiration = now.plus(1, ChronoUnit.DAYS);
        String key = "yourSecretKeyForJWT"; // Replace with a secure secret key
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(expiration)) // Token expires in 24 hours
                .signWith(secretKey)
                .compact();
    }

    public static String verifyToken(String token) {
        SecretKey secretKey = new SecretKeySpec(secreteKey.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return "Verification pass";
        } catch (JwtException e) {
            return "Verification fails";
        }
    }
}
