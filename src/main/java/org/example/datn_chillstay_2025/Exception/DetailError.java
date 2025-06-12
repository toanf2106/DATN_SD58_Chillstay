package org.example.datn_chillstay_2025.Exception;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DetailError {

  private LocalDateTime timestamp;
  private String message;
  private String details;
}
