/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.login.view.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebViewClient;

import com.onestap.OST;
import com.onestap.onestap.R;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.core.view.ui.activity.OSTBaseActivity;
import com.onestap.login.presenter.LoginPresenter;
import com.onestap.login.presenter.contract.LoginContract;
import com.onestap.login.view.ui.LoginWebViewClient;

import java.util.UUID;

public final class LoginActivity extends OSTBaseActivity implements LoginContract.View {

    public static AuthCallback authCallback;
    private LoginContract.Presenter presenter;
    private String uuid;

    @Override
    protected String urlToLoad() {
        return OST.getInstance().getLoginUrl();
    }

    @Override
    protected WebViewClient client() {
        uuid = UUID.randomUUID().toString();
        return new LoginWebViewClient(uuid, authCallback);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Uri uri = getIntent().getData();
        presenter = new LoginPresenter(this);
        presenter.attachView(this);
        if (uri != null) {
            showProgress();
            String authCode = uri.getQueryParameter("code");
            presenter.loadCredentials(authCode);
        } else {
            if (OST.getInstance().getTempProfile() != null) {
                presenter.saveTemporaryProfile(OST.getInstance().getTempProfile());
            } else {
                loadWebView();
            }
        }
    }



    @Override
    public void goToWebView() {
        loadWebView();
    }

    @Override
    public void loginWithSuccess(AuthToken token) {
        authCallback.success(token);
        finish();
    }

    @Override
    public void loginFailed(Throwable t) {
        authCallback.error(t);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }
}