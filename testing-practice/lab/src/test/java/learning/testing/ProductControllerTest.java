package learning.testing;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ProductControllerTest {
    @Test
    void getReturnsJson() throws Exception {
        ProductService service = mock(ProductService.class);
        when(service.get(1L)).thenReturn(new Product(1L, "Book", 3));
        MockMvc mvc = MockMvcBuilders.standaloneSetup(new ProductController(service)).build();
        mvc.perform(get("/products/1"))
            .andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Book"));
    }
    @Test
    void missingProductReturns404() throws Exception {
        ProductService service = mock(ProductService.class);
        when(service.get(9L)).thenThrow(new ProductNotFoundException(9L));
        MockMvc mvc = MockMvcBuilders.standaloneSetup(new ProductController(service)).build();
        mvc.perform(get("/products/9")).andExpect(status().isNotFound());
    }
}
