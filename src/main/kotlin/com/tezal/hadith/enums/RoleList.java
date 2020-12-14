package com.tezal.hadith.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RoleList implements GrantedAuthority {
  ROLE_ADMIN, ROLE_CLIENT;

  public String getAuthority() {
    return name();
  }

}
