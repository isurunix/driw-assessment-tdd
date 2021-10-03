package dev.isurubuddhika.driw.controller;

import dev.isurubuddhika.driw.dto.ItemPrice;
import dev.isurubuddhika.driw.service.PriceCalculatorService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ItemControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private PriceCalculatorService priceCalculatorService;

    @Test
    @DisplayName("test_get_price_for_product_with_quantity")
    public void getSingleProduct() throws Exception {
        Mockito.when(priceCalculatorService.calculatePrice(1, 1)).thenReturn(new ItemPrice(1,1,175));
        mockMvc.perform(MockMvcRequestBuilders.get("/item/1/price?qty=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.itemId", Matchers.equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity", Matchers.equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.equalTo(175.0d)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("test_get_price_list_for_a_product")
    public void getPriceList() throws Exception {

        List<ItemPrice> priceList = new ArrayList<>(50);
        priceList.add(new ItemPrice(1,1,175));
        priceList.add(new ItemPrice(1,2,2*175));

        Mockito.when(priceCalculatorService.getPriceList(1)).thenReturn(priceList);
        mockMvc.perform(MockMvcRequestBuilders.get("/item/1/price-list").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }
}
