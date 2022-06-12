package com.hardwareStore.hardwareStore.routes;

import com.hardwareStore.hardwareStore.model.BillDTO;
import com.hardwareStore.hardwareStore.model.ProductDTO;
import com.hardwareStore.hardwareStore.model.ProviderDTO;
import com.hardwareStore.hardwareStore.model.ReceiptDTO;
import com.hardwareStore.hardwareStore.usecases.Bill.CreateBillUseCase;
import com.hardwareStore.hardwareStore.usecases.Bill.GetAllBillsUseCase;
import com.hardwareStore.hardwareStore.usecases.Product.AddProductUseCase;
import com.hardwareStore.hardwareStore.usecases.Product.DeleteProductUseCase;
import com.hardwareStore.hardwareStore.usecases.Product.GetAllProductsUseCase;
import com.hardwareStore.hardwareStore.usecases.Product.UpdateProductUseCase;
import com.hardwareStore.hardwareStore.usecases.Provider.AddProviderUseCase;
import com.hardwareStore.hardwareStore.usecases.Provider.DeleteProviderUseCase;
import com.hardwareStore.hardwareStore.usecases.Provider.GetAllProvidersUseCase;
import com.hardwareStore.hardwareStore.usecases.Receipt.CreateReceiptUseCase;
import com.hardwareStore.hardwareStore.usecases.Receipt.GetAllReceiptsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class StoreRouter {

    //get all products
    @Bean
    public RouterFunction<ServerResponse> getProducts(GetAllProductsUseCase getAllProductsUseCase){
        return route(GET("/api/v1/product/all"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProductsUseCase.get(), ProductDTO.class)));
    }

    //get all providers
    @Bean
    public RouterFunction<ServerResponse> getProviders(GetAllProvidersUseCase getAllProvidersUseCase){
        return route(GET("/api/v1/provider/all"), request -> ServerResponse.ok()
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

        return route(POST("/api/v1/product/add")
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

        return route(POST("/api/v1/provider/add")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDTO.class).flatMap(executor));
    }

    //delete product
    @Bean
    RouterFunction<ServerResponse> deleteProduct(DeleteProductUseCase deleteProductUseCase){
        return route(
                DELETE("/api/v1/product/delete/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(deleteProductUseCase.apply(request.pathVariable("id")), Void.class)));
    }

    //delete provider
    @Bean
    RouterFunction<ServerResponse> deleteProvider(DeleteProviderUseCase deleteProviderUseCase){
        return route(
                DELETE("/api/v1/provider/delete/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(deleteProviderUseCase.apply(request.pathVariable("id")), Void.class)));
    }

    //get all bills
    @Bean
    public RouterFunction<ServerResponse> getBills(GetAllBillsUseCase getAllBillsUseCase){
        return route(GET("/api/v1/bill/all"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllBillsUseCase.get(), BillDTO.class)));
    }

    //add new bill
    @Bean
    RouterFunction<ServerResponse> createBill(CreateBillUseCase createBillUseCase){
        Function<BillDTO, Mono<ServerResponse>> executor =
                billDTO -> createBillUseCase.apply(billDTO)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/api/v1/bill/add")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillDTO.class).flatMap(executor));
    }

    //get all receipts
    @Bean
    public RouterFunction<ServerResponse> getReceipts(GetAllReceiptsUseCase getAllReceiptsUseCase){
        return route(GET("/api/v1/receipt/all"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllReceiptsUseCase.get(), ReceiptDTO.class)));
    }

    //add new receipt
    @Bean
    RouterFunction<ServerResponse> createReceipt(CreateReceiptUseCase createReceiptUseCase){
        Function<ReceiptDTO, Mono<ServerResponse>> executor =
                receiptDTO -> createReceiptUseCase.apply(receiptDTO)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/api/v1/receipt/add")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDTO.class).flatMap(executor));
    }

    //update product
    @Bean
    public RouterFunction<ServerResponse> updateProduct(UpdateProductUseCase updateProductUseCase){
        Function<ProductDTO, Mono<ServerResponse>> executor =
                productDTO -> updateProductUseCase.apply(productDTO)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(PUT("/api/v1/product/update")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request
                .bodyToMono(ProductDTO.class)
                .flatMap(executor));
    }

}
