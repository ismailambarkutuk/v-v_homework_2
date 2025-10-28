package edu.vv.hw2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Decision table (rules) for determineAccess:
 * Columns: isBanned, role, isOwner, isPublic -> Expected Action
 * R1:  true,  any,  any,  any -> DENY
 * R2:  false, ADMIN, any, any -> EDIT
 * R3:  false, USER,  true, any -> EDIT
 * R4:  false, USER,  false, true -> VIEW
 * R5:  false, GUEST, false, true -> VIEW
 * R6:  false, any,   false, false -> DENY
 */
class AccessControllerDecisionTableTest {

    @ParameterizedTest(name = "Rule {index}: banned={0}, role={1}, owner={2}, public={3} -> {4}")
    @CsvSource({
        // R1
        "true, ADMIN, false, false, DENY",
        "true, USER,  true,  true,  DENY",
        // R2
        "false, ADMIN, false, false, EDIT",
        // R3
        "false, USER,  true,  false, EDIT",
        // R4
        "false, USER,  false, true,  VIEW",
        // R5
        "false, GUEST, false, true,  VIEW",
        // R6
        "false, USER,  false, false, DENY",
        "false, GUEST, false, false, DENY"
    })
    void decisionTableRules(boolean banned, String roleStr, boolean owner, boolean pub, String expected) {
        AccessController ac = new AccessController();
        AccessController.Role role = AccessController.Role.valueOf(roleStr);
        AccessController.Action action = ac.determineAccess(role, owner, pub, banned);
        assertEquals(AccessController.Action.valueOf(expected), action);
    }
}
