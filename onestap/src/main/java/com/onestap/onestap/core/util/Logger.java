/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.util;

import android.util.Log;

import com.onestap.onestap.BuildConfig;

/**
 * Created on 22/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class Logger {

    static final String TAG = BuildConfig.APPLICATION_ID;

    public static void error(Throwable t){
        Log.e(TAG, t.getMessage(), t);
    }
}