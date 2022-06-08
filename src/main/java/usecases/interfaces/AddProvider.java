package usecases.interfaces;

import model.ProviderDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AddProvider {
    Mono<ProviderDTO> apply (ProviderDTO providerDTO);
}
