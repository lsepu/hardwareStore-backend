package routes;

import model.ProductDTO;
import model.ProviderDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import usecases.GetAllProductsUseCase;
import usecases.GetAllProvidersUseCase;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
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


    //add new provider



}
