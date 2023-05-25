package annotation;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeaderVo {

    @Header("ID")
    private Integer id;


}
