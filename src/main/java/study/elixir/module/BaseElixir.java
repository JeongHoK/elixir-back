package study.elixir.module;

import org.springframework.stereotype.Component;
import study.elixir.dto.ElixirDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseElixir {

    private Map<String, int[]> wisePersons;
    private int ductilityCount;
    private int totalDuctilityCount;
    private String selectWisePerson;
    private String beforeSelectWisePerson;
    private int beforeDuctilityCount;
    private List<Map<String, Map<String, int[]>>> recordWisePersons;

    public BaseElixir(ElixirDto elixirDto) {

        this.totalDuctilityCount = elixirDto.getTotalDuctilityCount();

        this.wisePersons = new HashMap<>();

        this.wisePersons.put("rebedo", elixirDto.getWisePersons().get("rebedo"));
        this.wisePersons.put("viriditas", elixirDto.getWisePersons().get("viriditas"));
        this.wisePersons.put("citrini", elixirDto.getWisePersons().get("citrini"));

        this.ductilityCount = elixirDto.getDuctilityCount();
        this.selectWisePerson = elixirDto.getSelectWisePerson();
        this.totalDuctilityCount = elixirDto.getTotalDuctilityCount();
        this.beforeSelectWisePerson = elixirDto.getBeforeSelectWisePerson();
        this.recordWisePersons = elixirDto.getRecordWisePersons();

    }

    public void select(String selectWisePerson) {
        this.ductilityCount++;

        for (String wisePerson: this.wisePersons.keySet()) {
            int[] wisePersonArray  = this.wisePersons.get(wisePerson);

            if(wisePerson.equals(selectWisePerson)) {
                if(selectWisePerson.equals(this.beforeSelectWisePerson)) {
                    if(wisePersonArray[this.ductilityCount - 1] >= 3) {
                        wisePersonArray[this.ductilityCount] = 1;
                    } else {
                        wisePersonArray[this.ductilityCount] += wisePersonArray[this.ductilityCount - 1] + 1;
                    }
                } else {
                    wisePersonArray[this.ductilityCount] = 1;
                }
            } else {
                if(wisePerson.equals(this.beforeSelectWisePerson)) {
                    wisePersonArray[this.ductilityCount] = 1;
                } else {
                    if(wisePersonArray[this.ductilityCount - 1] >= 6) {
                        wisePersonArray[this.ductilityCount] = 1;
                    } else {
                        wisePersonArray[this.ductilityCount] += wisePersonArray[this.ductilityCount - 1] + 1;
                    }
                }
            }
            this.wisePersons.put(wisePerson, wisePersonArray);
        }

        this.beforeSelectWisePerson = selectWisePerson;


    }

    public void resetSelectSimulation() {
        for (String wisePerson: this.wisePersons.keySet()) {
            int[] wisePersonArray  = this.wisePersons.get(wisePerson);

            for (int i = ductilityCount+1; i < this.totalDuctilityCount; i++) {
                wisePersonArray[i] = 0;
            }

            this.wisePersons.put(wisePerson, wisePersonArray);
        }
    }

    public ElixirDto selectSimulation() {
        this.beforeDuctilityCount = this.ductilityCount;

        for (int i = this.ductilityCount; i < this.totalDuctilityCount - 1; i++) {
            select(this.beforeSelectWisePerson);
        }

        this.ductilityCount = this.beforeDuctilityCount;

        ElixirDto elixirDto = new ElixirDto();

        elixirDto.setWisePersons(this.wisePersons);
        elixirDto.setSelectWisePerson(this.selectWisePerson);
        elixirDto.setDuctilityCount(this.ductilityCount);
        elixirDto.setTotalDuctilityCount(this.totalDuctilityCount);


        Map<String, Map<String, int[]>> map = new HashMap<>();
        map.put(this.selectWisePerson, elixirDto.getWisePersons());

        this.recordWisePersons.add(map);
        elixirDto.setRecordWisePersons(this.recordWisePersons);

        return elixirDto;

    }

}

