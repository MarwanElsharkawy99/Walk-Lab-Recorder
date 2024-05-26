package dev.Sharkawy.Runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(Integer id,
                  @NotEmpty
                  String title,
                  LocalDateTime startDate,
                  LocalDateTime endDate ,
                  @Positive
                  Integer miles,
                  Location location) {


}





