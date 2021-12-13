package com.min.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookMemberVo {

	private int member_seq;
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private String auth;
	private String banflag;
	private int declare_count;
	private String member_delflag;

}
