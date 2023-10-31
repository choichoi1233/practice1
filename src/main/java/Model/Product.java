package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {



    private String name;
    private int price;

}