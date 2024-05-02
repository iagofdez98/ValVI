package es.uvigo.tfg.valvi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ReducedVideogameDto {
  
  public Integer appid;
  
  public String name;

}
