package guru.springframework.sfgrestbrewery.web.functional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by jt on 4/11/21.
 */
@Configuration
public class BeerRouterConfig {

    public static final String BEER_V2_URL = "/api/v2/beer";
    public static final String BEER_V2_URL_ID = "/api/v2/beer/{beerId}";
    public static final String BEER_V2_URL_UPC = "/api/v2/beerUpc";

    @Bean
    public RouterFunction<ServerResponse> beerRoutesV2(BeerHandlerV2 handler){
        return route()
                .GET(BEER_V2_URL_ID, accept(APPLICATION_JSON), handler::getBeerById)
                .GET(BEER_V2_URL_UPC + "/{upc}", accept(APPLICATION_JSON), handler::getBeerByUPC)
                .POST(BEER_V2_URL, accept(APPLICATION_JSON), handler::saveNewBeer)
                .PUT(BEER_V2_URL_ID, accept(APPLICATION_JSON), handler::updateBeer)
                .DELETE(BEER_V2_URL_ID, accept(APPLICATION_JSON), handler::deleteBeer)
                .build();
    }
}
















