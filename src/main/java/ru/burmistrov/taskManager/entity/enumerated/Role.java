package ru.burmistrov.taskManager.entity.enumerated;

import org.springframework.security.core.GrantedAuthority;

import java.lang.reflect.Proxy;

public enum Role implements GrantedAuthority {

    ADMINISTRATOR,
    COMMON_USER;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
