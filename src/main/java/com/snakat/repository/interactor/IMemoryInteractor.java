package com.snakat.repository.interactor;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface IMemoryInteractor<T> extends IInteractor<T> {
    Maybe<T> get();
    Observable<T> getObservable();
    void save(T data);
}
