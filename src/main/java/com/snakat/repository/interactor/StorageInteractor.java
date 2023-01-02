package com.snakat.repository.interactor;

import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;

public abstract class StorageInteractor<T, M extends IMemoryInteractor<T>> implements IStorageInteractor<T> {

    protected final M mMemoryInteractor;

    protected StorageInteractor(M memoryInteractor) {
        mMemoryInteractor = memoryInteractor;
    }

    @Override
    public Maybe<T> get() {
        return getFromStorage()
                .subscribeOn(Schedulers.io())
                .doOnSuccess(mMemoryInteractor::save);
    }

    @Override
    public void save(T data) {
        saveToStorage(data);
    }

    protected abstract Maybe<T> getFromStorage();
    protected abstract void saveToStorage(T data);
}
