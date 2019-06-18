package com.ha.jpa.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Table(name = "user")
public class UserVO implements Serializable {
	private static final long serialVersionUID = 7761595916523151086L;
	@Id
	private String username;
}
