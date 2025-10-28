package edu.vv.hw2;

/**
 * Decision-table candidate.
 */
public class AccessController {

    public enum Role { ADMIN, USER, GUEST }
    public enum Action { VIEW, EDIT, DENY }

    public Action determineAccess(Role role, boolean isOwner, boolean isPublic, boolean isBanned) {
        if (isBanned) return Action.DENY;
        if (role == Role.ADMIN) return Action.EDIT;
        if (isOwner) return Action.EDIT;
        if (isPublic) return Action.VIEW;
        return Action.DENY;
    }
}
