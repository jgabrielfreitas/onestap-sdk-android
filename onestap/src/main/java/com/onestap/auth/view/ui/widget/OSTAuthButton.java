/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.auth.view.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;

import com.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.core.view.ui.widget.OSTButton;

/**
 * Created on 17/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class OSTAuthButton extends OSTButton {


    public OSTAuthButton(Context context) {
        super(context);
    }

    public OSTAuthButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OSTAuthButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAccountCallback(AuthCallback authCallback) {
        OSTAuthActivity.authCallback = authCallback;
    }

    @Override
    public void onClick(View view) {
        getContext().startActivity(new Intent(getContext(), OSTAuthActivity.class));
    }
}
