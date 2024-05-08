package study.elixir.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ElixirDto {
    private Map<String, int[]> wisePersons;
    private String selectWisePerson;
    private int ductilityCount;
    private int totalDuctilityCount;
    private String beforeSelectWisePerson;
    private List<Map<String, Map<String, int[]>>> recordWisePersons = new ArrayList<>();
}
