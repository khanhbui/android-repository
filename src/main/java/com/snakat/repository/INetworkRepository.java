package com.snakat.repository;

import com.snakat.repository.interactor.IMemoryInteractor;
import com.snakat.repository.interactor.INetworkInteractor;
import com.snakat.repository.interactor.IStorageInteractor;

public interface INetworkRepository<T, M extends IMemoryInteractor<T>, S extends IStorageInteractor<T>, N extends INetworkInteractor<T>>
        extends IStorageRepository<T, M, S> {
}
