package com.snakat.repository;

import com.snakat.repository.interactor.IMemoryInteractor;

import io.reactivex.Observable;

public abstract class MemoryRepository<T, M extends IMemoryInteractor<T>> extends Repository<T>
        implements IMemoryRepositoty<T, M> {

    protected final M mMemoryInteractor;

    protected MemoryRepository(M memoryInteractor) {
        mMemoryInteractor = memoryInteractor;
    }

    @Override
    public Observable<T> get() {
        return mMemoryInteractor.get().toObservable();
    }

}
