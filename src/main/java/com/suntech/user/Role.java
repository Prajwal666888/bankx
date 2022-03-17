package com.suntech.user;

import javax.persistence.*;

import com.suntech.domain.IdDomain;

@Entity
@Table(name = "role")
public class Role extends IdDomain{

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;

  public Role() {

  }

  public Role(ERole name) {
    this.name = name;
  }

  public ERole getName() {
    return name;
  }

  public void setName(ERole name) {
    this.name = name;
  }
}