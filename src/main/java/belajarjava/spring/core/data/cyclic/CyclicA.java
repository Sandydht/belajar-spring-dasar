package belajarjava.spring.core.data.cyclic;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@RequiredArgsConstructor
public class CyclicA {
    @Autowired
    private CyclicB cyclicB;

    public CyclicA(CyclicB cyclicB) {}
}
