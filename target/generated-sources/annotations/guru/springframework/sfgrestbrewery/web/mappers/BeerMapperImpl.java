package guru.springframework.sfgrestbrewery.web.mappers;

import guru.springframework.sfgrestbrewery.domain.Beer;
import guru.springframework.sfgrestbrewery.domain.Beer.BeerBuilder;
import guru.springframework.sfgrestbrewery.web.model.BeerDto;
import guru.springframework.sfgrestbrewery.web.model.BeerDto.BeerDtoBuilder;
import guru.springframework.sfgrestbrewery.web.model.BeerStyleEnum;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-21T11:53:02-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id( beer.getId() );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( beer.getBeerStyle().name() );
        }
        beerDto.upc( beer.getUpc() );
        beerDto.price( beer.getPrice() );
        beerDto.quantityOnHand( beer.getQuantityOnHand() );
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );

        return beerDto.build();
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id( beer.getId() );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( beer.getBeerStyle().name() );
        }
        beerDto.upc( beer.getUpc() );
        beerDto.price( beer.getPrice() );
        beerDto.quantityOnHand( beer.getQuantityOnHand() );
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto dto) {
        if ( dto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( dto.getId() );
        beer.beerName( dto.getBeerName() );
        if ( dto.getBeerStyle() != null ) {
            beer.beerStyle( Enum.valueOf( BeerStyleEnum.class, dto.getBeerStyle() ) );
        }
        beer.upc( dto.getUpc() );
        beer.quantityOnHand( dto.getQuantityOnHand() );
        beer.price( dto.getPrice() );
        beer.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );

        return beer.build();
    }
}
