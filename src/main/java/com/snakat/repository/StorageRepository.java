package com.snakat.repository;

import com.snakat.repository.interactor.IMemoryInteractor;
import com.snakat.repository.interactor.IStorageInteractor;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public abstract class StorageRepository<T, M extends IMemoryInteractor<T>, S extends IStorageInteractor<T>>
        extends MemoryRepository<T, M> implements IStorageRepository<T, M, S> {

    protected final S mStorageInteractor;

    protected Disposable mDisposable;

    protected StorageRepository(M memoryInteractor, S storageInteractor) {
        super(memoryInteractor);

        mStorageInteractor = storageInteractor;
    }

    @Override
    public Observable<T> get() {
        Observable<T> memoryObservable = mMemoryInteractor.get().toObservable();
        Observable<T> storageObservable = mStorageInteractor.get().toObservable();
        if (!isInProgress()) {
            mDisposable = Observable.concat(memoryObservable, storageObservable)
                    .filter(this::isDataInDate)
                    .firstElement()
                    .subscribe(data -> {}, this::handleError);
        }

        return mMemoryInteractor.getObservable();
    }

    protected boolean isInProgress() {
        return mDisposable != null && !mDisposable.isDisposed();
    }

    protected void handleError(Throwable throwable) {
        throw new RuntimeException(throwable);
    }

    protected abstract boolean isDataInDate(T data);
}
