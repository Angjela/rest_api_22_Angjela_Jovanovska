package clickUpApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Folder {
    @JsonProperty("name")
    public String name;
    @JsonProperty("id")
    public static String id;

    public void setName(final String name) {
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setId(final String id){
        this.id=id;
    }

    public String getId(){
        return id;
    }


}
