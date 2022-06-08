package routes;

import model.ProductDTO;
import model.ProviderDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import usecases.AddProductUseCase;
import usecases.AddProviderUseCase;
import usecases.GetAllProductsUseCase;
import usecases.GetAllProvidersUseCase;
import usecases.interfaces.AddProvider;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StoreRouter {

    //get all products
    @Bean
    public RouterFunction<ServerResponse> getProducts(GetAllProductsUseCase getAllProductsUseCase){
        return route(GET("/products/all"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProductsUseCase.get(), ProductDTO.class)));
    }

    //get all providers
    @Bean
    public RouterFunction<ServerResponse> getProviders(GetAllProvidersUseCase getAllProvidersUseCase){
        return route(GET("/providers/all"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProvidersUseCase.get(), ProviderDTO.class)));
    }


    //add new product
    @Bean
    RouterFunction<ServerResponse> addProduct(AddProductUseCase addProductUseCase){
        Function<ProductDTO, Mono<ServerResponse>> executor =
                productDTO -> addProductUseCase.apply(productDTO)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/add/product")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class).flatMap(executor));
    }

    //add new provider
    @Bean
    RouterFunction<ServerResponse> addProvider(AddProviderUseCase addProviderUseCase){
        Function<ProviderDTO, Mono<ServerResponse>> executor =
                providerDTO -> addProviderUseCase.apply(providerDTO)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/add/provider")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDTO.class).flatMap(executor));
    }


}
