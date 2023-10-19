package 设计模式.结构型模式.享元模式;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private int total; // 库存总量
    private int used; // 库存已⽤
}
