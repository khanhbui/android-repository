package com.snakat.repository.interactor;

import io.reactivex.Maybe;

public interface IStorageInteractor<T> extends IInteractor<T> {
    Maybe<T> get();
    void save(T data);
}
