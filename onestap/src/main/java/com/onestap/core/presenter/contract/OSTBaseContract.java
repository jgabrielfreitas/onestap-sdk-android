/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.presenter.contract;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface OSTBaseContract {

    interface View {

    }


    interface Presenter<V extends View> {

        void attachView(V baseViewContract);

        void detach();
    }
}
