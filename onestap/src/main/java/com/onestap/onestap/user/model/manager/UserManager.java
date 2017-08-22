/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.user.model.manager;

import android.support.annotation.NonNull;

import com.onestap.onestap.OST;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.onestap.core.service.NetworkConnection;
import com.onestap.onestap.core.util.Logger;
import com.onestap.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.onestap.user.model.domain.entities.TempProfile;
import com.onestap.onestap.user.presenter.contract.UserContract;
import com.onestap.onestap.user.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class UserManager implements UserContract.Manager {

    private UserService service;

    public UserManager() {
        service = NetworkConnection.retrofit(OST.getInstance().getPrivateApiUrl()).create(UserService.class);
    }


    @Override
    public void savePendingProfile(TempProfile body, final CallbackBoundary<PendingProfile> callbackBoundary) {
        service.saveTempProfile(body).enqueue(new Callback<PendingProfile>(){
            @Override
            public void onResponse(@NonNull Call<PendingProfile> call, @NonNull Response<PendingProfile> response) {
                if (response.isSuccessful() && response.body().hasSuccess()) {

                    OST.getInstance().getConfiguration().setDataKey(response.body().getDataKey());
                    callbackBoundary.success(response.body());

                }else if (response.body() == null) {
                    callbackBoundary.error(new Throwable("Unknow error"));
                } else {
                    callbackBoundary.error(new Throwable(response.body().toString()));
                }

            }

            @Override
            public void onFailure(@NonNull Call<PendingProfile> call, Throwable t) {
                Logger.error(t);
                callbackBoundary.error(t);
            }
        });
    }
}
