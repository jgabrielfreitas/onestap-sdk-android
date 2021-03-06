/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.auth.model.domain.entities;


import com.onestap.core.model.domain.entities.BaseResponse;

/**
 * Created by jcosilva on 6/8/2017.
 */

public class AuthToken extends BaseResponse {
    private String accessToken;
    private String tokenCreateDate;
    private String tokenExpiryDate;
    private String refreshToken;
    private String userKey;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Object getTokenCreateDate() {
        return tokenCreateDate;
    }

    public void setTokenCreateDate(String tokenCreateDate) {
        this.tokenCreateDate = tokenCreateDate;
    }

    public Object getTokenExpiryDate() {
        return tokenExpiryDate;
    }

    public void setTokenExpiryDate(String tokenExpiryDate) {
        this.tokenExpiryDate = tokenExpiryDate;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "accessToken=" + accessToken +
                ", tokenCreateDate=" + tokenCreateDate +
                ", tokenExpiryDate=" + tokenExpiryDate +
                ", refreshToken=" + refreshToken +
                ", userKey=" + userKey +
                ", success=" + hasSuccess() +
                ", operationReport=" + getOperationReport() +
                '}';
    }
}
