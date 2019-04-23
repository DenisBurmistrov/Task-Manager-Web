package ru.burmistrov.taskManager.entity.enumerated;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMINISTRATOR,
    COMMON;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
