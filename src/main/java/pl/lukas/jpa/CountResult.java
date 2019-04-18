package pl.lukas.jpa;

import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class CountResult {

    private String name;
    private long count;
}
