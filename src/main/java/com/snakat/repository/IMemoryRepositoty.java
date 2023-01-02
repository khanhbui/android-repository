package com.snakat.repository;

import com.snakat.repository.interactor.IMemoryInteractor;

public interface IMemoryRepositoty<T, M extends IMemoryInteractor<T>>
        extends IRepository<T> {
}
