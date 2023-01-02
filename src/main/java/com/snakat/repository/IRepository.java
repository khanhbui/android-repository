package com.snakat.repository;

import io.reactivex.Observable;

public interface IRepository<T> {
    Observable<T> get();
}
