package com.cg.ovs.dto;

import com.cg.ovs.dto.UsersRequest;
import com.cg.ovs.entities.Users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersRequest {

	private Users users;
}
