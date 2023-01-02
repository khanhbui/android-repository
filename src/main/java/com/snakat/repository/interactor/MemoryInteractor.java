package com.snakat.repository.interactor;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public abstract class MemoryInteractor<T> implements IMemoryInteractor<T> {

    protected T mData;

    protected BehaviorSubject<T> observable;

    protected MemoryInteractor() {
        observable = BehaviorSubject.create();
    }
    @Override
    public Maybe<T> get() {
        return mData != null ? Maybe.just(mData) : Maybe.empty();
    }

    @Override
    public Observable<T> getObservable() {
        return observable;
    }

    @Override
    public void save(T data) {
        mData = data;
        observable.onNext(mData);
    }
}
