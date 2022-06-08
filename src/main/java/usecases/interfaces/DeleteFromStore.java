package usecases.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteFromStore {
    Mono<Void> apply(String id);
}
