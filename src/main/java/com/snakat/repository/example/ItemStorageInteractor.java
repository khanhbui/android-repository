package com.snakat.repository.example;

import com.snakat.repository.interactor.StorageInteractor;

import io.reactivex.Maybe;

class ItemStorageInteractor extends StorageInteractor<Item, IItemMemoryInteractor> implements IItemStorageInteractor {

    protected ItemStorageInteractor(IItemMemoryInteractor memoryInteractor) {
        super(memoryInteractor);
    }

    @Override
    protected Maybe<Item> getFromStorage()
    {
        return Maybe.empty();
    }

    @Override
    protected void saveToStorage(Item data) {
    }
}
