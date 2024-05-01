package study.elixir.service;

import org.springframework.stereotype.Service;
import study.elixir.dto.ElixirDto;
import study.elixir.module.BaseElixir;

@Service
public class ElixirService {

    public ElixirDto selectWisePerson(ElixirDto reqElixirDto) {

        BaseElixir baseElixir = new BaseElixir(reqElixirDto);

        baseElixir.resetSelectSimulation();
        baseElixir.select(reqElixirDto.getSelectWisePerson());
        ElixirDto elixirDto = baseElixir.selectSimulation();

        return elixirDto;
    }

}
