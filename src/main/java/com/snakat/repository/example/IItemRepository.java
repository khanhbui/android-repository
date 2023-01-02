package com.snakat.repository.example;

import com.snakat.repository.INetworkRepository;
import com.snakat.repository.interactor.INetworkInteractor;

public interface IItemRepository extends INetworkRepository<Item, IItemMemoryInteractor, IItemStorageInteractor, INetworkInteractor<Item>> {
}
