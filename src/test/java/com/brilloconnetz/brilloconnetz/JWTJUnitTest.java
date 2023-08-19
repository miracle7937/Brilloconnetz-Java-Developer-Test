package com.brilloconnetz.brilloconnetz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JWTJUnitTest {
    String validToken = Question1.generateToken("user123");

    @Test
    public void testValidTokenVerification() {
        assertEquals(Question1.verifyToken(validToken), "Verification pass", "Token verification passed");
    }

    @Test
    public void testInvalidTokenVerification() {
        assertEquals(Question1.verifyToken(validToken), "Verification fails", "Token verification passed");
    }
}
