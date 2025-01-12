package belajarjava.spring.core.data.cyclic;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@RequiredArgsConstructor
public class CyclicC {
    @Autowired
    private CyclicA cyclicA;

    public CyclicC(CyclicA cyclicA) {}
}
