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
        String jsonString = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2020-07-09T01:49:39+0430\",\"lastUpdateDate\":\"2020-07-09T01:49:40.104589+04:30\",\"myLocalDate\":\"20200709\",\"beerId\":\"cd4e6dcc-0c82-4b10-8da1-ad9bb60493c5\"}\n";

        BeerDto beerDto = objectMapper.readValue(jsonString,BeerDto.class);

        System.out.println(beerDto);

    }
}