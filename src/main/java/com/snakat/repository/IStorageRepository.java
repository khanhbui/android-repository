package com.snakat.repository;

import com.snakat.repository.interactor.IMemoryInteractor;
import com.snakat.repository.interactor.IStorageInteractor;

public interface IStorageRepository<T, M extends IMemoryInteractor<T>, S extends IStorageInteractor<T>>
        extends IMemoryRepositoty<T, M> {
}
