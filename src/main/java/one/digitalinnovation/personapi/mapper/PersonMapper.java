package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    // interface para converter e mapear a data corretamente, passar de person para personDTO pois a data está com localdate

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);//conversao

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy") // mapeando data com formato corretamente
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
