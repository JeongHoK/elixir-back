package study.elixir.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.elixir.dto.ElixirDto;
import study.elixir.service.ElixirService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class ElixirController {

    private final ElixirService elixirService;


    @PostMapping("/select")
    public ElixirDto selectWisePerson(@RequestBody ElixirDto elixirDto) {
        return elixirService.selectWisePerson(elixirDto);
    }


}
