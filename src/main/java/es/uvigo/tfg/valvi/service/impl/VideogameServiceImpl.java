package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.uvigo.tfg.valvi.dto.VideogameDto;
import es.uvigo.tfg.valvi.dto.filters.VideogameFiltering;
import es.uvigo.tfg.valvi.mapper.VideogameMapper;
import es.uvigo.tfg.valvi.repository.VideogameRepository;
import es.uvigo.tfg.valvi.service.VideogameService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * The type Videogame service.
 */
@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class VideogameServiceImpl implements VideogameService {
  
  @NonNull
  private VideogameRepository videogameRepository;
  @NonNull
  private VideogameMapper videogameMapper;
  
  @NonNull
  private ObjectMapper objectMapper;
  
  @Override
  public List<VideogameDto> findVideogames(VideogameFiltering videogameFiltering){
    return this.videogameMapper.toVideogameDtoList(this.videogameRepository.findAll());
  }

  @Override
  public VideogameDto upsertVideogame(VideogameDto videogameDto){
    this.videogameRepository.save(this.videogameMapper.toVideogame(videogameDto));
    return videogameDto;
  }
  
  @Override
  public VideogameDto getVideogameById(Integer id){
      return this.videogameMapper.toVideogameDto(this.videogameRepository.findById(id).orElse(null));
  }

  /*@Override
  public VideogameDto getSteamVideogame(Integer id) throws IOException {
    String baseUrl = "store.steampowered.com";
    String urlId = "/api/appdetails?appids=" + id;
    URL obj = new URL("https", baseUrl, urlId);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("appids", String.valueOf(id));
    int responseCode = con.getResponseCode();
    log.info("GET Response Code :: " + responseCode);
    if (responseCode == HttpURLConnection.HTTP_OK) { // success
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuilder response = new StringBuilder();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      return this.objectMapper.readValue(response.substring(29, response.length()-2), VideogameDto.class);
    } else {
      log.error("GET request did not work.");
    }

    return null;
  }*/
  
  @Override
  public Integer deleteVideogame(Integer id){
    this.videogameRepository.deleteById(id);
    return id;
  }
  
}
