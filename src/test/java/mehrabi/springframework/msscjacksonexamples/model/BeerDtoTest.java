package mehrabi.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserializeDto() throws JsonProcessingException {
        String jsonString = "{\"id\":\"973a2c55-33ea-4972-8162-a623142576e6\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2020-07-08T17:11:36.3071613+03:00\",\"lastUpdateDate\":\"2020-07-08T17:11:36.8170942+03:00\"}\n";

        BeerDto beerDto = objectMapper.readValue(jsonString,BeerDto.class);

        System.out.println(beerDto);

    }
}