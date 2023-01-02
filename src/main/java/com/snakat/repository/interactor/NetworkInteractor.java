package com.snakat.repository.interactor;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public abstract class NetworkInteractor<T, M extends IMemoryInteractor<T>, S extends IStorageInteractor<T>> implements INetworkInteractor<T> {

    protected final M mMemoryInteractor;
    protected  final S mStorageInteractor;

    protected NetworkInteractor(M memoryInteractor, S storageInteractor) {
        mMemoryInteractor = memoryInteractor;
        mStorageInteractor = storageInteractor;
    }

    @Override
    public Single<T> get() {
        return request()
                .subscribeOn(Schedulers.io())
                .doOnSuccess(mStorageInteractor::save)
                .doOnSuccess(mMemoryInteractor::save);
    }

    protected abstract Single<T> request();
}
