package com.ha.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@TableGenerator(
		name = "BOARD_SEQ_GENERATOR",
		table = "MY_SEQUENCES",
		pkColumnName = "SEQUENCE_NAME",
		pkColumnValue = "BOARD_SEQ",
		allocationSize = 1)
@NamedQuery(
		name = "Board.findByHello",
		query = "select m from Board m where m.id = :id")
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private BOARDTYPE type = BOARDTYPE.ADMIN;
	
	@Enumerated(EnumType.ORDINAL)
	private BOARDTYPE value = BOARDTYPE.ADMIN;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();
	
	@Lob
	private String lobString; //clob 으로 매핑 char[]
	
	@Lob
	private byte[] lobByte;	//그외 blob 으로 매핑 byte[]
	
	@Transient
	private String temp = "임시저장소";

	public enum BOARDTYPE{
		ADMIN(0), USER(1);
		
		public final int value;
		
		BOARDTYPE(int value) {
			this.value = value;
		}
	}
}
