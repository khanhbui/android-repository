package com.snakat.repository.example;

import com.snakat.repository.StorageRepository;

public class ItemRepository extends StorageRepository<Item, IItemMemoryInteractor, IItemStorageInteractor> implements IItemRepository {

    public static IItemRepository create() {
        IItemMemoryInteractor memoryInteractor = new ItemMemoryInteractor();
        IItemStorageInteractor storageInteractor = new ItemStorageInteractor(memoryInteractor);
        return new ItemRepository(memoryInteractor, storageInteractor);
    }

    protected ItemRepository(IItemMemoryInteractor memoryInteractor, IItemStorageInteractor storageInteractor) {
        super(memoryInteractor, storageInteractor);
    }

    @Override
    protected boolean isDataInDate(Item data) {
        return true;
    }
}
