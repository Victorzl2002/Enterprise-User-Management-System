package org.victor.usercenterbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Victor_zl
 * @version: 1.0
 * @Description:
 */
@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = 12312312321312L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}