package com.snakat.repository.interactor;

import io.reactivex.Single;

public interface INetworkInteractor<T> extends IInteractor<T> {
    Single<T> get();
}
