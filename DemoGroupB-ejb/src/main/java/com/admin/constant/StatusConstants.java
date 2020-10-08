package com.admin.constant;

import java.util.Arrays;
import java.util.List;

public enum StatusConstants {
    APPROVED("APPROVED"),
    DEACTIVATED("DEACTIVATED"),
    CREATE_APPROVE("CREATE_APPROVE"),
    CREATE_PENDING("CREATE_PENDING"),
    EDIT_APPROVE("EDIT_APPROVE"),
    PASSWORD_EDITED_APPROVED("PASSWORD_EDITED_APPROVED"),
    BLOCKED_APPROVE("BLOCKED_APPROVE"),
    DELETED_APPROVE("DELETED_APPROVE"),
    UNBLOCK_APPROVE("UNBLOCK_APPROVE"),
    PENDING("PENDING"),
    SUBMITTED("SUBMITTED"),
    NOT_SUBMITTED("NOT_SUBMITTED"),
    CREATED("CREATED"),
    EDITED("EDITED"),
    BLOCKED("BLOCKED"),
    UNBLOCKED("UNBLOCKED"),
    DELETED("DELETED"),
    EDIT_PENDING("EDIT_PENDING");
    private final String name;

    private StatusConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static List<String> unUsableStatus() {
        return Arrays.asList(BLOCKED_APPROVE.getName(), DELETED_APPROVE.getName(), DEACTIVATED.getName());
    }

    public static List<String> usableStatus() {
        return Arrays.asList(
                APPROVED.getName(),
                CREATE_APPROVE.getName(),
                EDIT_APPROVE.getName(),
                UNBLOCK_APPROVE.getName()
        );
    }

    public static List<String> deleteStatusList() {
        return Arrays.asList(DELETED_APPROVE.getName(), DEACTIVATED.getName());
    }

    public static List<String> manageableStatus() {
        return Arrays.asList(CREATE_APPROVE.getName(), EDIT_APPROVE.getName(), BLOCKED_APPROVE.getName(), APPROVED.getName(), UNBLOCK_APPROVE.getName());
    }

    public static List<String> approvedStatus() {
        return Arrays.asList(CREATE_APPROVE.getName(), EDIT_APPROVE.getName(), UNBLOCK_APPROVE.getName());
    }

    public static List<String> notEditableStatus() {
        return Arrays.asList(BLOCKED_APPROVE.getName());
    }

    public static boolean isExists(String statusName) {
        for (StatusConstants status : Arrays.asList(StatusConstants.values())) {
            if (status.getName().equalsIgnoreCase(statusName)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> blockedStatus() {
        return Arrays.asList(BLOCKED_APPROVE.getName());
    }

    public static List<String> getApproveAndDumpStatus() {
        return Arrays.asList(BLOCKED_APPROVE.getName(), APPROVED.getName());
    }

    public static List<String> getUserSearchStatusList() {
        return Arrays.asList(APPROVED.getName(),
                CREATED.getName(), EDITED.getName(),
                BLOCKED.getName(),
                DELETED.getName(), UNBLOCKED.getName());
    }

    public static List<String> deleteAndBlockedStatusList() {
        return Arrays.asList(DELETED_APPROVE.getName(), DEACTIVATED.getName(), BLOCKED_APPROVE.getName());
    }
}
