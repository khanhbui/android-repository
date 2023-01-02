package com.snakat.repository;

import com.snakat.repository.interactor.IMemoryInteractor;
import com.snakat.repository.interactor.INetworkInteractor;
import com.snakat.repository.interactor.IStorageInteractor;

import io.reactivex.Observable;

public abstract class NetworkRepository<T, M extends IMemoryInteractor<T>, S extends IStorageInteractor<T>, N extends INetworkInteractor<T>>
        extends StorageRepository<T, M, S> implements INetworkRepository<T, M, S, N> {

    protected final N mNetworkInteractor;

    protected NetworkRepository(M memoryInteractor, S storageInteractor, N networkInteractor) {
        super(memoryInteractor, storageInteractor);

        mNetworkInteractor = networkInteractor;
    }

    @Override
    public Observable<T> get() {
        Observable<T> memoryObservable = mMemoryInteractor.get().toObservable();
        Observable<T> storageObservable = mStorageInteractor.get().toObservable();
        Observable<T> networkObservable = mNetworkInteractor.get().toObservable();
        if (!isInProgress()) {
            mDisposable = Observable.concat(memoryObservable, storageObservable, networkObservable)
                    .filter(this::isDataInDate)
                    .firstElement()
                    .subscribe(data -> {}, this::handleError);
        }

        return mMemoryInteractor.getObservable();
    }
}
